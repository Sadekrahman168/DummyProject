package org.example.dummy.impl;

import java.util.Base64;
import org.example.dummy.restClient.RestResponseHandler;
import org.example.dummy.service.ExternalService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * This class and associated methods are responsible to make External API calls
 * 
 * @author sadekrahman
 *
 */
@Service
public class ExternalServiceImpl implements ExternalService {

	@Value("${public.api.jsonplaceholder.baseuri}")
	private String BASE_URI;

	@Value("${public.api.jsonplaceholder.username: test}")
	private String apiUserName;
	@Value("${public.api.jsonplaceholder.password: test}")
	private String apiPassword;

	public void setBASE_URI(String bASE_URI) {
		BASE_URI = bASE_URI;
	}

	RestTemplate restTemplate;

	public ExternalServiceImpl() {
		restTemplate = new RestTemplate();
		// ====== If Authentication is Required , BTW: this is not required for this
		// REST call.
		String credentials = Base64.getEncoder().encodeToString((apiUserName + ":" + apiPassword).getBytes());
		restTemplate.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().add("Authorization", "Basic " + credentials);
			return execution.execute(request, body);
		});

	}

	@Override
	public Object getContent(String queryParam) {

		final StringBuilder finalUrl = new StringBuilder();
		finalUrl.append(BASE_URI);
		if (null != queryParam) {
			finalUrl.append(queryParam);
		}
		/**
		 * 
		 * TODO : Should have a fault-back Route is case of External service is Down or
		 * something. Hystrix Would be nice solution.
		 * 
		 */
		return (Object) RestResponseHandler.handle(() -> restTemplate.getForEntity(finalUrl.toString(), Object.class));
	}

}
