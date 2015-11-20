package org.mypathus.tsgforce;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.mypathus.tsgforce.processing.Excel2007File;

public class Excel2007FileTest {
	Excel2007File excel2007 = new Excel2007File();
	String fileName = "SampleFileExcel.xlsx";
	
	@Test
	public void getExcelHeaders2007Test() throws IOException {
		String excelHeader = excel2007.getExcelHeaders2007(fileName);
		assertNotNull(excelHeader);
		assertNotEquals("", excelHeader);
	}
	
}
