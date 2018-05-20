package org.gensis0.lib.dacia.commons.service;

import org.gensis0.lib.dacia.commons.ExecutionResult;
import org.gensis0.lib.dacia.commons.core.Tuple;
import org.gensis0.lib.dacia.commons.service.exception.ServiceExecutionException;

public interface DataProcessAsyncService<IN extends Tuple, OUT extends Tuple> extends ServiceHandler {

	public void syncProcess(IN inData) throws ServiceExecutionException;

	public ExecutionResult status();

	public OUT getResult();
}
