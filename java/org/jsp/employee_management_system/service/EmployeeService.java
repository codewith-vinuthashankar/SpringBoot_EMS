package org.jsp.employee_management_system.service;

import java.util.List;

import org.jsp.employee_management_system.dao.EmployeeDao;
import org.jsp.employee_management_system.entity.Employee;
import org.jsp.employee_management_system.exception.NameValidationException;
import org.jsp.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	 private EmployeeDao dao;
	
	@Autowired
	private EmployeeRepository er;
	
	public Employee saveEmployeeService(Employee emp) {
		
		if(emp.getName()==null) {
			throw new NameValidationException("Null Data is not allowed");
		}
		return dao.saveEmployeeDao(emp);
	}
	
	
	public Employee getEmployeeByIDDao(int id) {
		return dao.getemployeeByIdDao(id);
	}


	//method to fetch employee by id
		public Employee getEmployeeService(int id) {
			return dao.getemployeeByIdDao(id);
		}
//		method to search all employee based on salary in asc
		public List<Employee> getAllEmployeeBasedOnSalaryAscService(){
			return er.findAllByOrderBySalaryAsc();
		}
		
//		this is responsible to return all employee detail to controller layer
		public List<Employee> getAllEmployeeDetailsDao(){
		return dao.getAllEmployeeDetailsDao();
	}
		
//		this is responsible the delete the record
		public String deleteEmployeeByIDService(int id) {
			return dao.deleteEmployeeByIdDao(id);
		}
		
//		this is responsible to update the record
		
		public Employee updateEmployeeService(Employee emp){
			return dao.updateEmployeeRecord(emp);
		}
	
//		this is responsible to filter name 
		public List<Employee> filterEmployeeBasedOnName(String name){
			return er.findByNameContainingIgnoreCase(name);
		}

}
