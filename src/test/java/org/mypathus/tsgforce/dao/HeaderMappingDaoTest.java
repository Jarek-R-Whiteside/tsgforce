package org.mypathus.tsgforce.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.mypathus.tsgforce.model.HeaderFieldMapping;
import org.mypathus.tsgforce.model.ReportIdentificationHelper;
import org.mypathus.tsgforce.processing.ReportIdentifier;

public class HeaderMappingDaoTest {
	
	String balances = "SAMPLE Balances08042014.txt";
	String myPathOnlineSample = "MyPathOnline SAMPLE.xls";
	String survey = "SAMPLE Post Surveys.xlsx";
	
	@Test
	public void getTextReportLayoutTest() {
		ReportIdentificationHelper helper = ReportIdentifier.getIdentificationHelper("text/plain", balances);
		int actualId = helper.getId();
		int expectedId = 1;
				
		assertEquals(expectedId, actualId);
	}
	
	@Test
	public void getHeaderFieldMappingTest() {
		HeaderMappingDao mappingDao = new HeaderMappingDao();
		List<HeaderFieldMapping> fieldMappingList = mappingDao.getAllHeaderFieldMappings(1);
		assertNotNull(fieldMappingList);
		assertEquals(10, fieldMappingList.size());
	}

}
