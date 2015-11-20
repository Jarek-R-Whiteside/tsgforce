package org.mypathus.tsgforce.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.mypathus.tsgforce.processing.TextFile;

public class TextFileTest {
	TextFile textFile = new TextFile();
	String fileName1 = "SampleFileText1.txt";
	String fileName2 = "SampleFileText2.txt";
	String fileName3 = "SampleFileExcel.xls";
	String fileName4 = "SampleFileExcel.xlsx";
	
	@Test
	public void getFileHeadersTest() {
		String expectedFileHeader = "Employer                  Balance Description          Homebanking Status Mobile Banking Status Has EStatements Text                  Hold Amount Open Date  Close Date";
		String actualFileHeader = textFile.getTextFileHeaders(fileName1, 5);
		assertNotNull(actualFileHeader);
		assertEquals(expectedFileHeader, actualFileHeader);
	}
}
