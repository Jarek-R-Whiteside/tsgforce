package org.mypathus.tsgforce.processing;

import org.mypathus.tsgforce.dao.ReportIdentificationHelperDao;
import org.mypathus.tsgforce.model.ReportIdentificationHelper;


public class ReportIdentifier {
 
	
	public static int identifyReportByHeader(String fileType, String fileName){
		return getIdentificationHelper(fileType, fileName).getId();
    }
	
	public static ReportIdentificationHelper getIdentificationHelper(String fileType, String fileName){
		if("text/plain".equals(fileType)){
    		return ReportIdentificationHelperDao.getTextIdentificationHelper(fileName);
    	}
		else if("application/vnd.ms-excel".equals(fileType)) {
			return ReportIdentificationHelperDao.getXLSIdentificationHelper(fileName);
		}
		else if("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet/vnd.ms-excel".equals(fileType)) {
			return ReportIdentificationHelperDao.getXLSXIdentificationHelper(fileName);
		}
    	else {
    		return null;
    	}
	}
	
}
