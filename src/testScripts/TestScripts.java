package testScripts;

import org.openqa.selenium.WebDriver;

import drivers.Driver_Script;

public class TestScripts extends Driver_Script 
{
	
	public void Login_Logout()
	{
		try
		{
			AppInd.launchBrowser("chrome");
			AppDep.navigateUrl();
			AppDep.login();
			AppDep.logout();
			AppDep.closeBrowser();
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}


public void Create_DeleteUser()
{
	try
	{
		AppInd.launchBrowser("chrome");
		AppDep.navigateUrl();
		AppDep.login();
		AppDep.createUser();
		AppDep.deleteUser();
		AppDep.logout();
		AppDep.closeBrowser();
		
		
	}catch(Exception e)
	{
		System.out.println(e);
	}
}
}
