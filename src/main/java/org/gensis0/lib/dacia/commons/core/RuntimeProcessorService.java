package org.gensis0.lib.dacia.commons.core;
//package org.gensis0.dacia.commons.core;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Parameter;
//import java.util.Map;
//import java.util.ServiceLoader;
//
//import org.gensis0.dacia.commons.api.CommonStatusInfo;
//import org.gensis0.dacia.commons.api.container.RuntimeProcessor;
//import org.gensis0.dacia.commons.exception.CommonException;
//import org.gensis0.dacia.commons.utils.ClassUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * 运行时处理器，用于处理运行时单位的执行中枢。<br />
// * 若需要使用自定义执行器，仅需继承此执行器或重写执行器模型即可。
// * 
// * @author Jerry Han
// *
// */
//public class RuntimeProcessorService implements RuntimeProcessor {
//	private Logger log = LoggerFactory.getLogger(RuntimeProcessorService.class);
//	private final static String name = "DEFAULT";
//
//	public RuntimeProcessorService() {
//	}
//
//	@Override
//	public RuntimeExecutionResult execute(RuntimeElement element, Map<String, Object> args) throws CommonException {
//		RuntimeExecutionResult rer = null;
//		Object[] objs = null;
//		try {
//			objs = validateRuntimeExecution(element, args);
//		} catch (CommonException e) {
//			rer = new RuntimeExecutionResult(CommonStatusInfo.COMMON_STATUS_FAILED, true, e.getMessage(), element);
//			return rer;
//		}
//		Object targetObj = null;
//		try {
//			if (element.getCustomConstructorTypes() == null || element.getCustomConstructorTypes().length < 1) {
//				// 使用默认构造器
//				targetObj = element.getClazz().newInstance();
//			} else {
//				// 使用特殊构造器
//				targetObj = validateRuntimeConstructor(element, args);
//			}
//		} catch (CommonException e) {
//			rer = new RuntimeExecutionResult(CommonStatusInfo.COMMON_STATUS_FAILED, true, e.getMessage(), element);
//			rer.setExecutionException(e);
//			return rer;
//		} catch (Exception ex) {
//			rer = new RuntimeExecutionResult(CommonStatusInfo.COMMON_STATUS_FAILED, true, ex.getMessage(), element);
//			rer.setExecutionException(ex);
//			return rer;
//		}
//		if (targetObj == null) {
//			rer = new RuntimeExecutionResult(CommonStatusInfo.COMMON_STATUS_FAILED, true, "构造器实例化生成失败", element);
//			rer.setExecutionException(new CommonException("构造器实例化生成失败"));
//			return rer;
//		}
//		Object resultObject = null;
//		try {
//			resultObject = element.getExecutableMethod().invoke(targetObj, objs);
//		} catch (Exception e) {
//			rer = new RuntimeExecutionResult(CommonStatusInfo.COMMON_STATUS_FAILED, true, e.getMessage(), element);
//			rer.setExecutionException(e);
//			return rer;
//		}
//		if (element.getReturnType() != null && resultObject == null) {
//			rer = new RuntimeExecutionResult(CommonStatusInfo.COMMON_STATUS_FAILED, true, "执行方法未返回执行结果", element);
//			rer.setExecutionException(new CommonException("执行方法未返回执行结果"));
//			return rer;
//		}
//		rer = new RuntimeExecutionResult(CommonStatusInfo.COMMON_STATUS_SUCCESS, true, "处理成功", element);
//		rer.setReturnData(resultObject);
//		rer.setExecutionException(null);
//		return rer;
//	}
//
//	/**
//	 * 验证待执行方法的参数检查
//	 * 
//	 * @param element
//	 * @param args
//	 * @return
//	 * @throws CommonException
//	 */
//	protected Object[] validateRuntimeExecution(RuntimeElement element, Map<String, Object> args)
//			throws CommonException {
//		Object[] objs = null;
//		if (element.getArgs() != null && element.getArgs().length > 0 && args != null && args.size() > 0) {
//			objs = new Object[element.getArgs().length];
//			for (int i = 0; i < element.getArgs().length; i++) {
//				Parameter p = element.getArgs()[i];
//				if (!args.containsKey(p.getName())) {
//					log.error("传入参数未包含运行方法的要求参数[" + p.getName() + "]");
//					throw new CommonException("传入参数未包含运行方法的要求参数[" + p.getName() + "]");
//				} else {
//					if (new ClassUtils().validateObjectType(objs[i], p.getType())) {
//						objs[i] = args.get(p.getName());
//					}
//					log.error("传入参数未包含正确类型的运行方法的要求参数[" + p.getName() + "]");
//					throw new CommonException("传入参数未包含正确类型的运行方法的要求参数[" + p.getName() + "]");
//				}
//			}
//		}
//		return objs;
//	}
//
//	/**
//	 * 
//	 * @param element
//	 * @param args
//	 * @return
//	 * @throws CommonException
//	 */
//	protected Object validateRuntimeConstructor(RuntimeElement element, Map<String, Object> args)
//			throws CommonException {
//		Object[] objs = null;
//		Constructor constuctor = null;
//		// 验证构造器是否存在
//		try {
//			constuctor = element.getClazz().getConstructor(element.getCustomConstructorTypes());
//		} catch (Exception e) {
//			throw new CommonException("自定义构造方法，不予访问或访问错误.");
//		}
//		if (constuctor == null) {
//			throw new CommonException("自定义构造方法，不予访问或访问错误.");
//		}
//		// 验证构造器参数是否存在
//		if (constuctor.getParameters() != null && constuctor.getParameters().length > 0) {
//			objs = new Object[constuctor.getParameters().length];
//			for (int i = 0; i < constuctor.getParameters().length; i++) {
//				Parameter p = constuctor.getParameters()[i];
//				if (!args.containsKey(p.getName())) {
//					log.error("传入参数未包含运行方法的要求参数[" + p.getName() + "]");
//					throw new CommonException("传入参数未包含运行方法的要求参数[" + p.getName() + "]");
//				} else {
//					if (new ClassUtils().validateObjectType(args.get(p.getName()), p.getType())) {
//						objs[i] = args.get(p.getName());
//					}
//					log.error("传入参数未包含正确类型的运行方法的要求参数[" + p.getName() + "]");
//					throw new CommonException("传入参数未包含正确类型的运行方法的要求参数[" + p.getName() + "]");
//				}
//			}
//		}
//		try {
//			return constuctor.newInstance(objs);
//		} catch (Exception e) {
//			log.error("构造器实例化失败", e);
//			throw new CommonException("构造器实例化失败");
//		}
//	}
//
//	@Override
//	public RuntimeProcessor getInstance(String processName) {
//		for (RuntimeProcessor rp : ServiceLoader.load(RuntimeProcessor.class)) {
//			if (rp.getName().equals(processName)) {
//				return rp;
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public String getName() {
//		return this.name;
//	}
//
//}
