package org.mypathus.tsgforce;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Excel2003File {
	private String fileDirectory = FileContainer.getFileDirectory();
	
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
}
