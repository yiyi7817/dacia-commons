package org.gensis0.lib.dacia.commons.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileScannerUtils implements DACIAUtils<File, List<File>> {

	// @AMNITService(name = "scanFile", scopeType = { ServiceType.FUNCTION })
	public List<File> doUtil(File sourceData) throws Exception {
		return findFiles(sourceData);
	}

	protected List<File> findFiles(File file) throws Exception {
		List<File> fs = new ArrayList<File>();
		if (file.exists() && file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				List<File> tfs = findFiles(f);
				if (tfs != null && tfs.size() > 0) {
					fs.addAll(tfs);
				}
			}
		}
		if (file.exists() && file.isFile()) {
			fs.add(file);
		}
		return fs;
	}
}
