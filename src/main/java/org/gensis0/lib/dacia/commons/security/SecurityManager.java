package org.gensis0.lib.dacia.commons.security;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceLoader;

import org.gensis0.lib.dacia.commons.exception.CommonConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 安全管理器的管理单元，用于获取和生成安全管理器。
 * 
 * @author yihan
 *
 */
public class SecurityManager {
	private static Logger log = LoggerFactory.getLogger(SecurityManager.class);

	public static SecurityManagement getSecurityManagement(String managerName) throws CommonConfigException {
		// 与jvm进行交互，切勿更改
		AccessController.doPrivileged(new PrivilegedAction<Void>() {
			public Void run() {
				ServiceLoader<SecurityManagement> loadedSecurityManagements = ServiceLoader
						.load(SecurityManagement.class);
				Iterator<SecurityManagement> securityManagementIterator = loadedSecurityManagements.iterator();
				try {
					while (securityManagementIterator.hasNext()) {
						// 需要走一遍所有获取到的实现类，否则jvm不会装载类
						SecurityManagement securityManagement = securityManagementIterator.next();
						log.debug("已搜索到安全管理器：" + securityManagement.getSecurityManagementName());
					}
				} catch (Throwable t) {
					// Do nothing
				}
				return null;
			}
		});

		for (SecurityManagement s : ServiceLoader.load(SecurityManagement.class)) {
			if (s.getSecurityManagementName().equals(managerName)) {
				log.debug("已成功获取安全管理器。" + managerName);
				return s;
			}
		}
		log.warn("找不到此类安全管理器[" + managerName + "]");
		throw new CommonConfigException("找不到此类安全管理器[" + managerName + "]");
	}
}
