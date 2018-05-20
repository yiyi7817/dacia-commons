package org.gensis0.lib.dacia.commons;

import org.gensis0.lib.dacia.commons.exception.ServerOperationException;

public interface ConnectionOperation<E extends DACIAConnection> {

	public E open() throws ServerOperationException;

	public void close() throws ServerOperationException;

	public E get() throws ServerOperationException;
}
