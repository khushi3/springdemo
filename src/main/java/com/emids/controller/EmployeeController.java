package com.emids.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
//import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.emids.model.Address;
import com.emids.model.Employee;
import com.emids.service.EmployeeService;
import com.emids.view.XlsxViewReport;
import com.emids.view.PdfViewReport;

 
@Controller 
public class EmployeeController {
 
  /*  private static final Logger logger = Logger
            .getLogger(EmployeeController.class);
    */
 
    public EmployeeController() {
        System.out.println("EmployeeController()");
    }
 
    @Autowired
    private EmployeeService employeeService;
    
    ObjectMapper mapper = new ObjectMapper();
    Employee employee;
  

    @RequestMapping(value = "/")
    public ModelAndView displayLogin(ModelAndView model) throws IOException {
        model.setViewName("login");
        return model;
    }

  //Get Address
  	@RequestMapping(value = "/employeeAddress", method = RequestMethod.GET)
  	public ModelAndView showAddress(HttpServletRequest request) {
  		List<Address> listOfaddress = employeeService.getAllAddress();
  		ModelAndView model = new ModelAndView("address");
  		model.addObject("listOfaddress", listOfaddress);
  		return model;
  	}
  	
  //Add address
  	@RequestMapping(value = "/addemployeeAddress", method = RequestMethod.GET)
  	public ModelAndView addAddress(ModelAndView model) {
  		Address address = new Address();
  		model.addObject("address", address);
  		model.setViewName("addressForm");
  		return model;
  	}
  	//save Address
  	 @RequestMapping(value = "/saveEmployeeAddress", method = RequestMethod.POST)
     public ModelAndView saveAddress(@ModelAttribute Address address) {
             employeeService.addAddress(address);
         return new ModelAndView("redirect:/employeeAddress");
     }
  	 
  	//save Address
  	 @RequestMapping(value = "/backToEmployee", method = RequestMethod.GET)
     public ModelAndView backToEmployeePage(@ModelAttribute Address address) {
             employeeService.addAddress(address);
         return new ModelAndView("redirect:/employeeList");
     }
  	 
    @RequestMapping(value = "/employeeList")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<Employee> listOfEmployee = employeeService.getAllEmployees();
        model.addObject("listOfEmployee", listOfEmployee);
        System.out.println("list"+listOfEmployee);
        System.out.println(model);
        model.setViewName("home");
        return model;
    }
    @ResponseBody
    @RequestMapping(value = "/employeeJsonData")
    public String listEmployeeJson(ModelAndView model) throws JsonGenerationException, JsonMappingException, IOException  {
    	 List<Employee> listOfEmployee = employeeService.getAllEmployees();
         model.addObject("listOfEmployee", listOfEmployee);
     	String jsonInString = mapper.writeValueAsString(listOfEmployee);

    	try {
    	String jsonInString1 = mapper.writeValueAsString(listOfEmployee);
    	System.out.println(jsonInString1);

    	//Convert object to JSON string and pretty print
    	jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmployee);
    	System.out.println(jsonInString);
    	} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonInString;
    }
 
    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newEmployee(ModelAndView model) {
        Employee employee = new Employee();
        model.addObject("employee", employee);
        model.setViewName("EmployeeForm");
        return model;
    }
 
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        if (employee.getId() == 0) {
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return new ModelAndView("redirect:/employeeList");
    }
 
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(employeeId);
        return new ModelAndView("redirect:/employeeList");
    }
    
    @RequestMapping(value="/deleteClient", method=RequestMethod.POST)
	@ResponseBody
	public boolean deleteClient( HttpServletRequest req, HttpServletResponse resp ) throws ParseException{
		
		String checked = req.getParameter("checked") == null ? "": req.getParameter("checked");
		
		ArrayList<BigDecimal> decArray = new ArrayList<BigDecimal>();
		
		for( String s : checked.split(",") ){
			decArray.add( new BigDecimal(s) );
		}
		
		boolean bok = employeeService.deleteEmployeeByNumber(decArray);
		
		return bok;
	}
	
 
    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("EmployeeForm");
        model.addObject("employee", employee);
 
        return model;
    }
  /*  generate pdf*/
    @RequestMapping(value= "/downloadPDF", method = RequestMethod.GET)
    public ModelAndView getDocuments(ModelAndView model) {
    	 List<Employee> listOfEmployee = employeeService.getAllEmployees();
    	 return new ModelAndView(new PdfViewReport(), "employeeList", listOfEmployee);
       // model.addAttribute("listOfEmployee", listOfEmployee);
       // return "EmployeePdf";

    }
    
    /*  generate xlsx*/
    @RequestMapping(value= "/downloadXlsx", method = RequestMethod.GET)
    public ModelAndView getDocumentsXlsx(ModelAndView model) {
    	 List<Employee> listOfEmployee = employeeService.getAllEmployees();
    	 return new ModelAndView(new XlsxViewReport(), "employeeList", listOfEmployee);
       // model.addAttribute("listOfEmployee", listOfEmployee);
       // return "EmployeePdf";

    }
    
    /*  generate csv*/
  /*  @RequestMapping(value= "/downloadCsv", method = RequestMethod.GET)
    public ModelAndView getCsv(ModelAndView model) throws IOException {
    	String[] header = { "EmpName", "Email", "Address", "Telephone"};
    	 List<Employee> listOfEmployee = employeeService.getAllEmployees();
    	 ModelAndView model = new ModelAndView("ViewCSV");
    	  //  model.addObject("csvData", listOfEmployee);
    	    model.addObject("csvHeader", header);
    	 
    	    return model;
    	// return new ModelAndView(new CsvViewReport(), "employeeList", listOfEmployee);
       // model.addAttribute("listOfEmployee", listOfEmployee);
       // return "EmployeePdf";

    }*/
    
    //@RequestMapping(value = "/generatepdf", method = RequestMethod.GET)
  // public ModelAndView generatePdf(HttpServletRequest request,
    //  HttpServletResponse response,Model model) throws Exception {
    // System.out.println("Calling generatePdf()...");
   // List<Employee> listOfEmployee = employeeService.getAllEmployees();
    /* Employee employee = new Employee();
     employee.setName("Yashwant");
     employee.setEmail("Chavan@gmail.com");*/
     
    // model.addAttribute("listOfEmployee", listOfEmployee);
    // ModelAndView modelAndView = new ModelAndView("EmployeePdf", "command",listOfEmployee);
    // return modelAndView;
   // }
 
    
 
}