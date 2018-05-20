package org.gensis0.lib.dacia.commons;

public class Conditions {
	private String label;
	private String keyName;
	private Object keyValue;

	public Conditions() {
	}

	public Conditions(String label, String keyName, Object keyValue) {
		this.label = label;
		this.keyName = keyName;
		this.keyValue = keyValue;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public Object getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(Object keyValue) {
		this.keyValue = keyValue;
	}

}
