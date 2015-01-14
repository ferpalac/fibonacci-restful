package com.mycompany.model;

public class Fibonacci {
	private int input;

	public Fibonacci(int input) {
		this.input = input;
	}

	public int getInput() {
		return input;
	}

	public int[] getFib() {
		if (getInput() < 1) {
			return new int[] {};
		}

		final int[] fibo = new int[getInput()];
		fibo[0] = 0;
		int f = 0, g = 1;
		for (int i = 1; i < getInput(); i++) {
			f = f + g;
			g = f - g;
			fibo[i] = f;
		}
		return fibo;
	}
}