package com.calculator.longdivision;

import static java.lang.System.lineSeparator;
import java.util.List;

public class LongDivisionFormatter {

	public static final String SPACE_DELIMITER = " ";
	public static final String HYPHEN_DELIMITER = "-";
	public static final String LOW_LINE = "_";
	public static final String PIPE_LINE = "|";

	public String format(LongDivisionResult result) {
		StringBuilder format = new StringBuilder();
		List<LongDivisionStep> subtractionSteps = result.getSteps();
		if (subtractionSteps.isEmpty()) {
			format.append("Sorry. Is not have a sense to long division this");
		} else {		    
			int dividendLength = String.valueOf(result.getDividend()).length();
			int quotientLength = String.valueOf(result.getQuotient()).length();
			int positionOfElement = (dividendLength - quotientLength);
			LongDivisionStep step = subtractionSteps.get(positionOfElement);
			format.append(buildHeader(result, step));
			positionOfElement++;
			format.append(buildSteps(result, positionOfElement));
		}
		return format.toString();
	}

	private String buildHeader(LongDivisionResult result, LongDivisionStep step) {
		StringBuilder format = new StringBuilder();
		format.append(LOW_LINE);
		format.append(result.getDividend());
		format.append(PIPE_LINE);
		format.append(result.getDivisor());
		format.append(lineSeparator());
		format.append(SPACE_DELIMITER);
		int dividendLength = String.valueOf(result.getDividend()).length();
		int quotientLength = String.valueOf(result.getQuotient()).length();
		int minuendLength = String.valueOf(step.getMinuend()).length();
		int subtrahendLength = String.valueOf(step.getSubtrahend()).length();
		int spaceOfSubtrahend = minuendLength - subtrahendLength;
		format.append(addSymbols(SPACE_DELIMITER, spaceOfSubtrahend));
		format.append(step.getSubtrahend());
		int spaceOfQuotient = dividendLength - minuendLength;
		format.append(addSymbols(SPACE_DELIMITER, spaceOfQuotient));
		format.append(PIPE_LINE);
		format.append(addSymbols(HYPHEN_DELIMITER, quotientLength));
		format.append(lineSeparator());
		format.append(SPACE_DELIMITER);
		format.append(addSymbols(HYPHEN_DELIMITER, minuendLength));
		format.append(addSymbols(SPACE_DELIMITER, spaceOfQuotient));
		format.append(PIPE_LINE);
		format.append(result.getQuotient());
		format.append(lineSeparator());
		return format.toString();
	}

	private String buildSteps(LongDivisionResult result, int positionOfElement) {
		StringBuilder format = new StringBuilder();
		List<LongDivisionStep> subtractionSteps = result.getSteps();
		int space = 0;
		for (int i = positionOfElement; subtractionSteps.size() > i; i++) {
			LongDivisionStep step = subtractionSteps.get(i);
			int minuend = step.getMinuend();
			int divisor = result.getDivisor();
			if (minuend >= divisor) {
				int minuendLength = String.valueOf(step.getMinuend()).length();
				int spaceOfMinuend = (i + 1) - minuendLength;
				format.append(addSymbols(SPACE_DELIMITER, spaceOfMinuend));
				format.append(LOW_LINE);
				format.append(minuend);
				format.append(lineSeparator());
				int subtrahendLength = String.valueOf(step.getSubtrahend()).length();
				int subtrahend = step.getSubtrahend();
				spaceOfMinuend++;
				int spaceOfSubtrahend = spaceOfMinuend + (minuendLength - subtrahendLength);
				format.append(addSymbols(SPACE_DELIMITER, (spaceOfSubtrahend)));
				format.append(subtrahend);
				format.append(lineSeparator());
				format.append(addSymbols(SPACE_DELIMITER, (spaceOfMinuend)));
				format.append(addSymbols(HYPHEN_DELIMITER, minuendLength));
				format.append(lineSeparator());
				space = i;
			}
		}
		format.append(buildReminder(result, space));
		return format.toString();
	}

	private String buildReminder(LongDivisionResult result, int space) {
		StringBuilder format = new StringBuilder();
		int remainder = result.getRemainder();
		int remainderLength = String.valueOf(remainder).length();
		int spaceOfRemainder = space + 1 - remainderLength;
		format.append(SPACE_DELIMITER);
		format.append(addSymbols(SPACE_DELIMITER, spaceOfRemainder));
		format.append(remainder);
		return format.toString();
	}

	private String addSymbols(String symbol, int length) {
		StringBuilder spaces = new StringBuilder();
		for (int i = 0; i < length; i++) {
			spaces.append(symbol);
		}
		return spaces.toString();
	}
	
}