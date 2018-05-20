package org.gensis0.lib.dacia.commons.data.exception;

import org.gensis0.lib.dacia.commons.exception.CommonException;

/**
 * 文件操作器配置异常
 * @author YX.alienware
 *
 */
public class FileConfigurationException extends CommonException {

	private static final long serialVersionUID = -7164133178468803227L;

	public FileConfigurationException(String msg) {
		super(msg);
	}

	public FileConfigurationException(String msg, Throwable e) {
		super(msg, e);
	}

}
