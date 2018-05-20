package org.gensis0.lib.dacia.commons.data;

import org.gensis0.lib.dacia.commons.Conditions;

public class DataQueryConditions extends Conditions {

	public final static int OPERATE_TYPE_EQUAL = 0;
	public final static int OPERATE_TYPE_GREAT = 1;
	public final static int OPERATE_TYPE_LESS = 2;
	public final static int OPERATE_TYPE_LIKE = 3;
	public final static int OPERATE_TYPE_NOTLIKE = 13;
	public final static int OPERATE_TYPE_NOTEQUAL = 10;
	public final static int OPERATE_TYPE_NOTGREATE = 11;
	public final static int OPERATE_TYPE_NOTLESS = 12;
	public final static int OPERATE_TYPE_ISNULL = 20;
	public final static int OPERATE_TYPE_NOTNULL = 21;
	public final static int UP_LEVEL_RELATION_AND = 0;
	public final static int UP_LEVEL_RELATION_OR = 1;
	public final static int UP_LEVEL_RELATION_NULL = -1;

	private int operatType = 0;
	private int upRelation = 0;

	public DataQueryConditions(String label, String keyName, Object keyValue, int operatType, int upRelation) {
		super(label, keyName, keyValue);
		this.operatType = operatType;
		this.upRelation = upRelation;
	}

	public DataQueryConditions(String keyName, Object keyValue, int operatType, int upRelation) {
		super("数据查询", keyName, keyValue);
		this.operatType = operatType;
		this.upRelation = upRelation;
	}

	public int getUpRelation() {
		return upRelation;
	}

	public void setUpRelation(int upRelation) {
		this.upRelation = upRelation;
	}

	public int getOperatType() {
		return operatType;
	}

	public void setOperatType(int operatType) {
		this.operatType = operatType;
	}

}
