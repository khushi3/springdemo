package com.emids.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emids.model.Address;
import com.emids.model.Employee;
 
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
 
	Employee employee;
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
    /*    get address from address table
     * 
    */   
        @SuppressWarnings("unchecked")
        public List<Address> getAllAddress() {
     
            Query query = sessionFactory.getCurrentSession().createQuery("from Address");
    				List<Address> list =  query.list();
    				System.out.println(list);
                    return list;
        }
        
        public Address getAddress(int empid) {
            return (Address) sessionFactory.getCurrentSession().get(
                    Address.class, empid);
        }
        
        public void addAddress(Address address) {
            sessionFactory.getCurrentSession().saveOrUpdate(address);
     
        }
        @SuppressWarnings({ "rawtypes", "unused" })
		public boolean deleteEmployeeByNumber(ArrayList<Integer> id){
    		
    		Query query = sessionFactory.getCurrentSession().getNamedQuery("employee.deleteEmployeeByNumber");
    		
    		if( id != null ){
    			query.setParameterList("id", id);
    			
    			int cont = query.executeUpdate();
    			
    			return true;
    		}
    		else{
    			return false;
    		}
    	}

     
}
