package org.gensis0.lib.dacia.commons.exception;

public class InvalidRequestException extends Exception {

	public InvalidRequestException() {
		super("ERROR:[非法请求.]");
	}

	public InvalidRequestException(String message, Throwable cause) {
		super("ERROR:[非法请求." + message + "]", cause);
	}

	public InvalidRequestException(String message) {
		super("ERROR:[非法请求." + message + "]");
	}

}
