package org.mypathus.tsgforce.processing;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.mypathus.tsgforce.model.ReportIdentificationHelper;

public class ReportIdentifierTest {

	String balances = "SAMPLE Balances08042014.txt";
	String history = "SAMPLE History08042014.txt";
	String myPathOnlineSample = "MyPathOnline SAMPLE.xls";
	String survey = "SAMPLE Post Surveys.xlsx";
	
	@Test
	public void identifyReportByHeaderTest() {
		assertEquals(1, ReportIdentifier.identifyReportByHeader("text/plain", balances));
		assertEquals(2, ReportIdentifier.identifyReportByHeader("text/plain", history));
	}
	
	@Test
	public void getTextIdentificationHelperTest() {
		ReportIdentificationHelper helper = ReportIdentifier.getIdentificationHelper("text/plain", balances);
		assertEquals(1, helper.getId());
		assertEquals("balances", helper.getName());
		assertEquals("text/plain", helper.getType());
	}
	
	@Ignore
	@Test
	public void getXLSIdentificationHelper() {
		ReportIdentificationHelper helper = ReportIdentifier.getIdentificationHelper("application/vnd.ms-excel", myPathOnlineSample);
		assertEquals(3, helper.getId());
		assertEquals("myPathOnlineSample", helper.getName());
		assertEquals("application/vnd.ms-excel", helper.getType());
	}
	
	@Ignore
	@Test
	public void getXLSXIdentificationHelperTest() {
		ReportIdentificationHelper helper = ReportIdentifier.getIdentificationHelper("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet/vnd.ms-excel", survey);
		assertEquals(4, helper.getId());
		assertEquals("survey", helper.getName());
		assertEquals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet/vnd.ms-excel", helper.getType());
	}

}
