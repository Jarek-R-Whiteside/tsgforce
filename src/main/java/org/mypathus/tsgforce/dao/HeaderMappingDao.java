package org.mypathus.tsgforce.dao;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.mypathus.tsgforce.model.ReportIdentificationHelper;
import org.mypathus.tsgforce.processing.Excel2003File;
import org.mypathus.tsgforce.processing.Excel2007File;
import org.mypathus.tsgforce.processing.TextFile;

public class HeaderMappingDao {
	
	final static Logger logger = Logger.getLogger(Class.class);
	
	static ReportIdentificationHelperDao identificationHelperDao = new ReportIdentificationHelperDao();
	private static List<ReportIdentificationHelper> identificationHelpers = identificationHelperDao.getAllIdentificationHelpers();
	
	public static ReportIdentificationHelper getTextReportLayout(String fileName) {
		TextFile textFile = new TextFile();

		for (ReportIdentificationHelper helper : identificationHelpers) {
			if(helper.getType().equals("text/plain")){
				String dbHeaders = helper.getHeader();
				int row = helper.getRow();
				String headers = textFile.getTextFileHeaders(fileName, row);
				if (dbHeaders.equals(headers)) {
					return helper;
				}
			}
		}
		return null;
	}
	
	public static ReportIdentificationHelper getXLSReportLayout(String fileName) {
		Excel2003File xls = new Excel2003File();
		
		for(ReportIdentificationHelper helper: identificationHelpers) {
			if(helper.getType().equals("application/vnd.ms-excel")) {
				try {
					String dbHeaders = helper.getHeader();
					int row = helper.getRow();
					String headers = xls.getExcelHeaders2003(fileName, row);
					if(dbHeaders.equals(headers)) {
						return helper;
					} 
				} catch (IOException e) {
					logger.error("Unable to read excel 2003 file: " + fileName);
				}
			}
		}
		return null;
	}

	public static ReportIdentificationHelper getXLSXReportLayout(String fileName) {
		Excel2007File xls = new Excel2007File();
		
		for(ReportIdentificationHelper helper: identificationHelpers) {
			if(helper.getType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet/vnd.ms-excel")) {
				try {
					String dbHeaders = helper.getHeader();
					int row = helper.getRow();
					String headers = xls.getExcelHeaders2007(fileName, row);
					if(dbHeaders.equals(headers)) {
						return helper;
					} 
				} catch (IOException e) {
					logger.error("Unable to read xslx excel file: " + fileName);
				}
			}
		}
		return null;
	}
}
