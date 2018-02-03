package org.example.dummy.model;

import java.util.LinkedList;
import java.util.UUID;

/**
 * Helper class to mock consumer-producer deadlock situation.
 * 
 * @author sadekrahman
 *
 */
public class ConsumerProducer {

	LinkedList<Integer> dataList;

	public ConsumerProducer() {
		dataList = new LinkedList<>();
	}

	/**
	 * Producer, adds data to the list
	 */
	public void produce() {
		UUID uuid = UUID.randomUUID();
		dataList.add(uuid.variant());

	}

	/**
	 * Consumes data, remove from the list.
	 * 
	 */
	public void consume() {

		if (dataList.size() > 0) {
			dataList.removeFirst();
		}

	}

}