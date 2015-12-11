package org.mypathus.tsgforce.processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.mypathus.tsgforce.resources.FileContainer;

public class TextFile {
	
	private String fileDirectory = FileContainer.getFileDirectory();
	
	public static void main(String[] args) {
		TextFile tf = new TextFile();
		System.out.println(tf.getTextFileHeaders("SampleFileText1.txt", 5));
	}
	
	public String getTextFileHeaders(String fileName, Integer row) {
		Path path = Paths.get(fileDirectory + fileName);
		String headersLine = "";
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			for(int i = 1; i<row; i++) {
				reader.readLine();
			}
			headersLine = reader.readLine();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return headersLine;
	}
	
	//method to iterate lines
	//method to process each line
	
	
	
	
	//TODO process delimited files (pass delimiter as params)
}
