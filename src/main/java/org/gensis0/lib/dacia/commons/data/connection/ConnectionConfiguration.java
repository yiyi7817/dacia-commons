package org.gensis0.lib.dacia.commons.data.connection;

public interface ConnectionConfiguration {

	public ConnectionConfiguration set(String key, Object value);

	public ConnectionConfiguration enable(String key);

	public boolean is(String key, Object value);

	public boolean exist(String key);

	public Object get(String key);

}
