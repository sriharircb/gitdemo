package drivers;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import methods.AppDependentMethods;
import methods.AppIndependentMethods;
import methods.Datatable;
import testScripts.TestScripts;


public class Driver_Script 
{
	public static AppIndependentMethods AppInd ;
	public static AppDependentMethods AppDep ;
	public static TestScripts test ;
	public static Datatable data ;
	public static WebDriver odriver ;
	
	public static void main(String[] args) throws Exception 
	{
		try
		{
			AppInd = new AppIndependentMethods();
			AppDep = new AppDependentMethods();
			test = new TestScripts();
			data = new Datatable();
		
		int rowcount=data.getrowcount("E:\\new eclipse\\Scripting_3\\Controller\\ExecutionController.xlsx", "RunTest");
		
		for(int r=0; r<rowcount; r++)
		{
		String info=data.getCellValue("E:\\new eclipse\\Scripting_3\\Controller\\ExecutionController.xlsx", "RunTest", "ExecuteTest" , r+1);
		if(info.equalsIgnoreCase("yes"))
		{
			String strclsname=data.getCellValue("E:\\new eclipse\\Scripting_3\\Controller\\ExecutionController.xlsx", "RunTest" , "ClassName",r+1 );
			String strmethname=data.getCellValue("E:\\new eclipse\\Scripting_3\\Controller\\ExecutionController.xlsx", "RunTest" , "MethodNames",r+1 );
			
			Class cls=Class.forName(strclsname);
			Object obj=cls.newInstance();
			
			Method meth=obj.getClass().getMethod(strmethname);
			meth.invoke(obj);
			
		}
		}
		}catch(Exception e)
		{
			AppInd.WriteResult("exception", "exception in method");
		}
	
	}

}
