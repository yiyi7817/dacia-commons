package org.gensis0.lib.dacia.commons.cache;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceLoader;

import org.gensis0.lib.dacia.commons.core.lower.DACIAClassLoader;
import org.gensis0.lib.dacia.commons.exception.CommonConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CacheManager {
	private static Logger log = LoggerFactory.getLogger(CacheManager.class);

	public static <K, V> DACIACache<K, V> getCache(String cacheProviderName, String cacheName, Class<K> kclass,
			Class<V> vclass) throws CommonConfigException {
		ServiceLoader<CacheManagement> loader = ServiceLoader.load(CacheManagement.class,
				DACIAClassLoader.getInstance());

		AccessController.doPrivileged(new PrivilegedAction<Void>() {
			public Void run() {
				ServiceLoader<CacheManagement> loadedCacheManagements = ServiceLoader.load(CacheManagement.class,
						DACIAClassLoader.getInstance());
				Iterator<CacheManagement> cacheManagementIterator = loadedCacheManagements.iterator();
				try {
					while (cacheManagementIterator.hasNext()) {
						CacheManagement server = cacheManagementIterator.next();
						log.debug("已搜索到缓存管理器：" + server.cacheManagementName());
					}
				} catch (Throwable t) {
					// Do nothing
				}
				return null;
			}
		});

		for (CacheManagement s : ServiceLoader.load(CacheManagement.class)) {
			if (s.cacheManagementName().equals(cacheProviderName)) {
				log.debug("已成功获取缓存管理器。" + cacheProviderName);
				return null;
			}
		}
		log.warn("找不到此类缓存管理器[" + cacheProviderName + "]");
		throw new CommonConfigException("找不到此类缓存管理器[" + cacheProviderName + "]");
		// return null;
	}
}
