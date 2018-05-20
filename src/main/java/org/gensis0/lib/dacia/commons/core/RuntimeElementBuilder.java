package org.gensis0.lib.dacia.commons.core;
//package org.gensis0.dacia.commons.core;
//
//import java.lang.reflect.Method;
//import java.util.ServiceLoader;
//
//import org.gensis0.dacia.commons.api.container.RuntimeManagement;
//import org.gensis0.dacia.commons.utils.RandomUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * 运行时单位生成器.
// * 
// * @author Jerry Han
// *
// */
//public class RuntimeElementBuilder {
//	private Logger log = LoggerFactory.getLogger(RuntimeElementBuilder.class);
//	// private RuntimeElementBuilder builder;
//	private String className;
//	private String executeMethodName;
//	private String layerName;
//	// private RuntimeLayer layer;
//	private String elementName;
//	private ServiceLoader<RuntimeManagement> rmLoader = null;
//
//	private RuntimeElementBuilder(String className, String elementName) {
//		this.className = className;
//		this.elementName = elementName;
//		this.rmLoader = ServiceLoader.load(RuntimeManagement.class);
//		this.executeMethodName = null;
//		this.layerName = null;
//	}
//
//	public static RuntimeElementBuilder genBuilder(String className, String elementName) {
//		return new RuntimeElementBuilder(className, elementName);
//	}
//
//	public static RuntimeElementBuilder genBuilder(String className) {
//		return new RuntimeElementBuilder(className, RandomUtils.genRandomString("yyyyMMddHH", 10));
//	}
//
//	public RuntimeElementBuilder setExecuteMethodName(String executeMethodName) {
//		// this.builder.executeMethodName = executeMethodName;
//		this.executeMethodName = executeMethodName;
//		// return this.builder;
//		return this;
//	}
//
//	public RuntimeElementBuilder setLayerName(String layerName) {
//		// this.builder.layerName = layerName;
//		this.layerName = layerName;
//		return this;
//		// return this.builder;
//	}
//
//	// public void setLayer(RuntimeLayer layer) {
//	// this.layer = layer;
//	// }
//
//	public RuntimeLayer checkLayer(String layerName) {
//		for (RuntimeManagement rm : this.rmLoader) {
//			RuntimeLayer rl = rm.queryLayer(layerName);
//			if (rl != null) {
//				return rl;
//			}
//		}
//		return null;
//	}
//
//	public RuntimeElement build() {
//		log.debug("开始根据模板生成运行时单位");
//		RuntimeElement re = new RuntimeElement();
//		if (this.elementName == null || this.elementName.length() < 1) {
//			this.elementName = RandomUtils.genRandomString("yyyyMMddHH", 10);
//		}
//		re.setElementName(this.elementName);
//		// 层级校验，若层级指定，则校验层级是否存在，存在则绑定指定层级，不存在或不指定，则忽略绑定层级
//		if (this.layerName != null && this.layerName.length() > 1) {
//			RuntimeLayer rl = checkLayer(this.layerName);
//			if (rl != null) {
//				re.setLayer(rl);
//			} else {
//				log.debug("指定的层级无效或层级不存在[" + this.layerName + "]，将不指向指定层级");
//			}
//		}
//		// 校验指定类是否存在，若不存在则不予执行，直接返回空
//		try {
//			re.setClazz(Class.forName(this.className));
//		} catch (ClassNotFoundException e) {
//			log.error("指定的类名无效或类不存在[" + this.className + "]", e);
//			return null;
//		}
//		Method[] ms = re.getClazz().getMethods();
//		// 对于已存在的类进行指定方法校验，若未指定的，则使用层级默认指定的方法，若指定不存在，则不予继续执行，直接返回为空
//		if (this.executeMethodName == null || this.executeMethodName.length() < 1) {
//			if (re.getLayer() != null && re.getLayer().getDefaultExecuteMethod() != null
//					&& re.getLayer().getDefaultExecuteMethod().length() > 2) {
//				log.debug("未设置执行方法名，将使用层级默认执行方法名");
//				this.executeMethodName = re.getLayer().getDefaultExecuteMethod();
//			}
//		}
//		Method targetMethod = null;
//		if (this.executeMethodName != null && this.executeMethodName.length() > 2) {
//			{
//				for (Method m : ms) {
//					if (m.getName().equals(this.executeMethodName)) {
//						targetMethod = m;
//						break;
//					}
//				}
//			}
//		} else {
//			log.error("未设置执行方法名或层级中未包含默认执行方法名，不予绑定。");
//			return null;
//		}
//		if (targetMethod == null) {
//			log.error("执行方法名不存在，不予绑定。[" + this.executeMethodName + "]");
//			return null;
//		}
//		re.setExecutableMethod(targetMethod);
//		re.setReturnType(targetMethod.getReturnType());
//		re.setArgs(targetMethod.getParameters());
//		re.setExceptionTypes(targetMethod.getExceptionTypes());
//		return re;
//	}
//}
