package org.gensis0.lib.dacia.commons.data;

import java.io.InputStream;

public interface DACIADataConvertorPos<DATA extends DACIAOriginData> {

	public DATA convertToOriginData(InputStream in, DACIASupportedDataType dataType, String encode) throws Exception;
}
