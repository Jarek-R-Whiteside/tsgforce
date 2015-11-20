package org.mypathus.tsgforce.processing;

import org.mypathus.tsgforce.dao.HeaderMappingDao;


public class ReportIdentifier {
 
	
	public static String identifyReportByHeader(String fileType, String fileName){
		if("text/plain".equals(fileType)){
    		return HeaderMappingDao.getTextReportType(fileName);
    	}
    	else {
    		return "bad file type";
    	}
    }
	
	// based on file type figure out what lines to look for
	// check those lines to see if there is a known header match
	
}
