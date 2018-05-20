package org.gensis0.lib.dacia.commons.server;

import org.gensis0.lib.dacia.commons.core.Tuple;
import org.gensis0.lib.dacia.commons.exception.ServerConfigurationException;

/**
 * 服务器配置管理器，用于提供友好的配置方式，并生成服务器配置。
 * 
 * @author yihan
 *
 */
public interface ServerConfigurationBuilder {

	/**
	 * 生成服务器配置。
	 * 
	 * @return
	 * @throws ServerConfigurationException
	 */
	public ServerConfiguration build() throws ServerConfigurationException;

	public ServerConfigurationBuilder addConfig(Tuple... configItems) throws ServerConfigurationException;
}
