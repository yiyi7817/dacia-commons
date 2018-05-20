package org.gensis0.lib.dacia.commons.data.connection;

import org.gensis0.lib.dacia.commons.data.exception.DACIADataConnectionException;

/**
 * 数据连接管理器。<br />
 * 用于管理数据连接，包含生成、配置等。
 * 
 * @author yihan
 *
 */
public interface DACIADataConnectionManagement {

	public String connectionName();

	/**
	 * 获取连接实例。
	 * 
	 * @return
	 * @throws DACIADataConnectionException
	 */
	public DACIADataConnection get() throws DACIADataConnectionException;

	/**
	 * 配置连接管理器。
	 * 
	 * @param config
	 * @return
	 * @throws DACIADataConnectionException
	 */
	public DACIADataConnectionManagement config(ConnectionConfiguration config) throws DACIADataConnectionException;
}
