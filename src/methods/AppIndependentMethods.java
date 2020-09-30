package methods;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import drivers.Driver_Script;


public class AppIndependentMethods extends Driver_Script 
{
	public void clickobject(By objBY)
	{
		try
		{	
			WebElement oEle=	odriver.findElement(objBY);

			if(oEle.isDisplayed())
			{
				oEle.click();
				WriteResult("pass", "sucessfully clicked" );
			}
			else
			{
				WriteResult("fail", "failrd to click" );
			}
		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
		}
	}

	public void sendValues(By objBY , CharSequence value)
	{
		try
		{
			WebElement oEle=odriver.findElement(objBY);

			if(oEle.isDisplayed())
			{
				oEle.sendKeys(value);
				WriteResult("pass", value+"  element pased sucessfully");
			}
			else
			{
				WriteResult("fail", value+"  failed to pass the element");
			}

		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
		}
	}

	public boolean compareValue(String strActual, String strExpected)
	{
		try
		{
			if(strActual.equalsIgnoreCase(strExpected))
			{
				WriteResult("pass", strActual+"  value and  "+strExpected+"  values are matching");
				return true;
			}
			else
			{
				WriteResult("fail", strActual+"  value and  "+strExpected+"  values are not matching");
				return false;
			}

		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
			return false;
		}
	}


	public String verifyText( By objBy, String strObjType)
	{
		WebElement oEle = null;
		String strActual = null;
		Select oSel = null;
		try {
			oEle = odriver.findElement(objBy);
			if(oEle.isDisplayed())
			{
				switch(strObjType.toLowerCase())
				{
				case "text":
					strActual = oEle.getText();
					//System.out.println(strActual);
					break;
				case "value":
					strActual = oEle.getAttribute("value");
					//System.out.println(strActual);
					break;
				case "list":
					oSel = new Select(oEle);
					strActual = oSel.getFirstSelectedOption().getText();
					//System.out.println(strActual);
					break;
				}
				
			}
			return strActual;
		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
			return null;

		}
		finally {
			oEle = null;
			oSel = null;
		}
	}

	public void launchBrowser(String str)
	{	
		try
		{
			switch(str)
			{                                                                                  
			case "chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\library\\webdrivers\\chromedriver.exe");
				odriver= new ChromeDriver();
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\library\\webdrivers\\geckodriver.exe");
				odriver = new FirefoxDriver();
				break;

			case "ie":
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\library\\webdrivers\\IEDriverServer.exe");
				odriver = new InternetExplorerDriver();
				break;
			}

		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
		}
	}


	public void closeBrowser()
	{

		try
		{
			odriver.close();
		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
		}
	}
	
	public void WriteResult(String status,String message)
	{
		Logger log = null;
		try
		{
			log = Logger.getLogger("Reports");
			switch(status.toLowerCase())
			{
				case "pass":
					log.info(message);
					break;
				case "fail":
					log.error(message);
					break;
				case "exception":
					log.fatal(message);
					break;
				default:
					System.out.println("Invalid result status '"+status+"' was specified");
			}
			
		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
		}
		finally
		{
			log = null;
		}
	}

}
