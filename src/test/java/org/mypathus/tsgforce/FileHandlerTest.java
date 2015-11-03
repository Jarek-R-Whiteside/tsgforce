package org.mypathus.tsgforce;

import static org.junit.Assert.*;

import org.junit.Test;


public class FileHandlerTest {
	FileHandler fileHandler = new FileHandler();
	String fileName1 = "SampleFileText1.txt";
	String fileName2 = "SampleFileText2.txt";

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

}
