package org.mypathus.tsgforce.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.mypathus.tsgforce.model.HeaderFieldMapping;

public class HeaderMappingDaoTest {
	
	String balances = "SAMPLE Balances08042014.txt";
	String myPathOnlineSample = "MyPathOnline SAMPLE.xls";
	String survey = "SAMPLE Post Surveys.xlsx";
	
	@Test
	public void initFactoryTest(){
		HeaderMappingDao dao = new HeaderMappingDao();
		assertNotNull(dao.factory);
	}
	
	
	
	@Test
	public void getHeaderFieldMappingTest() {
		HeaderMappingDao mappingDao = new HeaderMappingDao();
		List<HeaderFieldMapping> fieldMappingList = mappingDao.getAllHeaderFieldMappings(1);
		assertNotNull(fieldMappingList);
		assertEquals(10, fieldMappingList.size());
	}

}
