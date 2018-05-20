package org.gensis0.lib.dacia.commons.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Logger log = LoggerFactory.getLogger(CommonException.class);

	public CommonException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommonException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CommonException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CommonException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
