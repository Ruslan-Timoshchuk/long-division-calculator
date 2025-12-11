package com.calculator.longdivision;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LongDivisionProcessorTest {

    private final LongDivisionProcessor longDivisionProcessor = new LongDivisionProcessor();

    @Test
    void givenDividendAndDivisor_whenDivide_thenNewEqualObject() {
        List<LongDivisionStep> steps = new ArrayList<>();
        steps.add(new LongDivisionStep(7, 4));
        steps.add(new LongDivisionStep(38, 36));
        steps.add(new LongDivisionStep(29, 28));
        steps.add(new LongDivisionStep(14, 12));
        steps.add(new LongDivisionStep(25, 24));
        LongDivisionResult expected = new LongDivisionResult(78945, 4, 19736, 1, steps);
        assertEquals(expected, longDivisionProcessor.divide(78945, 4));
    }

    @Test
    void givenNegativeDividend_whenDivide_thenExeption() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> longDivisionProcessor.divide(-1, 1));
        assertEquals("Dividend must not be negative", exception.getMessage());
    }

    @Test
    void givenDivisorZero_whenDivide_thenExeption() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> longDivisionProcessor.divide(1, 0));
        assertEquals("Divisor must be more than 0", exception.getMessage());
    }

}