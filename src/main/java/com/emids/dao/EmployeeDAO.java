package com.emids.dao;


import java.util.List;

import com.emids.model.Address;
import com.emids.model.Employee;
 
public interface EmployeeDAO {
 
    public void addEmployee(Employee employee);
 
    public List<Employee> getAllEmployees();
   
    public void deleteEmployee(Integer employeeId);
 
    public Employee updateEmployee(Employee employee);
   
    public Employee getEmployee(int employeeid);
    
    public List<Address> getAllAddress();
    
    
    public void addAddress(Address address);
    
    public Address getAddress(int employeeid);
}
