package org.gensis0.lib.dacia.commons.utils;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.lang.model.type.PrimitiveType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassUtils {
	private Logger log = LoggerFactory.getLogger(ClassUtils.class);

	public boolean validateObjectType(Object obj, Class<?> objType) {
		if (obj.getClass().getName().equals(objType.getName())) {
			return true;
		}
		return false;
	}

	public Object parseObject(Object obj, Class<?> type) throws Exception {
		if (type.getName().equals(int.class.getName())) {
			return Integer.valueOf(obj.toString());
		} else if (type.getName().equals(boolean.class.getName())) {
			return Boolean.valueOf(obj.toString());
		} else if (type.getName().equals(double.class.getName())) {
			return Double.valueOf(obj.toString());
		} else if (type.getName().equals(short.class.getName())) {
			return Short.valueOf(obj.toString());
		} else if (type.getName().equals(long.class.getName())) {
			return Long.valueOf(obj.toString());
		} else if (type.getName().equals(float.class.getName())) {
			return Float.valueOf(obj.toString());
		}
		return obj.toString();
	}

	/**
	 * 扫描某个jar包下的所有类
	 * 
	 * @param jarPath
	 * @return
	 * @throws Exception
	 */
	public List<Class<?>> findJarClasses(String jarPath) throws Exception {
		log.debug("开始扫描jar包中的类：" + jarPath);
		File jarFile = new File(jarPath);
		if (!jarFile.exists() || !jarFile.isFile()) {
			log.error("此路径下的jar包不存在。" + jarPath);
			throw new Exception("此路径下的jar包不存在。" + jarPath);
		}
		if (!jarFile.canRead()) {
			log.error("此jar包不可访问。" + jarPath);
			throw new Exception("此jar包不可访问。" + jarPath);
		}
		// JarFile jar = new JarFile(jarFile);
		Enumeration<JarEntry> jes = new JarFile(jarFile).entries();
		ClassLoader loader = new URLClassLoader(new URL[] { new URL("file:" + jarPath) });
		List<Class<?>> clazzs = new ArrayList<Class<?>>();
		{
			while (jes.hasMoreElements()) {
				JarEntry je = jes.nextElement();
				if (je.getName().endsWith(".class")) {
					Class<?> c =loader.loadClass(je.getName().replace("/", ".").substring(0, je.getName().length() - 6));
					// Class.forName(c.getName());
//					Class<?> c = Class.forName(je.getName().replace("/", ".").substring(0, je.getName().length() - 6));
					clazzs.add(c);
				}
			}
		}
		loader = null;
		jes = null;
		log.debug("扫描到此jar包下拥有class文件数为：" + clazzs.size());
		return clazzs;
	}

	/**
	 * 扫描某个包下的所有类
	 * 
	 * @param packageName
	 * @return
	 * @throws Exception
	 */
	public List<Class<?>> findClasses(String packageName) throws Exception {
		log.debug("开始扫描包中的类：" + packageName);
		List<Class<?>> clazzs = new ArrayList<Class<?>>();
		// ClassLoader loader = ClassLoader.getSystemClassLoader();
		try {
			String resourceName = packageName.replaceAll("\\.", "/");
			log.debug(resourceName + "," + "file:" + ClassUtils.class.getResource("/").getPath());
			URL url = new URL("file:" + ClassUtils.class.getResource("/").getPath() + File.separator + resourceName);
			File urlFile = new File(url.toURI());
			log.debug(urlFile.getAbsolutePath());
			List<Class<?>> tcs = findAllClasses(packageName, urlFile);
			if (tcs != null && tcs.size() > 0) {
				clazzs.addAll(tcs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("共计扫描类：" + clazzs.size());
		return clazzs;
	}

	protected List<Class<?>> findAllClasses(String packName, File packFile) throws Exception {
		List<Class<?>> clazzs = new ArrayList<Class<?>>();
		// System.out.println(packName);
		if (packFile.exists() && packFile.isDirectory()) {
			File[] fs = packFile.listFiles();
			for (File f : fs) {
				List<Class<?>> tcs = new ArrayList<Class<?>>();
				tcs = findAllClasses(packName + "." + f.getName(), f);
				if (tcs != null && tcs.size() > 0) {
					clazzs.addAll(tcs);
					// tcs.clear();
				}
			}
		}
		if (packFile.exists() && packFile.isFile()) {
			String[] ss = packName.split("[.]");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < ss.length - 1; i++) {
				sb.append(ss[i]);
				sb.append(".");
			}
			// System.out.println("N: " + packName);
			// System.out.println("F: " + packFile.getName());
			Class<?> clazz = Class.forName(sb.substring(0, sb.length() - 1));
			clazzs.add(clazz);
		}
		return clazzs;
	}
}
