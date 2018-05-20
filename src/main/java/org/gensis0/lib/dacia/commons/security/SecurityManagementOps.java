package org.gensis0.lib.dacia.commons.security;

import org.gensis0.lib.dacia.commons.core.Tuple2;

public interface SecurityManagementOps<STORE, KEY, ALG, EXP> {

	public STORE initialSecurityStore(String storePath, String rootPassword, ALG algorithm);

	public STORE getSecurityStore(String storePath, String rootPassword, ALG algorithm);

	public KEY genKey(String keyName, String password, ALG algorithm, Tuple2<String, Object>... options);

	public KEY getKey(String keyName, String password, ALG algorithm);

	public EXP export(String keyName, String password, ALG algorithm);

	public EXP export(String keyName, String password, KEY originKey, ALG algorithm);

}
