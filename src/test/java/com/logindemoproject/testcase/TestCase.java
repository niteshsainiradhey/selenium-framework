package com.logindemoproject.testcase;

import org.testng.annotations.Test;

import com.logindemoproject.pageobject.Login;
import com.logindemoproject.pageobject.Logout;

public class TestCase extends BaseClass
{
	@Test(priority = 0)
	void login()
	{
		driver.get(url);
		Login login=new Login(driver);
		login.getUsername("student");
		login.getPassword("Password123");
		login.getClick();
		
	}
	@Test(priority = 1)
	void logout()
	{
		Logout logout=new Logout(driver);
		logout.getLogout();
	}
}
