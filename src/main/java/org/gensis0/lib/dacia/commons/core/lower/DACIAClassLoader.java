package org.gensis0.lib.dacia.commons.core.lower;

import java.util.HashSet;

public final class DACIAClassLoader extends ClassLoader {

	/**
	 * 默认安全路径。
	 */
	private String secPath;
	/**
	 * 独立jar包路径。
	 */
	private String libPath;
	/**
	 * 独立class加载路径。
	 */
	private String classPath;
	/**
	 * 是否进行安全校验。
	 */
	private boolean isSecued;
	private static HashSet<String> ClassContainer = new HashSet<String>();

	public static DACIAClassLoader getInstance() {
		return new DACIAClassLoader();
	}

	private DACIAClassLoader() {
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.findClass(name);
	}

	@Override
	protected String findLibrary(String libname) {
		// TODO Auto-generated method stub
		return super.findLibrary(libname);
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.loadClass(name);
	}

	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.loadClass(name, resolve);
	}

}
