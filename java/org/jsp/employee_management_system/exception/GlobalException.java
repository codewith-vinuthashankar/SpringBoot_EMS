package org.jsp.employee_management_system.exception;

import org.jsp.employee_management_system.response_structure.ResponseStrucutre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(NameValidationException.class)
	public ResponseEntity<ResponseStrucutre<String>> nameValidationException(NameValidationException n){
		ResponseStrucutre<String> rs = new ResponseStrucutre<String>();
		
		rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
		rs.setMessage("message : "+n.getMessage());
		rs.setData(null);
		
		return new ResponseEntity<ResponseStrucutre<String>>(rs, HttpStatus.BAD_REQUEST);
		
	}

}
