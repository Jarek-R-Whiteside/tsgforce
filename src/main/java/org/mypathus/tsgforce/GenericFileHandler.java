package org.mypathus.tsgforce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import org.apache.tika.Tika;

public class GenericFileHandler {
	
	private String fileDirectory = FilesContainer.getFileDirectory();
	
	public static void main(String[] args) {

	}
	
	public String getFileType(String fileName) {
		Tika tika = new Tika();
		Path path = Paths.get(fileDirectory + fileName);
		String fileType  = "";
		try {
			fileType = tika.detect(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileType;
	}
	
	public String getFileMD5(String fileName) {
		String md5 = "";
		try {
			FileInputStream fis = new FileInputStream(new File(fileDirectory + fileName));
			md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return md5;
	}
	
	public String getFileCreationDate(String fileName) {
		Path path = Paths.get(fileDirectory + fileName);
		try {
			BasicFileAttributes fileAttr = Files.readAttributes(path, BasicFileAttributes.class);
			return fileAttr.creationTime().toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Invalid File";
	}
	
	public String getTimeStampInFile(String fileName) {
		String timeStamp = "";
		Path path = Paths.get(fileDirectory + fileName);
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			String firstLine = reader.readLine();
			String[] strArray = firstLine.split(" ");
			timeStamp = strArray[0] + " " + strArray[1];
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return timeStamp;
	}

	public String identifyFileStructure(String headersLine){
		String textHeader = "Employer                  Balance Description          Homebanking Status Mobile Banking Status Has EStatements Text                  Hold Amount Open Date  Close Date";
		String xlsHeader = "Uniqe IDUsernameFirst NameLast NameProgram SiteTotal no. of loginsLength of loginsIs Expense Tracker completedIs My Budget completedIs Saving Generator completed";
		String xlsxHeader = "Q1Q2Q3Q4Q5Q6Q7Q8Q9Q10Q11Q12Q13Q14Q15Q16Q17Q18Q19.Q20.Q21.Q22.Q23.ab.c.d.e.Q24.ab.c.d.e.f.g.Q25.ab.c.d.e.f.g.Q26.ab.c.d.e.f.Q27.abcdefghijQ28.abcQ29.abcdefghQ30Q31Q32Q33a.bcdefghijklmnopqrst";

		String fileType;
		if (headersLine.compareTo(textHeader) == 0){
			fileType = "this is a text file";
		}
		else if(headersLine.compareTo(xlsHeader) == 0){
			fileType = "this is an xls file";

		}
		else if(headersLine.compareTo(xlsxHeader) == 0){
			fileType = "this is an xlsx file";
		}
		else{
			fileType = "invalid file type";
		}
		return fileType;
	}
	

}