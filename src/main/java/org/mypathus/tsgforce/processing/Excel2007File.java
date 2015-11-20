package org.mypathus.tsgforce.processing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mypathus.tsgforce.resources.FileContainer;

public class Excel2007File {

	private String fileDirectory = FileContainer.getFileDirectory();

	public static void main(String[] args) throws IOException {
		Excel2007File f = new Excel2007File();
		System.out.println(f.getExcelHeaders2007("SampleFileExcel.xlsx", 2));
	}
	
	public String getExcelHeaders2007(String fileName, Integer row) throws IOException {
		Path path = Paths.get(fileDirectory + fileName);
		FileInputStream inputStream = new FileInputStream(new File(path.toString()));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		StringBuilder sb = new StringBuilder();
		Row nextRow = null;
		
		for(int i = 0; i<row; i++) {
			nextRow = iterator.next();
		}
		
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

}
