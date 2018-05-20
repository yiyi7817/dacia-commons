package org.gensis0.lib.dacia.commons.service.network;

import org.gensis0.lib.dacia.commons.ExecutionResult;
import org.gensis0.lib.dacia.commons.service.DACIASyncServiceHandler;
import org.gensis0.lib.dacia.commons.service.ServiceRequest;
import org.gensis0.lib.dacia.commons.service.ServiceResponse;

/**
 * 网络服务同步接口
 * 
 * @author yihan
 *
 * @param <Q>
 *            服务请求
 * @param <P>
 *            服务应答
 */
public interface NetworkSyncServiceHandler<Q extends ServiceRequest, P extends ServiceResponse>
		extends DACIASyncServiceHandler<Q, P> {

	/**
	 * 服务运行情况。
	 * 
	 * @return
	 */
	public ExecutionResult status();

	/**
	 * 请求与应答转换。
	 * 
	 * @param req
	 * @return
	 */
	public P convert(Q req);

}
