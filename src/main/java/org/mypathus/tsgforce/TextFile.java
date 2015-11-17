package org.mypathus.tsgforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFile {
	
	private String fileDirectory = FileContainer.getFileDirectory();
	
	public String getTextFileHeaders(String fileName) {
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
