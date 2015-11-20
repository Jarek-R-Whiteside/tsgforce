package org.mypathus.tsgforce.processing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
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
		String actualFileType = GenericFileHandler.getFileType(fileName1);
		assertEquals(expectedFileType, actualFileType);
	}
	
	@Test
	public void getFileMD5Test() {
		String expectedMD5 = "474e94867373689ed8b01091d0e34fbb";
		String actualMD5 = GenericFileHandler.getFileMD5(fileName1);
		assertEquals(expectedMD5, actualMD5);
	}
	
	@Test
	public void getFileMD5NoTwoFilesHaveSameMD5Test() {
		String MD51 = GenericFileHandler.getFileMD5(fileName1);
		String MD52 = GenericFileHandler.getFileMD5(fileName2);
		assertNotEquals(MD51, MD52);
	}
	
	@Test
	public void getFileTimeStampTest() {
		String expectedDate = "08/04/2014 08:00";
		String actualDate = fileHandler.getTimeStampInFile(fileName1);
		assertEquals(expectedDate, actualDate);
	}
	
	@Test
	public void getFileCreationDateTest() {
		String actualCreationDate = fileHandler.getFileCreationDate(fileName3);
		assertNotNull(actualCreationDate);
		assertNotEquals("", actualCreationDate);
	}
	
	
	
}