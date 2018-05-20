package org.gensis0.lib.dacia.commons.core;
//package org.gensis0.dacia.commons.core;
//
//import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;
//
//import org.gensis0.dacia.commons.utils.RandomUtils;
//
///**
// * 运行时容器单位定义，与运行类和层级单位绑定
// * 
// * @author Jerry Han
// *
// */
//public class RuntimeElement {
//
//	private Class<?> clazz;
//	private String elementName = "default" + RandomUtils.genRandomNum(Integer.MAX_VALUE);
//	private RuntimeLayer layer;
//	// private String executeMethod;
//	// private Class<?>[] argTypes;
//	private Parameter[] args;
//	private Class<?> returnType;
//	private Class<?>[] exceptionTypes;
//	private Method executableMethod;
//	private Class<?>[] customConstructorTypes;
//
//	public Class<?>[] getCustomConstructorTypes() {
//		return customConstructorTypes;
//	}
//
//	public void setCustomConstructorTypes(Class<?>[] customConstructorTypes) {
//		this.customConstructorTypes = customConstructorTypes;
//	}
//
//	public Method getExecutableMethod() {
//		return executableMethod;
//	}
//
//	public void setExecutableMethod(Method executableMethod) {
//		this.executableMethod = executableMethod;
//	}
//
//	public Parameter[] getArgs() {
//		return args;
//	}
//
//	public void setArgs(Parameter[] args) {
//		this.args = args;
//	}
//
//	public Class<?> getReturnType() {
//		return returnType;
//	}
//
//	public void setReturnType(Class<?> returnType) {
//		this.returnType = returnType;
//	}
//
//	public Class<?>[] getExceptionTypes() {
//		return exceptionTypes;
//	}
//
//	public void setExceptionTypes(Class<?>[] exceptionTypes) {
//		this.exceptionTypes = exceptionTypes;
//	}
//
//	public Class<?> getClazz() {
//		return clazz;
//	}
//
//	public void setClazz(Class<?> clazz) {
//		this.clazz = clazz;
//	}
//
//	public String getElementName() {
//		return elementName;
//	}
//
//	public void setElementName(String elementName) {
//		this.elementName = elementName;
//	}
//
//	public RuntimeLayer getLayer() {
//		return layer;
//	}
//
//	public void setLayer(RuntimeLayer layer) {
//		this.layer = layer;
//	}
//
//}
