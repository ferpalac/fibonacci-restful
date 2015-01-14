package com.mycompany.model;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class FibonacciTest {
	private Fibonacci fibonacci;

	@Test
	public void getFibFromPositiveNumbers() {
		fibonacci = new Fibonacci(5);
		assertArrayEquals(new int[] {0, 1, 1, 2, 3},  fibonacci.getFib());
		
		fibonacci = new Fibonacci(10);
		assertArrayEquals(new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34 },  fibonacci.getFib());
	}

	@Test
	public void getFibFromCornerNumbers() {
		fibonacci = new Fibonacci(1);
		assertArrayEquals(new int[] {0},  fibonacci.getFib());
		
		fibonacci = new Fibonacci(2);
		assertArrayEquals(new int[] {0, 1 },  fibonacci.getFib());
	}

	@Test
	public void getFibFromNegativeNumbers() {
		fibonacci = new Fibonacci(-1);
		assertArrayEquals(new int[] { },  fibonacci.getFib());
		
		fibonacci = new Fibonacci(-5);
		assertArrayEquals(new int[] { },  fibonacci.getFib());
	}

	@Test
	public void getFibFromZeroNumber() {
		fibonacci = new Fibonacci(0);
		assertArrayEquals(new int[] { },  fibonacci.getFib());
	}
}
