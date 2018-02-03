package org.example.dummy.dto;

import org.example.dummy.model.Message;
import org.springframework.beans.BeanUtils;

/**
 * A conduit class for Message Entity.
 * @author sadekrahman
 *
 */
public class MessageDTO {
	String text;

	public MessageDTO(Message message) {
		BeanUtils.copyProperties(message, this);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
