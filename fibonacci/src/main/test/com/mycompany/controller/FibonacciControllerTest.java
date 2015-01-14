package com.mycompany.controller;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mycompany.model.Fibonacci;
import com.mycompany.service.FibonacciService;

public class FibonacciControllerTest {

	private FibonacciController fibonacciController;
	
	@Test
	public void calculateFromPositiveNumber() {
		final Fibonacci fibonacciExpected = new Fibonacci(5);
		final FibonacciService serviceMock = createNiceMock(FibonacciService.class);
		expect(serviceMock.calculate(5)).andReturn(fibonacciExpected);
		replay(serviceMock); 
		
		fibonacciController = new FibonacciController(serviceMock);

		final Fibonacci fibonacciActual = fibonacciController.calculate(5);
		assertEquals(fibonacciExpected, fibonacciActual);
		
		verify(serviceMock);
	}

	@Test(expected = IllegalArgumentException.class)
	public void calculateFromNegativeNumber() {
		final FibonacciService serviceMock = createNiceMock(FibonacciService.class);
		expect(serviceMock.calculate(-1)).andThrow(new IllegalArgumentException("The number -1 is NOT positive; it has to be integer greater than 0"));
		replay(serviceMock); 
		
		fibonacciController = new FibonacciController(serviceMock);
		fibonacciController.calculate(-1);
		
		verify(serviceMock);
	}

	@Test(expected = IllegalArgumentException.class)
	public void calculateFromZeroNumber() {
		final FibonacciService serviceMock = createNiceMock(FibonacciService.class);
		expect(serviceMock.calculate(0)).andThrow(new IllegalArgumentException("The number 0 is NOT positive; it has to be integer greater than 0"));
		replay(serviceMock); 
		
		fibonacciController = new FibonacciController(serviceMock);
		fibonacciController.calculate(0);
		
		verify(serviceMock);
	}
}