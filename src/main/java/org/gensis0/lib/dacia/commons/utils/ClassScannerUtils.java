package org.gensis0.lib.dacia.commons.utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过一个包路径，获取所有此路径下的所有类和接口。
 * 
 * @author hanyi
 *
 */
public class ClassScannerUtils implements DACIAUtils<String, List<Class<?>>> {

	/**
	 * sourceData: 包名，例如：org.gensis0
	 */
	public List<Class<?>> doUtil(String sourceData) throws Exception {
		List<Class<?>> clazzs = new ArrayList<Class<?>>();
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		try {
			String resourceName = sourceData.replaceAll("\\.", "/");
			URL url = loader.getResource(resourceName);
			File urlFile = new File(url.toURI());
			List<Class<?>> tcs = findAllClasses(sourceData, urlFile);
			if (tcs != null && tcs.size() > 0) {
				clazzs.addAll(tcs);
				// tcs.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clazzs;
	}

	protected List<Class<?>> findAllClasses(String packName, File packFile)
			throws Exception {
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
