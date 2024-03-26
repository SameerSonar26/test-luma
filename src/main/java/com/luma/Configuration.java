package com.luma;

import com.luma.Util.Uitil;

public class Configuration {

	public String readConfigFile(String property) {
		Uitil ut = new Uitil();
		String path = System.getProperty("user.dir");
		
		String BasePath = path + "/src/test/resources/Configuration.properties";
		
		return ut.getFilePathAndKey(BasePath, property);
	}

	public String getBrowserName() {
		return readConfigFile("browserName");
	}

	public String getAppUrl() {
		return readConfigFile("appUrlLuma");
	}
}
