package org.gensis0.lib.dacia.commons.server;

import org.gensis0.lib.dacia.commons.exception.ServerConfigurationException;

/**
 * 服务器管理初始操作抽象。
 * 
 * @author yihan
 *
 */
public interface ServerManagement {

	/**
	 * 获取服务器名称。
	 * 
	 * @return
	 */
	public String serverName();

	/**
	 * 创建默认的服务器配置管理器。
	 * 
	 * @return
	 */
	public ServerConfigurationBuilder initialConfigBuilder();

	/**
	 * 自定义服务器配置，并获取相关操作对象。
	 * 
	 * @param config
	 * @return
	 * @throws ServerConfigurationException
	 */
	public Server customServer(ServerConfiguration config) throws ServerConfigurationException;

	/**
	 * 生成默认的服务器配置，并获取相关操作对象。
	 * 
	 * @return
	 * @throws ServerConfigurationException
	 */
	public Server defaultServer() throws ServerConfigurationException;
}
