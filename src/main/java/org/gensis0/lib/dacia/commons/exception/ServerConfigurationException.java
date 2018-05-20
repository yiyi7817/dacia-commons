package org.gensis0.lib.dacia.commons.exception;


public class ServerConfigurationException extends CommonException {
	private static final long serialVersionUID = -7164133178468803227L;

	public ServerConfigurationException(String msg) {
		super(msg);
	}

	public ServerConfigurationException(String msg, Throwable e) {
		super(msg, e);
	}

}
