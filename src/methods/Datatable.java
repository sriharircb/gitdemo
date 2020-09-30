package methods;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import drivers.Driver_Script;

public class Datatable extends Driver_Script 
{
	public String getCellValue(String filename, String sheetname , String value ,int rowvalue)
	{

		FileInputStream fin;
		Workbook wb;
		Row row_1;
		Cell cell_1;
		Row row_2 ;
		Cell cell_2;
		Sheet sh;
		String data = null;
		try
		{
			fin = new FileInputStream(filename);
			wb= new XSSFWorkbook(fin);

			sh=wb.getSheet(sheetname);
			int rownum=sh.getPhysicalNumberOfRows();

			
				row_1=sh.getRow(0);
				row_2=sh.getRow(rowvalue);


				int cellnum =row_1.getPhysicalNumberOfCells();

				for(int j=0; j<cellnum; j++)
				{
					cell_1=row_1.getCell(j);

					if(rowvalue>0)
					{
						cell_2=row_2.getCell(j);


						if(cell_1.getStringCellValue().equalsIgnoreCase(value))
						{
							 data=cell_2.getStringCellValue();
							
						}
					}
					else
					{
						AppInd.WriteResult("fail", "no rows selected");
						break;
					}

				}
			
				return data;

		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		
	}
	
	public int getrowcount(String strfile, String shname )
	{
		FileInputStream fin;
		Workbook wb;
		Sheet sh;
		Row row;
		try
		{
			fin = new FileInputStream(strfile);
			wb = new  XSSFWorkbook(fin);
			sh=wb.getSheet(shname);
			
		int rownum = sh.getPhysicalNumberOfRows();
		//System.out.println(rownum);
		
			return rownum-1;
		}catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}
	
	}
}
