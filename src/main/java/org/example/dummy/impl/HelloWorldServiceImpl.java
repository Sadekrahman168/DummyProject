package org.example.dummy.impl;

import org.example.dummy.dto.MessageDTO;
import org.example.dummy.model.Message;
import org.example.dummy.service.HelloWorldService;
import org.springframework.stereotype.Service;

/**
 * Sends a Heelo Massage to End user
 * 
 * @author sadekrahman
 *
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	/**
	 * Processes and Sends The message
	 */
	@Override
	public MessageDTO getGreeting() {
		return new MessageDTO(new Message("Hello World"));

	}

}
