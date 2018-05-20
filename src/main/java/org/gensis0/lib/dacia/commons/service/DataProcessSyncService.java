package org.gensis0.lib.dacia.commons.service;

import org.gensis0.lib.dacia.commons.core.Tuple;
import org.gensis0.lib.dacia.commons.service.exception.ServiceExecutionException;

public interface DataProcessSyncService<IN extends Tuple, OUT extends Tuple> extends ServiceHandler{

	public OUT syncProcess(IN inData) throws ServiceExecutionException;
	
}
