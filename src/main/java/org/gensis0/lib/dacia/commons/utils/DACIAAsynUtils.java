package org.gensis0.lib.dacia.commons.utils;

import java.util.concurrent.Callable;

import org.gensis0.lib.dacia.commons.ExecutionResult;

public interface DACIAAsynUtils<SOURCE, TARGET> extends Callable<TARGET> {

	public ExecutionResult doUtil(SOURCE sourceData) throws Exception;

	public boolean completed();

	public TARGET getResult() throws Exception;
}
