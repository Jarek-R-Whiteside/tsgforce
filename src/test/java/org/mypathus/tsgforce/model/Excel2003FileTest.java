package org.mypathus.tsgforce.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.mypathus.tsgforce.processing.Excel2003File;

public class Excel2003FileTest {
	Excel2003File excel2003 = new Excel2003File();
	String fileName1 = "SampleFileExcel.xls";
	String fileName2 = "SampleFileExcel.xlsx";
	
	@Test
	public void getExcelHeaders2003Test() throws IOException {
		String expectedHeaders = "Uniqe IDUsernameFirst NameLast NameProgram SiteTotal no. of loginsLength of loginsIs Expense Tracker completedIs My Budget completedIs Saving Generator completed";
		String actualHeaders = excel2003.getExcelHeaders2003(fileName1, 1);
		assertNotNull(actualHeaders);
		assertEquals(expectedHeaders, actualHeaders);
	}

}
