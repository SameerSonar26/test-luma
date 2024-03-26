package com.luma.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Uitil {

	public Uitil() {

	}

	public String getFilePathAndKey(String text1, String text2) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(text1);
		} catch (FileNotFoundException e) {
			System.out.println("Check the file location.");
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = prop.getProperty(text2);
		return value;
	}
}
