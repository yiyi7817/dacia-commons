package org.gensis0.lib.dacia.commons.core.lower;

import javax.security.cert.X509Certificate;

public class DACIASystemRuntime {

	private static DACIASystemRuntime currentRuntime = new DACIASystemRuntime();
	private static DACIAClassLoader classLoader = DACIAClassLoader.getInstance();
	private static X509Certificate envCert;

	public static DACIASystemRuntime getRuntime() {
		return currentRuntime;
	}

	public static DACIAClassLoader getClassLoader() {
		return classLoader;
	}

	public static X509Certificate envSecurity() {
		return envCert;
	}

}
