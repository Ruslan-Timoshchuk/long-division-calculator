package com.calculator.longdivision;

import java.util.List;
import java.util.Objects;

public class DivisionResult {

	private final int dividend;
	private final int divisor;
	private final int quotient;
	private final int remainder;
	private final List<DivisionStep> steps;

	public DivisionResult(int dividend, int divisor, int quotient, int remainder, List<DivisionStep> steps) {
		this.dividend = dividend;
		this.divisor = divisor;
		this.quotient = quotient;
		this.remainder = remainder;
		this.steps = steps;
	}

	public int getDividend() {
		return dividend;
	}

	public int getDivisor() {
		return divisor;
	}

	public int getQuotient() {
		return quotient;
	}

	public int getRemainder() {
		return remainder;
	}

	public List<DivisionStep> getSteps() {
		return steps;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dividend, divisor, quotient, remainder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DivisionResult result = (DivisionResult) obj;
		return dividend == result.dividend && divisor == result.divisor && quotient == result.quotient
				&& remainder == result.remainder;
	}
}
