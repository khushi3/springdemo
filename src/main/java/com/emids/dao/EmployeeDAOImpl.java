package com.emids.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.emids.model.Employee;
 
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {
 
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee");
				List<Employee> list =  query.list();
				System.out.println(list);
                return list;
    }
 
    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
 
    }
 
    public Employee getEmployee(int empid) {
        return (Employee) sessionFactory.getCurrentSession().get(
                Employee.class, empid);
    }
 
    @Override
    public Employee updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return employee;
    }
 
}
