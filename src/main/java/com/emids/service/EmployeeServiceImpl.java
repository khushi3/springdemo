package com.emids.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.emids.dao.EmployeeDAO;
import com.emids.model.Address;
import com.emids.model.Employee;
 
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
 
    @Autowired
    private EmployeeDAO employeeDAO;
 
    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }
 
    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
 
    @Override
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }
 
    public Employee getEmployee(int empid) {
        return employeeDAO.getEmployee(empid);
    }
 
    public Employee updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeDAO.updateEmployee(employee);
    }
 
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    /*Address Dao*/
    
    @Override
    @Transactional
    public List<Address> getAllAddress() {
        return employeeDAO.getAllAddress();
    }
    @Override
    @Transactional
    public void addAddress(Address address) {
        employeeDAO.addAddress(address);
    }
    public Address getAddress(int empid) {
        return employeeDAO.getAddress(empid);
    }
}