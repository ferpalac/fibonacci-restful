package com.mycompany.service;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mycompany.model.Fibonacci;

public class FibonacciServiceImplTest {

	private FibonacciService fibonacciService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void calculateFromPositiveNumber() {
		fibonacciService = new FibonacciServiceImpl();
		Fibonacci fibonacci = fibonacciService.calculate(5);
		
		assertEquals(Integer.valueOf(5), Integer.valueOf(fibonacci.getInput()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void calculateFromNegativeNumber() {
		fibonacciService = new FibonacciServiceImpl();
		fibonacciService.calculate(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void calculateFromZeroNumber() {
		fibonacciService = new FibonacciServiceImpl();
		fibonacciService.calculate(0);
	}

	@Test
	public void calculateFromNegativeNumberAndVerifiesMessage() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The number -5 is NOT positive; it has to be integer greater than 0");
		
		fibonacciService = new FibonacciServiceImpl();
		fibonacciService.calculate(-5);
	}
}