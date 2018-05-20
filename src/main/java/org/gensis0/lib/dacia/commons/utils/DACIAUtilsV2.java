package org.gensis0.lib.dacia.commons.utils;

import org.gensis0.lib.dacia.commons.core.Tuple;

public interface DACIAUtilsV2<SOURCE extends Tuple, TARGET extends Tuple> {

	public TARGET doUtil(SOURCE sourceData) throws Exception;
}
