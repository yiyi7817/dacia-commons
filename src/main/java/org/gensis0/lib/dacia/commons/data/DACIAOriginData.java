package org.gensis0.lib.dacia.commons.data;

import java.util.Map;

public class DACIAOriginData {
	public static String DEFAULT_FILE_ENCODE = "utf-8";
	// private List<AMNITDataPair> datas;
	private Map data;
	private String defaultEncode = DACIAOriginData.DEFAULT_FILE_ENCODE;

	public String getDefaultEncode() {
		return defaultEncode;
	}

	public Map getData() {
		return data;
	}

	public void setData(Map data) {
		this.data = data;
	}

	public void setDefaultEncode(String defaultEncode) {
		this.defaultEncode = defaultEncode;
	}
}
