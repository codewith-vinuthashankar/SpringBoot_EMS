package org.jsp.employee_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.employee_management_system.entity.Employee;
import org.jsp.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	
	
	@Autowired
	EmployeeRepository er;
//	this is method is responsible to save the data
	
	public Employee saveEmployeeDao(Employee emp) {
	 return er.save(emp);
		
	}
	
//	this method is responsible to fetch the data
	
	public Employee getemployeeByIdDao(int id) {
		Optional<Employee> emp=er.findById(id);
		
		if(emp.isPresent()) {
			return emp.get();
		}
		else {
			return null;
		}
	}
	
	
//	design a method a fetch all the record
	
	public List<Employee> getAllEmployeeDetailsDao(){
		return er.findAll();
	}
	
	
	public String deleteEmployeeByIdDao(int id) {
		Optional<Employee> emp=er.findById(id);
		if(emp.isPresent()) {
			Employee e=emp.get();
			er.delete(e);
			return "Employee data is deleted";
		}
		else {
			return "id is not found";
		}
	}
	
//	design a method to update the record 
	public Employee updateEmployeeRecord(Employee emp) {
	 return  er.save(emp);
	}
	

	}
	

	


