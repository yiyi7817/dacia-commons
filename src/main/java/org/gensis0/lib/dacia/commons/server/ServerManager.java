package org.gensis0.lib.dacia.commons.server;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceLoader;

import org.gensis0.lib.dacia.commons.exception.ServerConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务器管理器。用于解决代码侵入性问题。
 * 
 * @author yihan
 *
 */
public class ServerManager {
	private static Logger log = LoggerFactory.getLogger(ServerManager.class);

	/**
	 * 获取服务器管理器。
	 * 
	 * @param name
	 * @return
	 * @throws ServerConfigurationException
	 */
	public static ServerManagement getServer(String name) throws ServerConfigurationException {
		AccessController.doPrivileged(new PrivilegedAction<Void>() {
			public Void run() {

				ServiceLoader<ServerManagement> loadedServerManagements = ServiceLoader.load(ServerManagement.class);
				Iterator<ServerManagement> serverManagementIterator = loadedServerManagements.iterator();
				/*
				 * Load these drivers, so that they can be instantiated. It may be the case that
				 * the driver class may not be there i.e. there may be a packaged driver with
				 * the service class as implementation of java.sql.Driver but the actual class
				 * may be missing. In that case a java.util.ServiceConfigurationError will be
				 * thrown at runtime by the VM trying to locate and load the service.
				 *
				 * Adding a try catch block to catch those runtime errors if driver not
				 * available in classpath but it's packaged as service and that service is there
				 * in classpath.
				 */
				try {
					while (serverManagementIterator.hasNext()) {
						ServerManagement server = serverManagementIterator.next();
						log.debug("已搜索到服务器管理器：" + server.serverName());
					}
				} catch (Throwable t) {
					// Do nothing
				}
				return null;
			}
		});

		for (ServerManagement s : ServiceLoader.load(ServerManagement.class)) {
			if (s.serverName().equals(name)) {
				log.debug("已成功获取服务器管理器。" + name);
				return s;
			}
		}
		log.warn("找不到此类服务器管理器[" + name + "]");
		throw new ServerConfigurationException("找不到此类服务器管理器[" + name + "]");
	}

}
