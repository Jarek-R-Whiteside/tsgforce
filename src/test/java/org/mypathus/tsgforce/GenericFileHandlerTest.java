package org.mypathus.tsgforce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.mypathus.tsgforce.processing.Excel2003File;
import org.mypathus.tsgforce.processing.Excel2007File;
import org.mypathus.tsgforce.processing.GenericFileHandler;
import org.mypathus.tsgforce.processing.TextFile;


public class GenericFileHandlerTest {
	GenericFileHandler fileHandler = new GenericFileHandler();
	TextFile textFile = new TextFile();
	Excel2003File excel2003 = new Excel2003File();
	Excel2007File excel2007 = new Excel2007File();
	
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
		String actualDate = fileHandler.getTimeStampInFile(fileName1);
		assertEquals(expectedDate, actualDate);
	}
	
	@Ignore
	@Test
	public void identifyTextBasedOnHeadersTest() {
		String fileHeader = "";
		fileHeader = textFile.getTextFileHeaders(fileName1, 1);
		
		
		assertEquals("this is a text file", fileHandler.identifyFileStructure(fileHeader));
		assertNotNull(fileHeader);
		assertNotEquals("", fileHeader);
	}
	
	@Test
	public void identifyExcel2003BasedOnHeadersTest() {
		String fileHeader = "";
		String fileType;
		try {
			fileHeader = excel2003.getExcelHeaders2003(fileName3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileType = fileHandler.identifyFileStructure(fileHeader);
		assertEquals("this is an xls file", fileType);
		assertNotNull(fileHeader);
		assertNotEquals("", fileHeader);
	}
	
	@Test
	public void identifyExcel2007BasedOnHeadersTest() {
		String fileHeader = "";
		try {
			fileHeader = excel2007.getExcelHeaders2007(fileName4);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("this is an xlsx file", fileHandler.identifyFileStructure(fileHeader));
		assertNotNull(fileHeader);
		assertNotEquals("", fileHeader);
	}
	
}