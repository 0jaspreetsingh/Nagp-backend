package com.nagarro.nagpmanagement.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nagarro.nagpmanagement.constants.NAGPconstants;
import com.nagarro.nagpmanagement.io.ApplicantMonthlyReport;

public class GenerateExcelFile {

	public static void generateExcelfile(List<ApplicantMonthlyReport> reports) throws IOException {

		String columns[] = { "Employee ID", "Name", "Email", "Points Earned", "Total Points",
				"No of NAGP activities in Progress" };
		Workbook workbook = new XSSFWorkbook();
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Applicant");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (ApplicantMonthlyReport employee : reports) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(employee.getEmployee_id());
			row.createCell(1).setCellValue(employee.getApplicantName());
			row.createCell(2).setCellValue(employee.getEmail());
			row.createCell(3).setCellValue(employee.getPointsEarned());
			row.createCell(4).setCellValue(employee.getTotalPoints());
			row.createCell(5).setCellValue(employee.getTotalActivitiesInProgress());

		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(
				NAGPconstants.EXCEL_FILES_PATH + reports.get(0).getBatchName() + ".xlsx");
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();

		// return excelFiles;
	}
}
