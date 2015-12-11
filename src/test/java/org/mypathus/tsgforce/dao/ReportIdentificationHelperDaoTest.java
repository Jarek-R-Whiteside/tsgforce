package org.mypathus.tsgforce.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.mypathus.tsgforce.model.ReportIdentificationHelper;

public class ReportIdentificationHelperDaoTest {

	String balances = "SAMPLE Balances08042014.txt";
	String myPathOnlineSample = "MyPathOnline SAMPLE.xls";
	String survey = "SAMPLE Post Surveys.xlsx";
	
	@Test
	public void initFactoryTest() {
		ReportIdentificationHelperDao helperDao = new ReportIdentificationHelperDao();
		assertNotNull(helperDao.factory);
	}
	
	@Test
	public void IdentificationHelpersNotNullTest(){
		assertNotNull(HeaderMappingDao.identificationHelpers);
	}
	
	@Test
	public void getTextIdentificationHelperTest() {
		ReportIdentificationHelper helper = ReportIdentificationHelperDao.getTextIdentificationHelper(balances);
		assertEquals(1, helper.getId());
		assertEquals("balances", helper.getName());
		assertEquals("text/plain", helper.getType());
	}
	
	@Ignore
	@Test
	public void getXLSIdentificationHelper() {
		ReportIdentificationHelper helper = ReportIdentificationHelperDao.getXLSIdentificationHelper(myPathOnlineSample);
		assertEquals(3, helper.getId());
		assertEquals("myPathOnlineSample", helper.getName());
		assertEquals("application/vnd.ms-excel", helper.getType());
	}
	
	@Ignore
	@Test
	public void getXLSXIdentificationHelperTest() {
		ReportIdentificationHelper helper = ReportIdentificationHelperDao.getXLSXIdentificationHelper(survey);
		assertEquals(4, helper.getId());
		assertEquals("survey", helper.getName());
		assertEquals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet/vnd.ms-excel", helper.getType());
	}
	
	@Test
	public void getAllIdentificationHelpersTest(){
		ReportIdentificationHelperDao dao = new ReportIdentificationHelperDao();
		assertNotNull(dao.getAllIdentificationHelpers());
	}

}
