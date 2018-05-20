package org.gensis0.lib.dacia.commons.data.exception;

import org.gensis0.lib.dacia.commons.exception.CommonException;

/**
 * 文件夹操作器配置异常
 * @author YX.alienware
 *
 */
public class FolderConfigurationException extends CommonException{
	private static final long serialVersionUID = -7164133178468803227L;

	public FolderConfigurationException(String msg) {
		super(msg);
	}

	public FolderConfigurationException(String msg, Throwable e) {
		super(msg, e);
	}
}
