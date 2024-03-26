package practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriting {

	public static void main(String[] args) throws IOException {

		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\write.xlsx");

		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();
		
		//passing data without for loop
		
		/*XSSFRow row1=sheet.createRow(0);
		row1.createCell(0).setCellValue("name");
		row1.createCell(1).setCellValue("surname");
		row1.createCell(2).setCellValue("city");
		
		XSSFRow row2=sheet.createRow(1);
		row2.createCell(0).setCellValue("akash");
		row2.createCell(1).setCellValue("jadhav");
		row2.createCell(2).setCellValue("pune");
		*/
		
		//passing data with for loop
		Scanner sc=new Scanner(System.in);
		for(int r=0;r<=1;r++) {
			XSSFRow row=sheet.createRow(r);
			for(int c=0;c<2;c++) {
				System.out.println("enter value:");
				String data=sc.next();
				row.createCell(c).setCellValue(data);
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		
		
		
	}

}
