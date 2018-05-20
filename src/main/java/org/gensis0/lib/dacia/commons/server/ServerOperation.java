package org.gensis0.lib.dacia.commons.server;

import org.gensis0.lib.dacia.commons.StatusInfo;
import org.gensis0.lib.dacia.commons.exception.ServerConfigurationException;

/**
 * 服务器操作抽象。
 * 
 * @author yihan
 *
 */
public interface ServerOperation {

	/**
	 * 启动服务器。
	 * 
	 * @return
	 * @throws ServerConfigurationException
	 */
	public Server start() throws ServerConfigurationException;

	/**
	 * 关闭服务器。
	 * 
	 * @return
	 */
	public boolean stop();

	/**
	 * 获取服务器当前状态。
	 * 
	 * @return
	 * @throws ServerConfigurationException
	 */
	public StatusInfo getStatus() throws ServerConfigurationException;
}
