package com.Data_Driven_Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Data {

	public static void write_data() throws IOException {

		File f = new File("C:\\Users\\jegan\\eclipse-workspace\\Data_Driven_Framework\\demo.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet createSheet = wb.createSheet("Credentials1");
		Row createRow = createSheet.createRow(0);
		Cell createCell = createRow.createCell(0);
		createCell.setCellValue("Username");

		wb.getSheet("Credentials1").getRow(0).createCell(1).setCellValue("Password");
		wb.getSheet("Credentials1").createRow(1).createCell(0).setCellValue("809829");
		wb.getSheet("Credentials1").getRow(1).createCell(1).setCellValue(1323);

		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();

		System.out.println("Created Successfully");

	}

	public static void main(String[] args) throws IOException {
		write_data();
	}

}
