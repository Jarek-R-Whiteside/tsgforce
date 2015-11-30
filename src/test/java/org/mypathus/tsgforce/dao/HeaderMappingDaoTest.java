package org.mypathus.tsgforce.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeaderMappingDaoTest {
	
	String balances = "SAMPLE Balances08042014.txt";
	String myPathOnlineSample = "MyPathOnline SAMPLE.xls";
	String survey = "SAMPLE Post Surveys.xlsx";
	
	@Test
	public void getTextReportLayoutTest() {
		String actualId = HeaderMappingDao.getTextReportLayout(balances);
		String expectedId = "balances";
				
		assertEquals(expectedId, actualId);
	}
	
	@Test
	public void getXLSReportLayoutTest() {
		String actualId = HeaderMappingDao.getXLSReportLayout(myPathOnlineSample);
		String expectedId = "myPathOnlineSample";
				
		assertEquals(expectedId, actualId);
	}
	
	@Test
	public void getXLSXReportLayoutTest() {
		String actualId = HeaderMappingDao.getXLSXReportLayout(survey);
		String expectedId = "survey";
				
		assertEquals(expectedId, actualId);
	}
}
