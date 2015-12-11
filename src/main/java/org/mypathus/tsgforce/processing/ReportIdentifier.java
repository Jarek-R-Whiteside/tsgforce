package org.mypathus.tsgforce.processing;

import org.mypathus.tsgforce.dao.HeaderMappingDao;
import org.mypathus.tsgforce.model.ReportIdentificationHelper;


public class ReportIdentifier {
 
	
	public static int identifyReportByHeader(String fileType, String fileName){
		return getIdentificationHelper(fileType, fileName).getId();
    }
	
	public static ReportIdentificationHelper getIdentificationHelper(String fileType, String fileName){
		if("text/plain".equals(fileType)){
    		return HeaderMappingDao.getTextIdentificationHelper(fileName);
    	}
		else if("application/vnd.ms-excel".equals(fileType)) {
			return HeaderMappingDao.getXLSIdentificationHelper(fileName);
		}
		else if("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet/vnd.ms-excel".equals(fileType)) {
			return HeaderMappingDao.getXLSXIdentificationHelper(fileName);
		}
    	else {
    		return null;
    	}
	}
	
}
