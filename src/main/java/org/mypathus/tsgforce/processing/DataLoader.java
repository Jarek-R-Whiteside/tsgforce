package org.mypathus.tsgforce.processing;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.mypathus.tsgforce.model.ReportIdentificationHelper;

public class DataLoader {
	
	final static Logger logger = Logger.getLogger(Class.class);
	
	public static void main(String[] args) {
		DataLoader dataLoader = new DataLoader();
		List<String> md5List = new ArrayList<String>();
		
		String fileName = "SAMPLE Balances08042014.txt";
		String fileType = dataLoader.getFileType(fileName);
		String fileDate = dataLoader.getFileDate(fileName);
		String md5 = dataLoader.getFileMd5(fileName);
		
		//need to store all md5s somewhere?
		if(md5List.contains(md5)){
			logger.error("File has already been loaded");
			return;
		}
		md5List.add(md5);
	}
	
	public String getFileType(String fileName) {
		return GenericFileHandler.getFileType(fileName);
	}

	public String getFileMd5(String fileName) {
		return GenericFileHandler.getFileMD5(fileName);
	}
	
	public String getFileDate(String fileName) {
		return GenericFileHandler.getTimeStampInFile(fileName);
	}
	
	public void loadFiles(String fileType, String fileName) {
		ReportIdentificationHelper identificationHelper = ReportIdentifier.getIdentificationHelper(fileType, fileName);
		int reportId = identificationHelper.getId();
		
		if(fileType.equals("text/plain")) {
			int dataStartRow = identificationHelper.getHeaderRow() + 2;
			TextFile textFile = new TextFile();
			textFile.processTextRecords(fileName, dataStartRow, reportId);
		}
	}
	
	
}
