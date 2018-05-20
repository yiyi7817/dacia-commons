package org.gensis0.lib.dacia.commons.cache;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.gensis0.lib.dacia.commons.core.Tuple2;
import org.gensis0.lib.dacia.commons.core.Tuple4;
import org.gensis0.lib.dacia.commons.data.DataQueryConditions;
import org.gensis0.lib.dacia.commons.data.exception.DACIADataExecutionException;

/**
 * 缓存增删改查基本接口。
 * 
 * @author yihan
 *
 */
public interface CacheOperation<K, V> {

	public V get(K key) throws DACIADataExecutionException;

	public Collection<K> searchMix(DataQueryConditions... conds) throws DACIADataExecutionException;

	public Collection<K> searchByPage(int currentPage, int eleNum, DataQueryConditions... conds)
			throws DACIADataExecutionException;

	public Collection<K> searchByKey(DataQueryConditions... conds) throws DACIADataExecutionException;

	public Collection<K> searchByValue(DataQueryConditions... conds) throws DACIADataExecutionException;

	public void put(K key, V value);

	public void put(K key, V value, long time, TimeUnit timeUnit);

	public void put(Tuple2<K, V>... datas);

	public void put(Tuple4<K, V, Long, TimeUnit>... datas);

}
