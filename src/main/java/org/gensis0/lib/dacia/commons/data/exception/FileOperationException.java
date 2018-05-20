package org.gensis0.lib.dacia.commons.data.exception;

import org.gensis0.lib.dacia.commons.exception.CommonException;

/**
 * 文件操作异常
 * @author YX.alienware
 *
 */
public class FileOperationException extends CommonException{

	private static final long serialVersionUID = -7164133178468803227L;

	public FileOperationException(String msg) {
		super(msg);
	}

	public FileOperationException(String msg, Throwable e) {
		super(msg, e);
	}
}
