package org.mypathus.tsgforce;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class FileHandlerTest {
	FileHandler fileHandler = new FileHandler();
	String fileName1 = "SampleFileText1.txt";
	String fileName2 = "SampleFileText2.txt";
	String fileName3 = "SampleFileExcel.xls";
	String fileName4 = "SampleFileExcel.xlsx";

	

	@Test
	public void getFileTypeTest() {
		String expectedFileType = "text/plain";
		String actualFileType = fileHandler.getFileType(fileName1);
		assertEquals(expectedFileType, actualFileType);
	}
	
	@Test
	public void getFileMD5Test() {
		String expectedMD5 = "474e94867373689ed8b01091d0e34fbb";
		String actualMD5 = fileHandler.getFileMD5(fileName1);
		assertEquals(expectedMD5, actualMD5);
	}
	
	@Test
	public void getFileMD5NoTwoFilesHaveSameMD5Test() {
		String MD51 = fileHandler.getFileMD5(fileName1);
		String MD52 = fileHandler.getFileMD5(fileName2);
		assertNotEquals(MD51, MD52);
	}
	
	@Test
	public void getFileTimeStampTest() {
		String expectedDate = "08/04/2014 08:00";
		String actualDate = fileHandler.getFileTimeStamp(fileName1);
		assertEquals(expectedDate, actualDate);
	}
	
	@Test
	public void getFileHeadersTest() {
		String fileHeaders = fileHandler.getFileHeaders(fileName1);
		assertNotNull(fileHeaders);
		assertNotEquals("", fileHeaders);
	}
	
	@Test
	public void getExcelHeaders2007Test() throws IOException {
		String excelHeader = fileHandler.getExcelHeaders2007(fileName4);
		assertNotNull(excelHeader);
		assertNotEquals("", excelHeader);
	}
	
	@Test
	public void identifyTextBasedOnHeadersTest() {
		String fileHeader = "";
		fileHeader = fileHandler.getFileHeaders(fileName1);
		fileHandler.identifyFileBasedOnHeaders(fileHeader);
		
		assertNotNull(fileHeader);
		assertNotEquals("", fileHeader);
	}
	
// before we can test this method with xls, we need to change the method from void to String return type in FileHandler.java
//	
//	@Test
//	public void identifyExcel2003BasedOnHeadersTest() {
//		String fileHeader = "";
//		try {
//			fileHeader = fileHandler.getExcelHeaders2003(fileName3);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		fileHandler.identifyFileBasedOnHeaders(fileHeader);
//		
//		assertNotNull(fileHeader);
//		assertNotEquals("", fileHeader);
//	}
	
	@Test
	public void identifyExcel2007BasedOnHeadersTest() {
		String fileHeader = "";
		try {
			fileHeader = fileHandler.getExcelHeaders2007(fileName4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileHandler.identifyFileBasedOnHeaders(fileHeader);
		
		assertNotNull(fileHeader);
		assertNotEquals("", fileHeader);
	}
	

	
	// I know the output is ugly, this is my first time working with JUNIT testing,
	// I need to come up with a way to clean it up. - Trevor
}