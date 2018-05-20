package org.gensis0.lib.dacia.commons.data.connection;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceLoader;

import org.gensis0.lib.dacia.commons.exception.ServerConfigurationException;
import org.gensis0.lib.dacia.commons.server.ServerManagement;
import org.gensis0.lib.dacia.commons.server.ServerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DACIAConnectionManager {
	private static Logger log = LoggerFactory.getLogger(DACIAConnectionManager.class);

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

				ServiceLoader<DACIADataConnectionManagement> loadedDataConnectionManagements = ServiceLoader
						.load(DACIADataConnectionManagement.class);
				Iterator<DACIADataConnectionManagement> dataConnectionManagements = loadedDataConnectionManagements
						.iterator();
				try {
					while (dataConnectionManagements.hasNext()) {
						DACIADataConnectionManagement server = dataConnectionManagements.next();
						log.debug("已搜索到服务器管理器：" + server.connectionName());
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
