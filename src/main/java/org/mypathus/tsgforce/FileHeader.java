package org.mypathus.tsgforce;

public class FileHeader {
	public static String  balances = "Employer                  Balance Description          Homebanking Status Mobile Banking Status Has EStatements Text                  Hold Amount Open Date  Close Date";
	public static String history = "Description          Description                Amount Date       Text";
	public static String myPathOnlineSample = "Uniqe IDUsernameFirst NameLast NameProgram SiteTotal no. of loginsLength of loginsIs Expense Tracker completedIs My Budget completedIs Saving Generator completed";
	public static String Survey = "Q1Q2Q3Q4Q5Q6Q7Q8Q9Q10Q11Q12Q13Q14Q15Q16Q17Q18Q19.Q20.Q21.Q22.Q23.ab.c.d.e.Q24.ab.c.d.e.f.g.Q25.ab.c.d.e.f.g.Q26.ab.c.d.e.f.Q27.abcdefghijQ28.abcQ29.abcdefghQ30Q31Q32Q33a.bcdefghijklmnopqrst";
	public static  String consolidatedUsersInformation = "UsernameFirst NameLast NameProgram SiteTotal no. of loginsLength of loginsIs Expense Tracker completedIs My Budget completedIs Saving Generator completed";
    public static String getReportByHeader(String fileType, String fileName){
    	String headers;
    	if(fileType == "application/vnd.ms-excel") {
    		return "xls";
    	}
    	else if(fileType == "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"){
    		return "xlsx";
    	}
    	else if(fileType == "text/plain"){
    		TextFile textFile = new TextFile();
    		headers = textFile.getTextFileHeaders(fileName);
    		headers = headers.replaceAll("\\s+","");
    		if(headers == balances.replaceAll("\\s+","")) {
    			return "Balances";
    		}
    		else if (headers == history.replaceAll("\\s+","")) {
    			return "History";
    		}
    		return "text";
    	}
    	else {
    		return "bad file type";
    	}
    }
}
