package org.gensis0.lib.dacia.commons.service;

/**
 * 通用服务接口。
 * 
 * @author yihan
 *
 */
public interface ServiceHandler {

	/**
	 * 服务名称。
	 * 
	 * @return
	 */
	public String serviceName();

	/**
	 * 服务范围。
	 * 
	 * @return
	 */
	public ServiceScope serviceScope();

	/**
	 * 是否启用运行计时。
	 * 
	 * @return
	 */
	public boolean isCountTime();

	/**
	 * 运行计时。
	 * 
	 * @return
	 */
	public long countTime();
}
