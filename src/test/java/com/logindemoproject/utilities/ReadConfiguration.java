package com.logindemoproject.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ReadConfiguration 
{
	String path="C:\\Users\\DELL\\Desktop\\WorkShop\\Feb\\automation_testing_framework\\configuration\\config.properties";
	Properties pro;
	public ReadConfiguration()
	{
		FileInputStream fn=null;
		try {
			fn = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pro=new Properties();
		try {
			pro.load(fn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getUrl()
	{
		String u=pro.getProperty("url");
		if(u!=null)
		{
			return u;
		}
		else
		{
			throw new RuntimeException("url not found");
		}
	}
	public String getBrowser()
	{
		String b=pro.getProperty("browser");
		if(b!=null)
		{
			return b;
		}
		else
		{
			throw new RuntimeException("Browser not found");
		}
	}
	
}
