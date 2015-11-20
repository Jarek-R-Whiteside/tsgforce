package org.mypathus.tsgforce;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.mypathus.tsgforce.processing.TextFile;

public class TextFileTest {
	TextFile textFile = new TextFile();
	String fileName1 = "SampleFileText1.txt";
	String fileName2 = "SampleFileText2.txt";
	String fileName3 = "SampleFileExcel.xls";
	String fileName4 = "SampleFileExcel.xlsx";
	
	@Ignore
	@Test
	public void getFileHeadersTest() {
		String fileHeaders = textFile.getTextFileHeaders(fileName1, 1);
		assertNotNull(fileHeaders);
		assertNotEquals("", fileHeaders);
	}
}
