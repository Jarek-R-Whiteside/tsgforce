package org.mypathus.tsgforce.resources;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileContainerTest {
	
	@Test
	public void getFileDirectoryTest() {
		String actualDirectory = FileContainer.getFileDirectory();
		assertNotNull(actualDirectory);
		assertNotEquals("", actualDirectory);
	}
}
