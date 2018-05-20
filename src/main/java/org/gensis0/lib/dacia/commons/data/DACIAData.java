package org.gensis0.lib.dacia.commons.data;

/**
 * dacia基础数据模型。
 * 
 * @author yihan
 *
 */
public class DACIAData {

	/**
	 * 数据唯一标识
	 */
	private String dataId;
	/**
	 * 数据分类
	 */
	private String dataType = "default";

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

}
