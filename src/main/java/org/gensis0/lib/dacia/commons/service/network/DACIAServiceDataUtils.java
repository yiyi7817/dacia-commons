package org.gensis0.lib.dacia.commons.service.network;

import org.gensis0.lib.dacia.commons.service.ServiceRequest;
import org.gensis0.lib.dacia.commons.service.ServiceResponse;

public interface DACIAServiceDataUtils<REQ, REP> {

	public ServiceRequest convertRequest(REQ req);

	public ServiceResponse convertResponse(REP rep);
}
