package com.logindemoproject.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout 
{
public WebDriver ldriver;
	
	public Logout(WebDriver rdriver)//rdriver=driver
	{
		ldriver=rdriver;
	}
	//locator
	By logout=By.xpath("//a[text()='Log out']");
	
	//actions
	
	public void getLogout()
	{
		ldriver.findElement(logout).click();
	}

}
