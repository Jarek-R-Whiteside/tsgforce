package org.mypathus.tsgforce.processing;

import org.mypathus.tsgforce.dao.HeaderMappingDao;


public class ReportIdentifier {
 
	
	public static String identifyReportByHeader(String fileType, String fileName){
		if("text/plain".equals(fileType)){
    		return HeaderMappingDao.getTextReportLayout(fileName);
    	}
		else if("application/vnd.ms-excel".equals(fileType)) {
			return HeaderMappingDao.getXLSReportLayout(fileName);
		}
    	else {
    		return null;
    	}
    }
	
}
