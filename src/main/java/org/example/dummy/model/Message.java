package org.example.dummy.model;

/**
 * A conduit class for Greeting or simple message holder
 * 
 * @author sadekrahman
 *
 */
public class Message {

	String text;

	public Message() {

	}

	public Message(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
