package org.gensis0.lib.dacia.commons.server;

import java.util.List;

import org.gensis0.lib.dacia.commons.core.Tuple;

public interface Server extends ServerOperation {

	/**
	 * 获取服务器名称，名称是相当于标签一类的意思。
	 * 
	 * @return
	 */
	public String getServerName();

	/**
	 * 获取服务器实例ID。当服务器生成后，其实例ID应为唯一的。
	 * 
	 * @return
	 */
	public long getId();

	/**
	 * 获取服务器配置。
	 * 
	 * @return
	 */
	public List<Tuple> getConfiguration();

}
