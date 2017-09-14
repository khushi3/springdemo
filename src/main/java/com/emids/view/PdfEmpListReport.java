package com.emids.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.emids.model.Employee;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PdfEmpListReport extends AbstractPdfView {

@Override
protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
HttpServletResponse response) throws Exception {
	
	response.setContentType("application/pdf");
	response.setHeader("Content-disposition",
	"attachment; filename=\"" +"employee_List.pdf" +"\"");
	@SuppressWarnings("unchecked")
List<Employee> empList =  (List<Employee>) model.get("employeeList");
Table table = new Table(7); 
table.addCell("Employee Name");
table.addCell("Email");
table.addCell("Address");
table.addCell("Telephone");

for(Employee employee: empList){
table.addCell(String.valueOf(employee.getName()));
table.addCell(String.valueOf(employee.getEmail()));
table.addCell(String.valueOf(employee.getAddress()));
table.addCell(String.valueOf(employee.getTelephone()));

}
document.add(table);
}

}