package org.mypathus.tsgforce.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mypathus.tsgforce.model.ReportIdentificationHelper;

public class HeaderMappingDaoTest {
	
	String balances = "SAMPLE Balances08042014.txt";
	String myPathOnlineSample = "MyPathOnline SAMPLE.xls";
	String survey = "SAMPLE Post Surveys.xlsx";
	
	@Test
	public void getTextReportLayoutTest() {
		ReportIdentificationHelper helper = HeaderMappingDao.getTextReportLayout(balances);
		int actualId = helper.getId();
		int expectedId = 1;
				
		assertEquals(expectedId, actualId);
	}

}
