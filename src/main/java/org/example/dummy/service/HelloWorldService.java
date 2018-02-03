package org.example.dummy.service;

import org.example.dummy.dto.MessageDTO;

/**
 * Sends a Heelo Massage to End user
 * 
 * @author sadekrahman
 *
 */
public interface HelloWorldService {
	/**
	 * Processes and Sends The message
	 * 
	 * @return
	 */
	MessageDTO getGreeting();

}
