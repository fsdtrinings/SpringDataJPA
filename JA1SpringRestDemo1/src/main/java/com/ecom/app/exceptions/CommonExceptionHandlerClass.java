package com.ecom.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandlerClass {
	
	@ExceptionHandler
	public ResponseEntity<ErrorTemplate> handlerForBalanceException(InsufficientBalanceException exp)
	{
		ErrorTemplate template = new ErrorTemplate();
		
		template.setErrorMsg(exp.toString());
		template.setActionType("Account Balance Creation/ Updation");
		
		return new ResponseEntity<ErrorTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public void handlerForNullPointerException(NullPointerException exp)
	{
		// this code executes whenever Null Pointer Exce raised
	}
	
	@ExceptionHandler
	public void handlerForPanNumber(InvalidPanNumberException exp)
	{
		// this code executes whenever Null Pointer Exce raised
	}
	
	@ExceptionHandler
	public void handlerForIFSCCodeException(InvalidIFSCCodeException exp)
	{
		// this code executes whenever Null Pointer Exce raised
	}
	
	

}
