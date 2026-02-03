package org.jsp.employee_management_system.controller;

import java.util.List;


import org.jsp.employee_management_system.entity.Employee;
import org.jsp.employee_management_system.response_structure.ResponseStrucutre;
import org.jsp.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {

//    private final EmployeeManagementSystemApplication employeeManagementSystemApplication;
	

	
	@Autowired
	private EmployeeService es;

//    EmployeeController(EmployeeManagementSystemApplication employeeManagementSystemApplication) {
//        this.employeeManagementSystemApplication = employeeManagementSystemApplication;
//    }
//	
//design a method to save employee data
	@Operation(summary="this is post method", description = "this is a method for postman api to post the data")
	@ApiResponses({
		@ApiResponse(responseCode = "201" ,description="data is stored succesfully"),
		@ApiResponse(responseCode = "404" ,description="data is not stored succesfully"),
		
	})
	@PostMapping("/qspider/employee")
	public ResponseEntity<ResponseStrucutre <Employee>>  saveEmployee(@RequestBody Employee emp) {
		
		ResponseStrucutre<Employee> rss = new ResponseStrucutre<Employee>();
		rss.setStatuscode(HttpStatus.CREATED.value());
		rss.setMessage("Employee is succesfully Saved");
		Employee e=es.saveEmployeeService(emp);
		rss.setData(e);
		return new ResponseEntity<ResponseStrucutre <Employee>> (rss,HttpStatus.CREATED);
		
	}
//	method return employee based on id
	@GetMapping("/qspiders/employee/datareading/{id}")
	public Employee readEmployeeData(@PathVariable int id) {
		return es.getEmployeeByIDDao(id);
	}
	
	@GetMapping("/qspiders/employee/data/{id}")
	public ResponseEntity<ResponseStrucutre <Employee>>  getEmployeeByIdController(@PathVariable int id) {
		
		Employee emp=es.getEmployeeService(id);
		if(emp!=null) {
			ResponseStrucutre<Employee> rs=new ResponseStrucutre<Employee>();
			rs.setStatuscode(HttpStatus.OK.value());
			rs.setMessage("succesfully data is fetch");
			rs.setData(emp);
			return new ResponseEntity<ResponseStrucutre<Employee>>(rs,HttpStatus.OK);
		}
		else {
			
			ResponseStrucutre<Employee> rs=new ResponseStrucutre<Employee>();
			rs.setStatuscode(HttpStatus.NOT_FOUND.value());
			rs.setMessage("given emopid is not found");
			rs.setData(emp);
			
			return new ResponseEntity<ResponseStrucutre<Employee>> (rs,HttpStatus.NOT_FOUND);
			
		}
		
	}
//	design endpoint to search employee based on salary(ascending order)
	@GetMapping("/qspiders/employee/salaryasc")
	public List<Employee> getAllEmployeeBySalary(){
		return es.getAllEmployeeBasedOnSalaryAscService();
	}
	
//	design a endpoint to find all the record 
	@GetMapping("/qspiders/employee/alldetails")
	public List<Employee> getAllEmployeeDetailsController(){
		return es.getAllEmployeeDetailsDao();
	}
	
//	design a endpoint to delete a record based on id
	@DeleteMapping("/qspiders/employee/{id}")
	public String deleteEmployeeByIDController(@PathVariable int id) {
	return	es.deleteEmployeeByIDService(id);
	}
	
	@PutMapping("/qspiders/employee")
	public Employee updateEmployeeController(@RequestBody Employee emp) {
		return es.updateEmployeeService(emp);
	}
	
	@GetMapping("/qspiders/employee/name/{name}")
	public List<Employee> findByNameController(@PathVariable String name){
		return es.filterEmployeeBasedOnName(name);
	}


}
