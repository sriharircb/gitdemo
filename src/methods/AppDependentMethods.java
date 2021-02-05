package methods;

import org.openqa.selenium.By;

import drivers.Driver_Script;


public class AppDependentMethods extends Driver_Script 
{

	public void navigateUrl()
	{

		try
		{
			odriver.get("http://localhost/login.do");
			Thread.sleep(3000);
			odriver.manage().window().maximize();
			
		}catch (Exception e)
		{
			AppInd.WriteResult("exception", "exception in navigateurl");
		}
	}


	public void login()
	{
		try
		{
			AppInd.sendValues(By.id("username"), "admin");
			AppInd.sendValues(By.name("pwd"), "manager");
			AppInd.clickobject(By.tagName("a"));
			Thread.sleep(3000);

			//Handle Shortcut window
			if(odriver.findElements(By.xpath("//div[@style='display: block;']")).size()>0)
			{
				odriver.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
			}
			

			if(AppInd.compareValue(AppInd.verifyText(By.xpath("//td[@class='pagetitle']"),"text") , "Enter Time-Track"))
			{
				AppInd.WriteResult("pass", "login is sucessfull");
			}
			else
			{
				AppInd.WriteResult("fail", "login is failed");
			}

			

		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
		}
	}


	public void createUser()
	{
		try
		{


			AppInd.clickobject(By.xpath("//div[text()='USERS']"));
			Thread.sleep(2000);
			AppInd.clickobject(By.xpath("//div[text()='Add User']"));
			Thread.sleep(2000);
			AppInd.sendValues(By.name("firstName"), "hhhh");
			AppInd.sendValues(By.name("lastName"), "ll");
			AppInd.sendValues(By.name("email"), "first.last@sg.com");
			AppInd.sendValues(By.name("username"), "firstlast");
			AppInd.sendValues(By.name("password"), "Mercury");
			AppInd.sendValues(By.name("passwordCopy"), "Mercury");
			Thread.sleep(20000);
			AppInd.clickobject(By.xpath("//span[text()='Create User']"));
			Thread.sleep(2000);

			if(AppInd.compareValue(AppInd.verifyText(By.xpath("//*[@id='userListTableContainer']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]"), "text"), "ll, hhhh"))
			{
				AppInd.WriteResult("pass", "user created sucessfully");
			}
			else
			{
				AppInd.WriteResult("fail", "user failed to create");
			}

		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
		}
	}


	public void deleteUser()
	{
		try
		{

			AppInd.clickobject(By.xpath("//div[@class='name']/span[text()="+"'ll, hhhh'"+"]"));
			Thread.sleep(2000);

			AppInd.clickobject(By.xpath("//button[contains(text(),'Delete User')]"));
			Thread.sleep(2000);
			odriver.switchTo().alert().accept();
			Thread.sleep(2000);

			if(AppInd.compareValue(AppInd.verifyText(By.xpath("//*[@id='userListTableContainer']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]"), "text"), "ll, hhhh"))
			{
				AppInd.WriteResult("pass", "user failed to delete");
			}
			else
			{
				AppInd.WriteResult("fail", "user sucessfully to deleted");
			}


		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
		}
	}

	public void logout()
	{
		try
		{
			AppInd.clickobject(By.xpath("//a[@id='logoutLink']"));
			Thread.sleep(2000);

			if(AppInd.compareValue(AppInd.verifyText(By.xpath("//td[@class='header']"), "text"), "Please identify yourself"))
			{
				AppInd.WriteResult("pass", "logged out sucessfully ");
			}
			else
			{
				AppInd.WriteResult("fail", "failed to logged out");
			}

		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
		}
	}


	public void closeBrowser()
	{
		try {
			AppInd.closeBrowser();

		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
		}
	}
	
	public void close()
	{
		
	}
}
