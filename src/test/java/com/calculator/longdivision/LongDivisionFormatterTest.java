package com.calculator.longdivision;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LongDivisionFormatterTest {

    private final LongDivisionFormatter formatter = new LongDivisionFormatter();
    private final LongDivisionProcessor longDivisionProcessor = new LongDivisionProcessor();

    @Test
    void givenNull_whenFormat_thenNullPointerException() {
        assertThrows(NullPointerException.class, () -> formatter.format(null));
    }

    @Test
    void given_78945And4_whenFormat_thenLongDivision() {
        LongDivisionResult result = longDivisionProcessor.divide(78945, 4);
        StringBuilder expected = new StringBuilder();
        expected.append("_78945|4" + lineSeparator());
        expected.append(" 4    |-----" + lineSeparator());
        expected.append(" -    |19736" + lineSeparator());
        expected.append("_38" + lineSeparator());
        expected.append(" 36" + lineSeparator());
        expected.append(" --" + lineSeparator());
        expected.append(" _29" + lineSeparator());
        expected.append("  28" + lineSeparator());
        expected.append("  --" + lineSeparator());
        expected.append("  _14" + lineSeparator());
        expected.append("   12" + lineSeparator());
        expected.append("   --" + lineSeparator());
        expected.append("   _25" + lineSeparator());
        expected.append("    24" + lineSeparator());
        expected.append("    --" + lineSeparator());
        expected.append("     1");
        assertEquals(expected.toString(), formatter.format(result));
    }

    @Test
    void given_1823000002And13_whenFormat_thenLongDivision() {
        LongDivisionResult result = longDivisionProcessor.divide(1823000002, 13);
        StringBuilder expected = new StringBuilder();
        expected.append("_1823000002|13" + lineSeparator());
        expected.append(" 13        |---------" + lineSeparator());
        expected.append(" --        |140230769" + lineSeparator());
        expected.append(" _52" + lineSeparator());
        expected.append("  52" + lineSeparator());
        expected.append("  --" + lineSeparator());
        expected.append("   _30" + lineSeparator());
        expected.append("    26" + lineSeparator());
        expected.append("    --" + lineSeparator());
        expected.append("    _40" + lineSeparator());
        expected.append("     39" + lineSeparator());
        expected.append("     --" + lineSeparator());
        expected.append("     _100" + lineSeparator());
        expected.append("       91" + lineSeparator());
        expected.append("      ---" + lineSeparator());
        expected.append("       _90" + lineSeparator());
        expected.append("        78" + lineSeparator());
        expected.append("        --" + lineSeparator());
        expected.append("       _122" + lineSeparator());
        expected.append("        117" + lineSeparator());
        expected.append("        ---" + lineSeparator());
        expected.append("          5");
        assertEquals(expected.toString(), formatter.format(result));
    }

    @Test
    void given_405022500And45_whenFormat_thenLongDivision() {
        LongDivisionResult result = longDivisionProcessor.divide(405022500, 45);
        StringBuilder expected = new StringBuilder();
        expected.append("_405022500|45" + lineSeparator());
        expected.append(" 405      |-------" + lineSeparator());
        expected.append(" ---      |9000500" + lineSeparator());
        expected.append("    _225" + lineSeparator());
        expected.append("     225" + lineSeparator());
        expected.append("     ---" + lineSeparator());
        expected.append("       0");
        assertEquals(expected.toString(), formatter.format(result));
    }

    @Test
    void given_100100And99_whenFormat_thenLongDivision() {
        LongDivisionResult result = longDivisionProcessor.divide(100100, 99);
        StringBuilder expected = new StringBuilder();
        expected.append("_100100|99" + lineSeparator());
        expected.append("  99   |----" + lineSeparator());
        expected.append(" ---   |1011" + lineSeparator());
        expected.append("  _110" + lineSeparator());
        expected.append("    99" + lineSeparator());
        expected.append("   ---" + lineSeparator());
        expected.append("   _110" + lineSeparator());
        expected.append("     99" + lineSeparator());
        expected.append("    ---" + lineSeparator());
        expected.append("     11");
        assertEquals(expected.toString(), formatter.format(result));
    }

    @Test
    void given_100040000And4_whenFormat_thenLongDivision() {
        LongDivisionResult result = longDivisionProcessor.divide(100040000, 4);
        StringBuilder expected = new StringBuilder();
        expected.append("_100040000|4" + lineSeparator());
        expected.append("  8       |--------" + lineSeparator());
        expected.append(" --       |25010000" + lineSeparator());
        expected.append(" _20" + lineSeparator());
        expected.append("  20" + lineSeparator());
        expected.append("  --" + lineSeparator());
        expected.append("    _4" + lineSeparator());
        expected.append("     4" + lineSeparator());
        expected.append("     -" + lineSeparator());
        expected.append("     0");
        assertEquals(expected.toString(), formatter.format(result));
    }

    @Test
    void given_52And28_whenFormat_thenLongDivision() {
        LongDivisionResult result = longDivisionProcessor.divide(52, 28);
        StringBuilder expected = new StringBuilder();
        expected.append("_52|28" + lineSeparator());
        expected.append(" 28|-" + lineSeparator());
        expected.append(" --|1" + lineSeparator());
        expected.append(" 24");
        assertEquals(expected.toString(), formatter.format(result));
    }

}