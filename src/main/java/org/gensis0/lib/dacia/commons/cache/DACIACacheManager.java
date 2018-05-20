package org.gensis0.lib.dacia.commons.cache;

public abstract class DACIACacheManager<P> implements CacheManagement {

	private P cacheManager;

	public DACIACacheManager(P cacheManager) {
		this.cacheManager = cacheManager;
	}

	public P getCacheManager() {
		return cacheManager;
	}

}
