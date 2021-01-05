package com.nagarro.nagpmanagement.util;

import java.io.File;
import java.io.FileFilter;

public class GetExcelFiles {
	File file;

	public GetExcelFiles(String path) {
		file = new File(path);
	}

	File[] allFiles;

	/**
	 * look for files at given location ending with .csv
	 */
	public File[] read() {
		File file = this.file;
		FileFilter filter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isFile() && pathname.getName().endsWith(".xlsx");
			}
		};
		allFiles = file.listFiles(filter);
		return allFiles;

	}

}
