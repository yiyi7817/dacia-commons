package org.gensis0.lib.dacia.commons.service;

import org.gensis0.lib.dacia.commons.ExecutionResult;
import org.gensis0.lib.dacia.commons.service.exception.ServiceExecutionException;

/**
 * 通用服务异步接口,异步是单向的。
 * 
 * @author yihan
 *
 */
public interface DACIAAsyncServiceHandler<Q extends ServiceRequest> extends ServiceHandler {

	public ExecutionResult doService(Q request) throws ServiceExecutionException;

	public Q getRequestObject();
}
