package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream file;
	public static FileOutputStream file1;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String fileName, String sheetName) throws IOException {

		file=new FileInputStream(fileName);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		int count=sheet.getLastRowNum();
		workbook.close();
		file.close();
		return count;
	}

	public static int getCellCount(String fileName, String sheetName, int rowNum) throws IOException {

		file=new FileInputStream(fileName);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		int count=sheet.getRow(rowNum).getLastCellNum();
		workbook.close();
		file.close();
		return count;
	}

	public static String getData(String fileName, String sheetName, int rowNum, int cellNum) throws IOException {

		file=new FileInputStream(fileName);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		cell=sheet.getRow(rowNum).getCell(cellNum);

		String data;
		try {
			DataFormatter format=new DataFormatter();
			data = format.formatCellValue(cell);
		}
		catch(Exception e) {
			data="";
		}
		workbook.close();
		file.close();
		return data;
	}

	public static void setData(String fileName, String sheetName, int rowNum, int cellNum, String data) throws IOException {
		file=new FileInputStream(fileName);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.createCell(cellNum);
		cell.setCellValue(data);
		file1=new FileOutputStream(fileName);
		workbook.write(file1);
		workbook.close();
		file.close();
		file1.close();
	}
}
