package org.mypathus.tsgforce.dao;

import java.util.Arrays;
import java.util.List;

import org.mypathus.tsgforce.processing.TextFile;

public class HeaderMappingDao {

	public static String balances = "Employer                  Balance Description          Homebanking Status Mobile Banking Status Has EStatements Text                  Hold Amount Open Date  Close Date";
	public static String history = "Description          Description                Amount Date       Text";
	public static String myPathOnlineSample = "Uniqe IDUsernameFirst NameLast NameProgram SiteTotal no. of loginsLength of loginsIs Expense Tracker completedIs My Budget completedIs Saving Generator completed";
	public static String Survey = "Q1Q2Q3Q4Q5Q6Q7Q8Q9Q10Q11Q12Q13Q14Q15Q16Q17Q18Q19.Q20.Q21.Q22.Q23.ab.c.d.e.Q24.ab.c.d.e.f.g.Q25.ab.c.d.e.f.g.Q26.ab.c.d.e.f.Q27.abcdefghijQ28.abcQ29.abcdefghQ30Q31Q32Q33a.bcdefghijklmnopqrst";
	public static String consolidatedUsersInformation = "UsernameFirst NameLast NameProgram SiteTotal no. of loginsLength of loginsIs Expense Tracker completedIs My Budget completedIs Saving Generator completed";

	static List<Integer> textHeaderLines = Arrays.asList(2);
	static List<Integer> xlsHeaderLines = Arrays.asList(2, 1);
	static List<Integer> xlsxHeaderLines = Arrays.asList(2, 1);

	public static String getTextReportLayout(String fileName) {
		String headers = null;
		TextFile textFile = new TextFile();

		for (int i = 0; i < textHeaderLines.size(); i++) {
			headers = textFile.getTextFileHeaders(fileName, textHeaderLines.get(i));
			if (headers.equals(balances)) {
				return "Balances";
			} else if (headers.equals(history)) {
				return "History";
			}
		}
		return null;
	}

}
