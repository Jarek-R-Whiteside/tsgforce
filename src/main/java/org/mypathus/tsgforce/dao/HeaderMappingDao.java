package org.mypathus.tsgforce.dao;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.mypathus.tsgforce.model.ReportIdentificationHelper;
import org.mypathus.tsgforce.processing.Excel2003File;
import org.mypathus.tsgforce.processing.Excel2007File;
import org.mypathus.tsgforce.processing.TextFile;

public class HeaderMappingDao {
	
	static ReportIdentificationHelper helperTxt1 = new ReportIdentificationHelper("text/plain", "Employer                  Balance Description          Homebanking Status Mobile Banking Status Has EStatements Text                  Hold Amount Open Date  Close Date", "balances", 2);
	static ReportIdentificationHelper helperTxt2 = new ReportIdentificationHelper("text/plain", "Description          Description                Amount Date       Text", "history", 2);
	static ReportIdentificationHelper helperXls1 = new ReportIdentificationHelper("application/vnd.ms-excel", "Uniqe IDUsernameFirst NameLast NameProgram SiteTotal no. of loginsLength of loginsIs Expense Tracker completedIs My Budget completedIs Saving Generator completed", "myPathOnlineSample", 2);
	static ReportIdentificationHelper helperXls2 = new ReportIdentificationHelper("application/vnd.ms-excel", "UsernameFirst NameLast NameProgram SiteTotal no. of loginsLength of loginsIs Expense Tracker completedIs My Budget completedIs Saving Generator completed", "consolidatedUsersInformation", 1);
	static ReportIdentificationHelper helperXlsx1 = new ReportIdentificationHelper("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet/vnd.ms-excel", "Q1Q2Q3Q4Q5Q6Q7Q8Q9Q10Q11Q12Q13Q14Q15Q16Q17Q18Q19.Q20.Q21.Q22.Q23.ab.c.d.e.Q24.ab.c.d.e.f.g.Q25.ab.c.d.e.f.g.Q26.ab.c.d.e.f.Q27.abcdefghijQ28.abcQ29.abcdefghQ30Q31Q32Q33a.bcdefghijklmnopqrst", "Survey", 1);

	private static List<ReportIdentificationHelper> identificationHelpers = Arrays.asList(helperTxt1, helperTxt2, helperXls1, helperXls2, helperXlsx1);
	
	public static String getTextReportLayout(String fileName) {
		TextFile textFile = new TextFile();

		for (ReportIdentificationHelper helper : identificationHelpers) {
			if(helper.getType().equals("text/plain")){
				String dbHeaders = helper.getHeader();
				int row = helper.getRow();
				String headers = textFile.getTextFileHeaders(fileName, row);
				if (dbHeaders.equals(headers)) {
					return helper.getName();
				}
			}
		}
		return null;
	}
	
	public static String getXLSReportLayout(String fileName) {
		Excel2003File xls = new Excel2003File();
		
		for(ReportIdentificationHelper helper: identificationHelpers) {
			if(helper.getType().equals("application/vnd.ms-excel")) {
				try {
					String dbHeaders = helper.getHeader();
					int row = helper.getRow();
					String headers = xls.getExcelHeaders2003(fileName, row);
					if(dbHeaders.equals(headers)) {
						return helper.getName();
					} 
				} catch (IOException e) {
				e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static String getXLSXReportLayout(String fileName) {
		Excel2007File xls = new Excel2007File();
		
		for(ReportIdentificationHelper helper: identificationHelpers) {
			if(helper.getType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet/vnd.ms-excel")) {
				try {
					String dbHeaders = helper.getHeader();
					int row = helper.getRow();
					String headers = xls.getExcelHeaders2007(fileName, row);
					if(dbHeaders.equals(headers)) {
						return helper.getName();
					} 
				} catch (IOException e) {
				e.printStackTrace();
				}
			}
		}
		return null;
	}
}
