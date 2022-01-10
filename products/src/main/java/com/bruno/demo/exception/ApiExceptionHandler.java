package com.bruno.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bruno.demo.result.Result;

@RestControllerAdvice
public class ApiExceptionHandler{

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Result> handleMethodArgumentNotValid(MethodArgumentNotValidException manve) {
		String msg = new StringBuilder(manve.getBindingResult().getFieldError().getField()).append(": invalid value!").toString();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Result(HttpStatus.BAD_REQUEST.value(), msg));
	}
	
	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<Result> handleService(CustomException ce) {
		return ResponseEntity.status(ce.getHttpStatus()).body(new Result(ce.getHttpStatus().value(), ce.getMessage()));
	}


}
