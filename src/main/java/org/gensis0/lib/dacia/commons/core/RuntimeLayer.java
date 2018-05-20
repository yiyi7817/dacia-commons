package org.gensis0.lib.dacia.commons.core;

import org.gensis0.lib.dacia.commons.utils.RandomUtils;

/**
 * 运行时定义，层次结构单位。
 * 
 * @author Jerry Han
 *
 */
public class RuntimeLayer {
	/**
	 * 仅为本层
	 */
	public final static int LAYER_SCOPE_CUR = 0;
	public final static int LAYER_SCOPE_DOWN_1 = 1;
	public final static int LAYER_SCOPE_DOWN_2 = 2;
	public final static int LAYER_SCOPE_DOWN_3 = 3;
	public final static int LAYER_SCOPE_DOWN_4 = 4;
	public final static int LAYER_SCOPE_DOWN_5 = 5;
	public final static int LAYER_SCOPE_DOWN_6 = 6;
	public final static int LAYER_SCOPE_DOWN_7 = 7;
	public final static int LAYER_SCOPE_DOWN_8 = 8;
	public final static int LAYER_SCOPE_DOWN_9 = 9;
	public final static int LAYER_SCOPE_DOWN_10 = 10;
	public final static int LAYER_SCOPE_UP_1 = -1;
	public final static int LAYER_SCOPE_UP_2 = -2;
	public final static int LAYER_SCOPE_UP_3 = -3;
	public final static int LAYER_SCOPE_UP_4 = -4;
	public final static int LAYER_SCOPE_UP_5 = -5;
	public final static int LAYER_SCOPE_UP_6 = -6;
	public final static int LAYER_SCOPE_UP_7 = -7;
	public final static int LAYER_SCOPE_UP_8 = -8;
	public final static int LAYER_SCOPE_UP_9 = -9;
	public final static int LAYER_SCOPE_UP_10 = -10;

	/**
	 * 层次名称
	 */
	private String layerName = "default " + RandomUtils.genRandomNum(Integer.MAX_VALUE);
	/**
	 * 层次序列号
	 */
	private String layerId = RandomUtils.genRandomString("yyyyMMddHHmmss", 10);
	/**
	 * 层次影响范围
	 */
	private int layerScope = 0;
	/**
	 * 是否允许跨层
	 */
	private boolean crossLayer = false;
	/**
	 * 层次默认描述
	 */
	private String layerDescription = "description " + RandomUtils.genRandomString("yyyyMMddHHmmss", 10);

	/**
	 * 层级中默认使用的执行方法名称，若element没有自定义执行方法，则使用此方法名称进行执行。
	 */
	private String defaultExecuteMethod = "execute";

	public String getDefaultExecuteMethod() {
		return defaultExecuteMethod;
	}

	public void setDefaultExecuteMethod(String defaultExecuteMethod) {
		this.defaultExecuteMethod = defaultExecuteMethod;
	}

	public String getLayerName() {
		return layerName;
	}

	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	public String getLayerId() {
		return layerId;
	}

	public void setLayerId(String layerId) {
		this.layerId = layerId;
	}

	public int getLayerScope() {
		return layerScope;
	}

	public void setLayerScope(int layerScope) {
		this.layerScope = layerScope;
	}

	public boolean isCrossLayer() {
		return crossLayer;
	}

	public void setCrossLayer(boolean crossLayer) {
		this.crossLayer = crossLayer;
	}

	public String getLayerDescription() {
		return layerDescription;
	}

	public void setLayerDescription(String layerDescription) {
		this.layerDescription = layerDescription;
	}

}
