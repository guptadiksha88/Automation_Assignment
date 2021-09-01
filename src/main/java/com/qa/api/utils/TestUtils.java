package com.qa.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class TestUtils {
	
	public Properties pro;
	
	public void	initialization() throws IOException
	{
		File src= new File("configs\\configuration.properties");
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	}
	}

