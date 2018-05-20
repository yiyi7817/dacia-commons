package org.gensis0.lib.dacia.commons;

public class ExecutionResult {

	private StatusInfo status;
	private String msg;
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ExecutionResult(StatusInfo status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public StatusInfo getStatus() {
		return status;
	}

	public void setStatus(StatusInfo status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
