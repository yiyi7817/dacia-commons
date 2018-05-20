package org.gensis0.lib.dacia.commons.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassMapUtils {
	private Logger log = LoggerFactory.getLogger(ClassMapUtils.class);

	public <T> T parseToObject(Map<String, Object> data, T t) {
		Field[] fs = t.getClass().getDeclaredFields();
		for (Field f : fs) {
			try {
				if (data.containsKey(f.getName())) {
					f.setAccessible(true);
					f.set(t, data.get(f.getName()));
				}
			} catch (Exception e) {
				log.error("数据转换失败。");
			}
		}
		return t;
	}

	public <T> Map<String, Object> parseToMap(Class<T> clazz, T t) {
		Field[] fs = clazz.getDeclaredFields();
		Map<String, Object> map = new HashMap<String, Object>(fs.length);
		if (clazz.getName().toUpperCase().endsWith("PK")) {
			return new HashMap<String, Object>();
		}
		for (Field f : fs) {

			try {
				if (!f.getName().toUpperCase().endsWith("PK")) {
					if (f.getName().equals("CA	SE_INSENSITIVE_ORDER") || f.getName().equals("serialPersistentFields")
							|| f.getName().equals("serialVersionUID") || f.getName().equals("HASHING_SEED")
							|| f.getName().equals("value")) {
					} else {

						f.setAccessible(true);

						try {
							map.put(f.getName(), f.get(t));
						} catch (Exception e) {
							map.put(f.getName(), "");
						}
					}

				} else {
					f.setAccessible(true);
					Field[] fs2 = f.getType().getDeclaredFields();
					for (Field f2 : fs2) {
						if (f2.getName().equals("CASE_INSENSITIVE_ORDER")
								|| f2.getName().equals("serialPersistentFields")
								|| f2.getName().equals("serialVersionUID") || f2.getName().equals("HASHING_SEED")
								|| f2.getName().equals("value")) {
						} else {
							f2.setAccessible(true);

							try {
								map.put(f.getName() + "_" + f2.getName(), f2.get(f.get(t)));
							} catch (Exception e) {
								map.put(f.getName() + "_" + f2.getName(), "");
							}
						}

					}

				}
			} catch (Exception e) {
				log.debug(f.getName() + ": 对象映射失败。", e);
			}
		}
		return map;
	}

}
