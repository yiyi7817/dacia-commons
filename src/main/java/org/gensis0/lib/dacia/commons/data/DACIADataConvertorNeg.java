package org.gensis0.lib.dacia.commons.data;

public interface DACIADataConvertorNeg<DATA extends DACIAOriginData> {

	public String convertToFileContent(DATA data, DACIASupportedDataType dataType, String encode) throws Exception;
}
