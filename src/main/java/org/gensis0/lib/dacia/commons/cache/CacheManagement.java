package org.gensis0.lib.dacia.commons.cache;

public interface CacheManagement {

	public String cacheManagementName();

	public <K, V> DACIACache<K, V> getCache(String cacheName);

	public <K, V> DACIACache<K, V> getCache(String cacheName, String remoteName);

	public boolean containCache(String cacheName);

	public <K, V> boolean containCache(String cacheName, Class<K> kclass, Class<V> vclass);

	public <K, V> DACIACache<K, V> createCache(String cacheName, Class<K> kclass, Class<V> vclass);

	public <K, V> DACIACache<K, V> createCache(String cacheName);

	public boolean deleteCache(String cacheName, boolean isRemote);

	public <K, V> DACIACache<K, V> copyToLocal(String cacheName, boolean isRemote);

	public <K, V> DACIACache<K, V> copyToLocal(String cacheName);

}
