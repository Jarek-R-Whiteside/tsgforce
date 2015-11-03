package org.mypathus.tsgforce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.tika.Tika;

public class FileHandler {
	
	private String fileDirectory = "./src/main/resources/";
	
	public static void main(String[] args) {
		FileHandler fh = new FileHandler();
		fh.getFileHeaders("SampleFileText1.txt");
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
	

	
}
