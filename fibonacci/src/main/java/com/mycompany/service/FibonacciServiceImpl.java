package com.mycompany.service;

import org.springframework.stereotype.Component;

import com.mycompany.model.Fibonacci;

@Component
public class FibonacciServiceImpl implements FibonacciService {
	private static final String NON_POSITIVE_ERROR_MESSAGE = "The number %d is NOT positive; it has to be integer greater than 0";

	public Fibonacci calculate(final int number) {
		if (number < 1) {
			throw new IllegalArgumentException(String.format(NON_POSITIVE_ERROR_MESSAGE, number));
		}

		final Fibonacci fibonacci = new Fibonacci(number);
		fibonacci.getFib();

		return fibonacci;
	}
}