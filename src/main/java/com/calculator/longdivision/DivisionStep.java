package com.calculator.longdivision;

public class DivisionStep {

	private final int minuend;
	private final int subtrahend;

	public DivisionStep(int minuend, int subtrahend) {
		this.minuend = minuend;
		this.subtrahend = subtrahend;
	}

	public int getMinuend() {
		return minuend;
	}

	public int getSubtrahend() {
		return subtrahend;
	}
}
