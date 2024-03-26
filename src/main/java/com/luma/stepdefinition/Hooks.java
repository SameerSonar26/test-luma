package com.luma.stepdefinition;

import com.luma.Configuration;
import com.luma.Keyword;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	Keyword keyword = new Keyword();

	@Before
	public void launchBrowserAndAppUrl() {
		Configuration conf = new Configuration();
		keyword.openBrowser(conf.getBrowserName());
		keyword.getAppUrl(conf.getAppUrl());

	}

	@After
	public void tearDown() {
		keyword.tearDown();

	}

}
 