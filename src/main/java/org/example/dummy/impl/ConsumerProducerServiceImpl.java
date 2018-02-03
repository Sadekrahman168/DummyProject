package org.example.dummy.impl;

import org.example.dummy.model.ConsumerProducer;
import org.example.dummy.service.ConsumerProducerService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Service class to simulate a deadlock condition.
 * 
 * @author sadekrahman
 *
 */
@Service
public class ConsumerProducerServiceImpl implements ConsumerProducerService {

	private static final int _WAIT_TIME = 50;
	private static final int _MAX_EXECUTOR_WAIT_TIME = 15;

	/**
	 * This method creates a deadlock, where two thread Lock each other for shared
	 * resource.
	 * 
	 */
	@Override
	public void process() {

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		final ConsumerProducer producer = new ConsumerProducer();
		final ConsumerProducer consumer = new ConsumerProducer();

		try {
			// == Create two tasks, eventually there will be a race condition and ended up on a deadlock. 
			Runnable thread1Task = () -> {
				synchronized (producer) {
					try {
						TimeUnit.MILLISECONDS.sleep(_WAIT_TIME);
					} catch (InterruptedException ignore) {
						System.err.println("thread1Task");
					}
					synchronized (consumer) {

					}

				}
			};

			Runnable thread2Task = () -> {
				synchronized (consumer) {
					try {
						TimeUnit.MILLISECONDS.sleep(_WAIT_TIME);
					} catch (InterruptedException ignore) {
						System.err.println("thread12Task");
					}
					synchronized (producer) {

					}

				}
			};

			// == Run the tasks
			executorService.submit(thread1Task);
			executorService.submit(thread2Task);
			// == Try to perform graceful Shutdown.
			executorService.shutdown();
			// == Wait up to the time specified. 
			executorService.awaitTermination(_MAX_EXECUTOR_WAIT_TIME, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			if (!executorService.isTerminated()) {
				throw new RuntimeException("Deadlock detected!");
			}
			executorService.shutdownNow();
		}

	}

}