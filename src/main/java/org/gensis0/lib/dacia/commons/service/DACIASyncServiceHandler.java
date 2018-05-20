package org.gensis0.lib.dacia.commons.service;

import org.gensis0.lib.dacia.commons.service.exception.ServiceExecutionException;

/**
 * 通用同步服务接口，同步是双向的。
 * 
 * @author yihan
 *
 */
public interface DACIASyncServiceHandler<Q extends ServiceRequest, P extends ServiceResponse> extends ServiceHandler {

	public P doService(Q request) throws ServiceExecutionException;

	public Q getRequestObject();

	public P getResponseObject();
}
