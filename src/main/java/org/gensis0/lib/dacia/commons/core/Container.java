package org.gensis0.lib.dacia.commons.core;

import org.gensis0.lib.dacia.commons.StatusInfo;
import org.gensis0.lib.dacia.commons.exception.ContainerExecutionException;

public interface Container {

	/**
	 * 获取容器名称。
	 * 
	 * @return
	 */
	public String getContainerName();

	/**
	 * 创建容器，并且获取容器实例ID。
	 * 
	 * @return
	 */
	public long genContainerId();

	/**
	 * 容器存放对象的默认大小。
	 * 
	 * @return
	 */
	public int size();

	/**
	 * 容器存放对象的最大大小。
	 * 
	 * @return
	 */
	public int maxSize();

	/**
	 * 是否自动增长容器容量。
	 * 
	 * @return
	 */
	public boolean autoIncre();

	/**
	 * 是否延迟销毁对象。
	 * 
	 * @return
	 */
	public boolean delay();

	/**
	 * 是否健康检查。
	 * 
	 * @return
	 */
	public boolean healthCheck();

	/**
	 * 容器状态。
	 * 
	 * @return
	 */
	public StatusInfo status();

	public <T> T get() throws ContainerExecutionException;
}
