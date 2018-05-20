package org.gensis0.lib.dacia.commons.service.business;

import org.gensis0.lib.dacia.commons.service.DACIASyncServiceHandler;
import org.gensis0.lib.dacia.commons.service.ServiceRequest;
import org.gensis0.lib.dacia.commons.service.ServiceResponse;

public interface BusinessSyncServiceHandler<Q extends ServiceRequest, P extends ServiceResponse>
		extends DACIASyncServiceHandler<Q, P> {

}
