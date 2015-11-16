package org.mypathus.tsgforce;

import java.io.BufferedReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Iterator;
import org.apache.tika.Tika;

public class FileHandler {
	
	private String fileDirectory = "./src/main/resources/";
	
	public static void main(String[] args) {
		FileHandler fh = new FileHandler();
		
		
	String fileHeader = "";
		try {
			fileHeader = fh.getExcelHeaders2003("SampleFileExcel.xls");
		} catch (IOException e) {
			e.printStackTrace();
		}
	//fileHeader = fh.getFileHeaders("SampleFileText1.txt");

		fh.identifyFileBasedOnHeaders(fileHeader);
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
	
	public String getFileTimeStamp(String fileName) {
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
	
	public String getFileHeaders(String fileName) {
		Path path = Paths.get(fileDirectory + fileName);
		String headersLine = "";
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			for(int i = 0; i<4; i++) {
				reader.readLine();
			}
			headersLine = reader.readLine();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return headersLine;
	}
	
	public String getExcelHeaders2003(String fileName) throws IOException{
		Path path = Paths.get(fileDirectory + fileName);
		  FileInputStream inputStream = new FileInputStream(new File (path.toString()));
	         
	        Workbook workbook = new HSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	        StringBuilder header = new StringBuilder();
	            Row nextRow = iterator.next();
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	             
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                 
	                switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                    	header.append(cell.getStringCellValue());
	                        break;
	                    case Cell.CELL_TYPE_BOOLEAN:
	                    	header.append(cell.getStringCellValue());
	                        break;
	                    case Cell.CELL_TYPE_NUMERIC:
	                    	header.append(cell.getStringCellValue());
	                        break;
	                }
	            }
	        
	         
	        workbook.close();
	        inputStream.close();
	        return header.toString();
	    }

	
	public String getExcelHeaders2007(String fileName) throws IOException{
		Path path = Paths.get(fileDirectory + fileName);
		  FileInputStream inputStream = new FileInputStream(new File (path.toString()));
	         
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	        StringBuilder sb = new StringBuilder();
	         
	            Row nextRow = iterator.next();
	             nextRow = iterator.next();
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	             
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                 
	                switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                    	
	                        sb.append(cell.getStringCellValue());
	                        break;
	                    case Cell.CELL_TYPE_BOOLEAN:
	                        sb.append(cell.getBooleanCellValue());
	                        break;
	                    case Cell.CELL_TYPE_NUMERIC:
	                        sb.append(cell.getNumericCellValue());
	                        break;
	                }
	            }
	        	         
	        workbook.close();
	        inputStream.close();
	        
	        return sb.toString();
	    }
	
	public String identifyFileBasedOnHeaders(String headersLine){
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
	public String getFileDate(String fileName) {
		Path path = Paths.get(fileDirectory + fileName);
		try {
			BasicFileAttributes fileAttr = Files.readAttributes(path, BasicFileAttributes.class);
			return fileAttr.creationTime().toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Invalid File";
	}
}