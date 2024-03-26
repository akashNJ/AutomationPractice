package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 Apache poi - API used for automating ms documents- excel.

reading data from excel
writing data into excel

Excel File-->Workbook-->Sheets---->Rows--->Cells

FileInputStream
FileOutputStream

XSSFWorkbook
XSSFSheet
XSSFRow
XSSFCell
 */

public class ExcelReading {

	public static void main(String[] args) throws IOException {

		FileInputStream file=new FileInputStream(".//testdata//OpenCart.xlsx");

		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet1");

		int rows=sheet.getLastRowNum();
		int cells=sheet.getRow(0).getLastCellNum();
		System.out.println(rows);
		System.out.println(cells);

		for(int r=0;r<=rows;r++) {
			for(int c=0;c<cells;c++) {
				/*String data=sheet.getRow(r).getCell(c).toString();
				System.out.print(data+" ");
				 */

				String data;
				XSSFCell cell=sheet.getRow(r).getCell(c);
				try {
					DataFormatter formatter=new DataFormatter();
					data=formatter.formatCellValue(cell);
					System.out.println(data);
				}
				catch(Exception e) {
					data="";
				}

			}
			System.out.println();
		}

		workbook.close();
		file.close();
	}

}
