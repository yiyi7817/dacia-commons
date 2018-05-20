package org.gensis0.lib.dacia.commons.data.operation;

import org.gensis0.lib.dacia.commons.data.connection.DACIADataConnection;
import org.gensis0.lib.dacia.commons.data.exception.DACIADataExecutionException;

public interface DACIADataOperation {

	public DACIADataConnection getConnection();
	public boolean create() throws DACIADataExecutionException;
	
}
