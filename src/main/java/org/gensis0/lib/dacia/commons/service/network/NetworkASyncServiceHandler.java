package org.gensis0.lib.dacia.commons.service.network;

import org.gensis0.lib.dacia.commons.ExecutionResult;
import org.gensis0.lib.dacia.commons.service.DACIAAsyncServiceHandler;
import org.gensis0.lib.dacia.commons.service.ServiceRequest;

/**
 * 网络服务异步接口。
 * 
 * @author yihan
 *
 * @param <Q>
 *            网络服务请求。
 */
public interface NetworkASyncServiceHandler<Q extends ServiceRequest> extends DACIAAsyncServiceHandler<Q> {

	/**
	 * 获取运行状态。
	 * 
	 * @return
	 */
	public ExecutionResult status();
}
