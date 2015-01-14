package com.mycompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mycompany.model.Fibonacci;
import com.mycompany.service.FibonacciService;

@Controller
public class FibonacciController {
	private FibonacciService fibonacciService;
	
	@Autowired 
	public FibonacciController(FibonacciService fibonacciService) {
		this.fibonacciService = fibonacciService;
	}
	
	@RequestMapping(value = "/fib", method = RequestMethod.GET)
	public @ResponseBody Fibonacci calculate(
			@RequestParam(value = "n", required = false, defaultValue = "5") Integer number) {

		return fibonacciService.calculate(number);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({IllegalArgumentException.class})
	@ResponseBody
	public ResponseEntity<String> handleNotFound(IllegalArgumentException ex) {
	    return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}