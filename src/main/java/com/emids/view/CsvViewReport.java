package com.emids.view;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.emids.model.Employee;
import com.emids.service.EmployeeService;

import java.util.List;

@Controller
public class CsvViewReport  {
	 @Autowired
	    private EmployeeService employeeService;
	 
	 @RequestMapping(value = "/downloadCsv")
	    public void downloadCSV(HttpServletResponse response) throws IOException {
	 
	        String csvFileName = "employee.csv";
	        response.setContentType("text/csv");
	 
	        // set header
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",
	                csvFileName);
	        response.setHeader(headerKey, headerValue);
	 
	        List<Employee> listOfEmployee = employeeService.getAllEmployees();
			//List<Employee> listEmployee = (List<Employee>) model.get("csvData");
	 
	        // uses the Super CSV API to generate CSV data from the model data
	        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
	                CsvPreference.STANDARD_PREFERENCE);
	 
	        String[] header = { "Name", "Email", "Address", "Telephone"
	                 };
	 
	        csvWriter.writeHeader(header);
	 
	        for (Employee aBook : listOfEmployee) {
	            csvWriter.write(aBook, header);
	        }
	 
	        csvWriter.close();
	    }
	   
	    /**
	     * The concrete view must implement this method.
	     */
	   /* protected void buildCsvDocument(ICsvBeanWriter csvWriter,
	            Map<String, Object> model) throws IOException {
	    	System.out.println("calling csv method2");
	 
	    	@SuppressWarnings("unchecked")
			List<Employee> listEmployee = (List<Employee>) model.get("csvData");
	        String[] header = (String[]) model.get("csvHeader");
	 
	        csvWriter.writeHeader(header);
	 
	        for (Employee aBook : listEmployee) {
	            csvWriter.write(aBook, header);
	        }
	    }
}*/
}

