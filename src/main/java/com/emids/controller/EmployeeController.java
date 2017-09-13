package com.emids.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.logging.Logger;
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
 
@Controller 
public class EmployeeController {
 
    private static final Logger logger = Logger
            .getLogger(EmployeeController.class);
    
 
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
  		int employeeId = Integer.parseInt(request.getParameter("id"));
  		List<Address> listOfaddress = employeeService.getAddress(employeeId);
  		ModelAndView model = new ModelAndView("AddressList");
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
 
    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("EmployeeForm");
        model.addObject("employee", employee);
 
        return model;
    }
 
}