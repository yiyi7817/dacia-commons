package org.gensis0.lib.dacia.commons.security;

public interface SecurityManagement {

	/**
	 * 获取安全管理器名称。
	 * 
	 * @return
	 */
	public String getSecurityManagementName();

	/**
	 * 获取管理器的管理行为。
	 * 
	 * @return
	 */
	public SecurityManagementOps getOperations();

}
