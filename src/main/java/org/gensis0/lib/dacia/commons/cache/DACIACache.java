package org.gensis0.lib.dacia.commons.cache;

public abstract class DACIACache<K, V> implements CacheOperation<K, V> {

	private Object cacheInstance;

	public DACIACache(Object cacheInstance) {
		this.cacheInstance = cacheInstance;
	}

	public Object getCacheInstance() {
		return cacheInstance;
	}

}
