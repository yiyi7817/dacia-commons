package org.gensis0.lib.dacia.commons.service;

/**
 * 服务范围，用于限定服务的范围控制。
 * 
 * @author yihan
 *
 */
public interface ServiceScope {

	/**
	 * 初始化范围。
	 * 
	 * @param scopeId
	 * @param label
	 * @return
	 */
	public ServiceScope initial(long scopeId, String label);

	/**
	 * 获取范围的具体id。
	 * 
	 * @return
	 */
	public Long value();

	/**
	 * 通过id获取范围对象。
	 * 
	 * @param id
	 * @return
	 */
	public ServiceScope scope(long id);
}
