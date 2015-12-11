package org.mypathus.tsgforce.processing;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.mypathus.tsgforce.processing.Excel2007File;

public class Excel2007FileTest {
	Excel2007File excel2007 = new Excel2007File();
	String fileName = "SampleFileExcel.xlsx";
	
	@Test
	public void getExcelHeaders2007Test() throws IOException {
		String actualHeader = excel2007.getExcelHeaders2007(fileName, 2);
		String expectedHeader = "Q1Q2Q3Q4Q5Q6Q7Q8Q9Q10Q11Q12Q13Q14Q15Q16Q17Q18Q19.Q20.Q21.Q22.Q23.ab.c.d.e.Q24.ab.c.d.e.f.g.Q25.ab.c.d.e.f.g.Q26.ab.c.d.e.f.Q27.abcdefghijQ28.abcQ29.abcdefghQ30Q31Q32Q33a.bcdefghijklmnopqrst";
		assertNotNull(actualHeader);
		assertEquals(expectedHeader, actualHeader);
	}
	
}
