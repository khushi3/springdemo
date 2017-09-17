package com.emids.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.emids.model.Address;
import com.emids.model.Employee;
 
public interface EmployeeService {
     
    public void addEmployee(Employee employee);
 
    public List<Employee> getAllEmployees();
 
    public void deleteEmployee(Integer employeeId);
 
    public Employee getEmployee(int employeeid);
 
    public Employee updateEmployee(Employee employee);
    
    public boolean deleteEmployeeByNumber(ArrayList<BigDecimal> id);

	public List<Address> getAllAddress();
	
	public void addAddress(Address Address);
	
	 public Address getAddress(int employeeid);
 
}