package org.gensis0.lib.dacia.commons.utils;

import java.util.concurrent.Callable;

import org.gensis0.lib.dacia.commons.ExecutionResult;
import org.gensis0.lib.dacia.commons.core.Tuple;

public interface DACIAAsynUtilsV2<SOURCE extends Tuple, TARGET extends Tuple> extends Callable<TARGET> {

	public ExecutionResult doUtil(SOURCE sourceData) throws Exception;

	public boolean completed();

	public TARGET getResult() throws Exception;
}
