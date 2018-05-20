package org.gensis0.lib.dacia.commons.service;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceLoader;

import org.gensis0.lib.dacia.commons.exception.ServerConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ServiceManager {

	private static Logger log = LoggerFactory.getLogger(ServiceManager.class);

	/**
	 * 获取服务器管理器。
	 * 
	 * @param name
	 * @return
	 * @throws ServerConfigurationException
	 */
	public static ServiceHandler getService(String name) throws ServerConfigurationException {
		AccessController.doPrivileged(new PrivilegedAction<Void>() {
			public Void run() {

				ServiceLoader<ServiceHandler> loadedServerManagements = ServiceLoader.load(ServiceHandler.class);
				Iterator<ServiceHandler> serverManagementIterator = loadedServerManagements.iterator();
				try {
					while (serverManagementIterator.hasNext()) {
						ServiceHandler server = serverManagementIterator.next();
						log.debug("已搜索到服务：" + server.serviceName());
					}
				} catch (Throwable t) {
					// Do nothing
				}
				return null;
			}
		});

		for (ServiceHandler s : ServiceLoader.load(ServiceHandler.class)) {
			if (s.serviceName().equals(name)) {
				log.debug("已成功获取服务。" + name);
				return s;
			}
		}
		log.warn("找不到此类服务[" + name + "]");
		throw new ServerConfigurationException("找不到此类服务[" + name + "]");
	}
}
