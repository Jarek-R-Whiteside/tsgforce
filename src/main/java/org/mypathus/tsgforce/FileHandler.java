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
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import org.apache.tika.Tika;

public class FileHandler {
	
	private String fileDirectory = "./src/main/resources/";
	
	public static void main(String[] args) {
		FileHandler fh = new FileHandler();
		
//		String realFileName = fh.getFileType("SampleFileExcel.xls");
//		System.out.println(realFileName);
//		
//		String realFileName2 = fh.getFileType("SampleFileExcel.xlsx");
//		System.out.println(realFileName2);
//		
//		String realFileName3 = fh.getFileType("SampleFileTiff.tiff");
//		System.out.println(realFileName3);
//		
//		String realFileName4 = fh.getFileType("SampleFileText1.txt");
//		System.out.println(realFileName4);
//		
		try {
			fh.getExcelHeaders2007("SampleFileExcel.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		System.out.println(headersLine);
		
		return headersLine;
	}
	
	public void getExcelHeaders2003(String fileName) throws IOException{
		Path path = Paths.get(fileDirectory + fileName);
		  FileInputStream inputStream = new FileInputStream(new File (path.toString()));
	         
	        Workbook workbook = new HSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	         
	            Row nextRow = iterator.next();
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	             
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                 
	                switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                        System.out.print(cell.getStringCellValue());
	                        break;
	                    case Cell.CELL_TYPE_BOOLEAN:
	                        System.out.print(cell.getBooleanCellValue());
	                        break;
	                    case Cell.CELL_TYPE_NUMERIC:
	                        System.out.print(cell.getNumericCellValue());
	                        break;
	                }
	                System.out.print(" - ");
	            }
	            System.out.println();
	        
	         
	        workbook.close();
	        inputStream.close();
	    }
	
	public void getExcelHeaders2007(String fileName) throws IOException{
		Path path = Paths.get(fileDirectory + fileName);
		  FileInputStream inputStream = new FileInputStream(new File (path.toString()));
	         
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	         
	            Row nextRow = iterator.next();
	             nextRow = iterator.next();
	             nextRow = iterator.next();
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	             
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                 
	                switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                        System.out.print(cell.getStringCellValue());
	                        break;
	                    case Cell.CELL_TYPE_BOOLEAN:
	                        System.out.print(cell.getBooleanCellValue());
	                        break;
	                    case Cell.CELL_TYPE_NUMERIC:
	                        System.out.print(cell.getNumericCellValue());
	                        break;
	                }
	                System.out.print(" - ");
	            }
	            System.out.println();
	        
	         
	        workbook.close();
	        inputStream.close();
	    }
}