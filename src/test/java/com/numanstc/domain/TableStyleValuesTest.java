package com.numanstc.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableStyleValuesTest {

    @Test
    void itShouldReturnAOneLineAndOneColumnValue() {
        TableStyleValues sut = new TableStyleValues(1, 1);

        sut.put(Point.create(1, 1), "Expected Message");

        assertEquals("Expected Message", sut.create());
    }

    @Test
    void itShouldReturnAOneLineAndTwoColumnsValue() {
        TableStyleValues sut = new TableStyleValues(1, 2);
        sut.setSeparator(",");

        sut.put(Point.create(1, 1), "Col 1");
        sut.put(Point.create(1, 2), "Col 2");

        assertEquals("Col 1,Col 2", sut.create());
    }

    @Test
    void itShouldReturnOneLineAndThreeColumnsAndFirsColumnNull() {
        TableStyleValues sut = new TableStyleValues(1, 3);
        sut.setSeparator(",");

        sut.put(Point.create(1, 2), "Col 2");
        sut.put(Point.create(1, 3), "Col 3");

        assertEquals(",Col 2,Col 3", sut.create());
    }

    @Test
    void itShouldReturnOneLineAndThreeColumnsAndLastColumnNull() {
        TableStyleValues sut = new TableStyleValues(1, 3);
        sut.setSeparator(",");

        sut.put(Point.create(1, 1), "Col 1");
        sut.put(Point.create(1, 2), "Col 2");

        assertEquals("Col 1,Col 2,", sut.create());
    }

    @Test
    void itShouldReturnTwoLinesAndTwoColumns() {
        TableStyleValues sut = new TableStyleValues(2, 2);
        sut.setSeparator(";");

        sut.put(Point.create(1, 1), "Row 1, Col 1");
        sut.put(Point.create(1, 2), "Row 1, Col 2");
        sut.put(Point.create(2, 1), "Row 2, Col 1");
        sut.put(Point.create(2, 2), "Row 2, Col 2");

        assertEquals(
                """
                        Row 1, Col 1;Row 1, Col 2
                        Row 2, Col 1;Row 2, Col 2""",
                sut.create()
        );
    }
    @Test
    void itShouldReturnTwoLinesAndTwoColumnsAndFirsLineNull() {
        TableStyleValues sut = new TableStyleValues(2, 2);
        sut.setSeparator(";");

        sut.put(Point.create(2, 1), "Row 2, Col 1");
        sut.put(Point.create(2, 2), "Row 2, Col 2");

        assertEquals(
                """
                        ;
                        Row 2, Col 1;Row 2, Col 2""",
                sut.create()
        );
    }

    @Test
    void itShouldReturnThreeLinesAndTwoColumnsAndLastLineNull() {
        TableStyleValues sut = new TableStyleValues(3, 2);
        sut.setSeparator(";");

        sut.put(Point.create(1, 1), "Row 1, Col 1");
        sut.put(Point.create(1, 2), "Row 1, Col 2");
        sut.put(Point.create(2, 1), "Row 2, Col 1");
        sut.put(Point.create(2, 2), "Row 2, Col 2");

        assertEquals(
                """
                        Row 1, Col 1;Row 1, Col 2
                        Row 2, Col 1;Row 2, Col 2
                        ;""",
                sut.create()
        );
    }

    @Test
    void itCanUseSeparatorEnum() {
        TableStyleValues sut = new TableStyleValues(2, 2);
        sut.setSeparator(Separator.SEMICOLON);

        sut.put(Point.create(1, 1), "Row 1, Col 1");
        sut.put(Point.create(1, 2), "Row 1, Col 2");
        sut.put(Point.create(2, 1), "Row 2, Col 1");
        sut.put(Point.create(2, 2), "Row 2, Col 2");

        assertEquals(
                """
                        Row 1, Col 1;Row 1, Col 2
                        Row 2, Col 1;Row 2, Col 2""",
                sut.create()
        );
    }

}
