package com.emids.view;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
import org.apache.poi.ss.usermodel.Workbook;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import com.emids.model.Employee;

public class XlsxViewReport extends AbstractXlsxView {

	 protected void buildExcelDocument(Map<String, Object> model,
	                                      Workbook workbook,
	                                      HttpServletRequest request,
	                                      HttpServletResponse response) throws Exception {

	        // set the file name
	        response.setHeader("Content-Disposition", "attachment; filename=\"employee.xlsx\"");

	        @SuppressWarnings("unchecked")
	        List<Employee> empList =  (List<Employee>) model.get("employeeList");

	        // create sheet
	        Sheet sheet = workbook.createSheet("Employee Xlsx");

	        // create header
	        Row header = sheet.createRow(0);
	        header.createCell(0).setCellValue("Name");
	        header.createCell(1).setCellValue("Email");
	        header.createCell(2).setCellValue("Address");
	        header.createCell(2).setCellValue("Telephone");


	        // Create cells
	        int rowCount = 1;
	        for (Employee fruit : empList){
	            Row fruitRow = sheet.createRow(rowCount++);
	            fruitRow.createCell(0).setCellValue(fruit.getName());
	            fruitRow.createCell(1).setCellValue(fruit.getEmail());
	            fruitRow.createCell(2).setCellValue(fruit.getAddress());
	            fruitRow.createCell(2).setCellValue(fruit.getTelephone());
	        }

	    }
}
