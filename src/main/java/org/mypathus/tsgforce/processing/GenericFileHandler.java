package org.mypathus.tsgforce.processing;

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
import org.mypathus.tsgforce.resources.FileContainer;

public class GenericFileHandler {

	private static String fileDirectory = FileContainer.getFileDirectory();

	public static void main(String[] args) {
		System.out.println(GenericFileHandler.getFileType("SampleFileExcel.xls"));
		System.out.println(GenericFileHandler.getFileType("SampleFileExcel.xlsx"));
	}
	
	public static String getFileType(String fileName) {
		Tika tika = new Tika();
		Path path = Paths.get(fileDirectory + fileName);
		String fileType = "";
		try {
			fileType = tika.detect(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileType;
	}

	public static String getFileMD5(String fileName) {
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

	public static String getFileCreationDate(String fileName) {
		Path path = Paths.get(fileDirectory + fileName);
		try {
			BasicFileAttributes fileAttr = Files.readAttributes(path, BasicFileAttributes.class);
			return fileAttr.creationTime().toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getTimeStampInFile(String fileName) {
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
	
	

}