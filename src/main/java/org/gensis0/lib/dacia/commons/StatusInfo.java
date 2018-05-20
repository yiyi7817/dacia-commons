package org.gensis0.lib.dacia.commons;

public class StatusInfo {

	public final static StatusInfo SUCCESS = new StatusInfo(111111, "SUCCESS", "运行成功");
	public final static StatusInfo FAILED = new StatusInfo(999999, "FAILED", "运行失败");
	public final static StatusInfo ERROR = new StatusInfo(888888, "ERROR", "运行错误");
	public final static StatusInfo INITIAL = new StatusInfo(000000, "INITIAL", "初始化");
	public final static StatusInfo STOPPED = new StatusInfo(300001, "STOPPED", "已停止");
	public final static StatusInfo RUNNING = new StatusInfo(122001, "RUNNING", "运行中");

	private int code;
	private String label;
	private String description;

	public StatusInfo(int code, String label, String description) {
		super();
		this.code = code;
		this.label = label;
		this.description = description;
	}

	public StatusInfo(int code, String label) {
		super();
		this.code = code;
		this.label = label;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
