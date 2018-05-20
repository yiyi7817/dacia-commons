package org.gensis0.lib.dacia.commons.core;
//package org.gensis0.dacia.commons.core;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.gensis0.dacia.commons.api.container.Container;
//import org.gensis0.dacia.commons.exception.CommonRuntimeException;
//
//public class RuntimeContainer extends Container {
//
//	public RuntimeContainer() {
//		super.setContainerName("default");
//	}
//
//	// private static Map<String, Class<?>> runtime_pool = new HashMap<String,
//	// Class<?>>(65535);
//	/**
//	 * 运行时层级配置池
//	 */
//
//	private static Map<String, RuntimeLayer> layer_pool = new HashMap<String, RuntimeLayer>(20);
//	/**
//	 * 运行时运行单位配置
//	 */
//	private static Map<String, RuntimeElement> element_pool = new HashMap<String, RuntimeElement>(65535);
//
//	/**
//	 * 运行时层级单位的运行单位配置
//	 */
//	private static Map<String, List<RuntimeElement>> layer_elements = new HashMap<String, List<RuntimeElement>>(20);
//
//	protected boolean containsElement(String elementName) {
//		return element_pool.containsKey(elementName);
//	}
//
//	protected boolean containsElement(Class<?> clazz) {
//		for (RuntimeElement re : element_pool.values()) {
//			if (re.getClazz() == clazz) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	protected RuntimeElement get(String elementName) {
//		return element_pool.get(elementName);
//	}
//
//	protected RuntimeElement get(Class<?> clazz) throws CommonRuntimeException {
//		for (RuntimeElement re : element_pool.values()) {
//			if (re.getClazz() == clazz) {
//				return re;
//			}
//		}
//		throw new CommonRuntimeException("找不到该运行单位[" + clazz.getName() + "]");
//	}
//
//	protected List<RuntimeElement> getLayeredElements(String layerName) {
//		return layer_elements.get(layerName);
//	}
//
//	protected RuntimeLayer getLayer(String layerName) {
//		return layer_pool.get(layerName);
//	}
//
//	protected void update(RuntimeLayer layer) {
//		layer_pool.put(layer.getLayerName(), layer);
//	}
//
//	protected void update(RuntimeElement element) {
//		element_pool.put(element.getElementName(), element);
//		// 检查元素层级关系
//		if (element.getLayer() != null) {
//			List<RuntimeElement> rel = null;
//			if (layer_elements.containsKey(element.getLayer().getLayerName())) {
//				rel = layer_elements.get(element.getLayer().getLayerName());
//			} else {
//				rel = new ArrayList<RuntimeElement>();
//			}
//			rel.add(element);
//			layer_elements.put(element.getLayer().getLayerName(), rel);
//		}
//	}
//
//	protected int countLayer() {
//		return layer_pool.size();
//	}
//
//	protected int countElement() {
//		return element_pool.size();
//	}
//
//	protected int countElement(String layerName) {
//		if (layer_elements.containsKey(layerName)) {
//			return layer_elements.get(layerName).size();
//		}
//		return 0;
//	}
//
//	public static Container getContainer() {
//		return new RuntimeContainer();
//	}
//}
