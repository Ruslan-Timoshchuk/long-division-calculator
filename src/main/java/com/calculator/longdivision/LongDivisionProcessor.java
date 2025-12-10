package com.calculator.longdivision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongDivisionProcessor {

	public LongDivisionResult divide(int dividend, int divisor) {
		requirePositiveNumber(dividend, divisor);
		List<Integer> digits = splitToDigits(dividend);
		int quotient = 0;
		int remainder = 0;
		List<LongDivisionStep> steps = new ArrayList<>();
		for (int i = 0; i < digits.size(); i++) {
			int minuend = remainder * 10 + digits.get(i);
			int partOfQuotient = minuend / divisor;
			quotient = quotient * 10 + partOfQuotient;
			int subtrahend = partOfQuotient * divisor;
			remainder = minuend - subtrahend;
			steps.add(new LongDivisionStep(minuend, subtrahend));
		}
		return new LongDivisionResult(dividend, divisor, quotient, remainder, steps);
	}

	private List<Integer> splitToDigits(int dividend) {
		List<Integer> digits = new ArrayList<>();
		while (dividend > 0) {
			digits.add(dividend % 10);
			dividend /= 10;
		}
		Collections.reverse(digits);
		return digits;
	}

	private void requirePositiveNumber(int dividend, int divisor) {
		if (dividend < 0) {
			throw new IllegalArgumentException("Dividend must not be negative");
		} else if (divisor < 1) {
			throw new IllegalArgumentException("Divisor must be more than 0");
		}
	}
}