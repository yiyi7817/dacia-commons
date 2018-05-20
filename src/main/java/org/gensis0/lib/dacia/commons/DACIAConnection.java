package org.gensis0.lib.dacia.commons;

import java.util.Map;

import org.gensis0.lib.dacia.commons.utils.RandomUtils;

public abstract class DACIAConnection {

	public final static int CONNECTION_DATABASE = 11;
	public final static int CONNECTION_TCP = 21;
	public final static int CONNECTION_HTTP = 22;
	public final static int CONNECTION_OTHER = 31;
	public final static int CONNECTION_RPC = 24;
	public final static int CONNECTION_UDP = 25;
	public final static int CONNECTION_LOCAL = 41;

	public final static int SECURITY_ENABLED = 1;
	public final static int SECURITY_NOT_ENABLED = 0;

	public final static int CONNECTION_OPTION_IP = 1000;
	public final static int CONNECTION_OPTION_USERNAME = 1001;
	public final static int CONNECTION_OPTION_PASSWORD = 1002;
	public final static int CONNECTION_OPTION_PORT = 1003;

	private String connectionName;
	private long connectionId;
	private int connectionType;
	private int enableSecurity;
	private Map<Integer, String> option;

	public DACIAConnection(String connectionName, int connectionType) {
		super();
		this.connectionName = connectionName;
		this.connectionType = connectionType;
	}

	public DACIAConnection(int connectionType) {
		super();
		this.connectionType = connectionType;
		this.connectionName = new RandomUtils().genRandomString("yyyyMMddHHmmss", 6);
	}

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public int getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(int connectionType) {
		this.connectionType = connectionType;
	}

	public int getEnableSecurity() {
		return enableSecurity;
	}

	public void setEnableSecurity(int enableSecurity) {
		this.enableSecurity = enableSecurity;
	}

	public Map<Integer, String> getOption() {
		return option;
	}

	public void setOption(Map<Integer, String> option) {
		this.option = option;
	}

	public abstract boolean validConnection();

	public long getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(long connectionId) {
		this.connectionId = connectionId;
	}

}
