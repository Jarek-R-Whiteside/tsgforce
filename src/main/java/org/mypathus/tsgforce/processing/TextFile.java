package org.mypathus.tsgforce.processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.mypathus.tsgforce.dao.HeaderMappingDao;
import org.mypathus.tsgforce.model.HeaderFieldMapping;
import org.mypathus.tsgforce.resources.FileContainer;

public class TextFile {
	
	private String fileDirectory = FileContainer.getFileDirectory();
	
	public static void main(String[] args) {
		TextFile tf = new TextFile();
		tf.processTextRecords("SampleFileText1.txt", 7, 1);
	}
	
	public String getTextFileHeaders(String fileName, Integer row) {
		Path path = Paths.get(fileDirectory + fileName);
		String headersLine = "";
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			for(int i = 1; i<row; i++) {
				reader.readLine();
			}
			headersLine = reader.readLine();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return headersLine;
	}
	
	public void processTextRecords(String fileName, Integer dataStartRow, Integer reportId) {
		Path path = Paths.get(fileDirectory + fileName);
		HeaderMappingDao mappingDao = new HeaderMappingDao();
		List<HeaderFieldMapping> fieldMappingList = mappingDao.getAllHeaderFieldMappings(reportId);
		String line = "";
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			for(int i = 1; i<dataStartRow; i++) {
				reader.readLine();
			}
			
			while((line = reader.readLine()) != null) {
				insertTextRecord(line, fieldMappingList);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void insertTextRecord(String line, List<HeaderFieldMapping> fieldMappingList) {
		
	}
	
	
	
	//TODO process delimited files (pass delimiter as params)
}
