package com.calculator.longdivision;

public class LongDivisionStep {

	private final int minuend;
	private final int subtrahend;

	public LongDivisionStep(int minuend, int subtrahend) {
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
