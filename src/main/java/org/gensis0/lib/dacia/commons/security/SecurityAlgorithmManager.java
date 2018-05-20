package org.gensis0.lib.dacia.commons.security;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceLoader;

import org.gensis0.lib.dacia.commons.exception.CommonConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecurityAlgorithmManager {
	private static Logger log = LoggerFactory.getLogger(SecurityAlgorithmManager.class);

	public static SecurityAlgorithmOps getSecurityAlgorithmOps(String algorithmName) throws CommonConfigException {
		// 与jvm进行交互，切勿更改
		AccessController.doPrivileged(new PrivilegedAction<Void>() {
			public Void run() {
				ServiceLoader<SecurityAlgorithmOps> loadedSecurityManagements = ServiceLoader
						.load(SecurityAlgorithmOps.class);
				Iterator<SecurityAlgorithmOps> securityManagementIterator = loadedSecurityManagements.iterator();
				try {
					while (securityManagementIterator.hasNext()) {
						// 需要走一遍所有获取到的实现类，否则jvm不会装载类
						SecurityAlgorithmOps securityManagement = securityManagementIterator.next();
						log.debug("已搜索到算法：" + securityManagement.getAlgorithmName());
					}
				} catch (Throwable t) {
					// Do nothing
				}
				return null;
			}
		});

		for (SecurityAlgorithmOps s : ServiceLoader.load(SecurityAlgorithmOps.class)) {
			if (s.getAlgorithmName().equals(algorithmName)) {
				log.debug("已成功获取算法。" + algorithmName);
				return s;
			}
		}
		log.warn("找不到此类算法[" + algorithmName + "]");
		throw new CommonConfigException("找不到此类算法[" + algorithmName + "]");
	}
}
