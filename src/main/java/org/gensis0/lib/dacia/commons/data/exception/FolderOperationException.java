package org.gensis0.lib.dacia.commons.data.exception;

import org.gensis0.lib.dacia.commons.exception.CommonException;

/**
 * 文件夹操作异常
 * @author YX.alienware
 *
 */
public class FolderOperationException extends CommonException{
	private static final long serialVersionUID = -7164133178468803227L;

	public FolderOperationException(String msg) {
		super(msg);
	}

	public FolderOperationException(String msg, Throwable e) {
		super(msg, e);
	}
}
