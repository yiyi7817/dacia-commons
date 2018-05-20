package org.gensis0.lib.dacia.commons.security;

import org.gensis0.lib.dacia.commons.ExecutionResult;
import org.gensis0.lib.dacia.commons.service.exception.ServiceExecutionException;

public interface SecurityAlgorithmOps<OUT, IN> {

	public String getAlgorithmName();

	public OUT hash(IN data) throws ServiceExecutionException;

	public OUT sign(IN data) throws ServiceExecutionException;

	public OUT encrypt(IN data) throws ServiceExecutionException;

	public ExecutionResult checkSign(IN data) throws ServiceExecutionException;

	public IN decrypt(OUT data) throws ServiceExecutionException;
}
