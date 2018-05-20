package org.gensis0.lib.dacia.commons.data.database;

import org.gensis0.lib.dacia.commons.data.connection.ConnectionConfiguration;
import org.gensis0.lib.dacia.commons.data.connection.DACIADataConnection;
import org.gensis0.lib.dacia.commons.data.connection.DACIADataConnectionManagement;
import org.gensis0.lib.dacia.commons.data.exception.DACIADataConnectionException;

public class DatabaseConnectionManagement implements DACIADataConnectionManagement {

	public static String V_2001000001 = "DATABASE_CONNECTION";
	/**
	 * 连接类型，jdbc/datasource
	 */
	public static String V_2001000005 = "conn_type";
	/**
	 * 用户名
	 */
	public static String V_2001000002 = "username";
	/**
	 * 连接地址串
	 */
	public static String V_2001000003 = "url";
	/**
	 * 密码
	 */
	public static String V_2001000004 = "password";

	private ConnectionConfiguration config;

	@Override
	public DACIADataConnection get() throws DACIADataConnectionException {
		if (config.exist(DatabaseConnectionManagement.V_2001000002)
				&& config.exist(DatabaseConnectionManagement.V_2001000003)
				&& config.exist(DatabaseConnectionManagement.V_2001000004)) {

		}
		return null;
	}

	@Override
	public DACIADataConnectionManagement config(ConnectionConfiguration config) throws DACIADataConnectionException {
		this.config = config;
		return this;
	}

	@Override
	public String connectionName() {
		return DatabaseConnectionManagement.V_2001000001;
	}

}
