package com.task.assignment.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.task.assignment.exception.TradeDetailsNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> eventNotFoundException(TradeDetailsNotFoundException e){
		ErrorStructure<String> errorStructure= new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(e.getMessage());
		errorStructure.setData("Trade details you Entered it's not valid, Please enter valid input!!");
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
}
