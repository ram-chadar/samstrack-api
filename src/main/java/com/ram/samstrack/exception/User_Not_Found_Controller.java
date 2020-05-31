package com.ram.samstrack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class User_Not_Found_Controller {
	@ExceptionHandler(value = User_Not_Found_Exception.class)
	public ResponseEntity<Object> exception(User_Not_Found_Exception exception) {
		return new ResponseEntity<>("User Not Found ", HttpStatus.NOT_FOUND);
	}
}
