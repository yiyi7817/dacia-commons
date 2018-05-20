package org.gensis0.lib.dacia.commons.exception;


public class ServerOperationException extends CommonException {
	private static final long serialVersionUID = -7164133178468803227L;

	public ServerOperationException(String msg) {
		super(msg);
	}

	public ServerOperationException(String msg, Throwable e) {
		super(msg, e);
	}

}
