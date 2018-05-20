package org.gensis0.lib.dacia.commons.exception;

public class NoRefererException extends Exception {

	public NoRefererException() {
		super("ERROR:[非法请求.]");
	}

	public NoRefererException(String message, Throwable cause) {
		super("ERROR:[非法请求." + message + "]", cause);
	}

	public NoRefererException(String message) {
		super("ERROR:[非法请求." + message + "]");
	}

}
