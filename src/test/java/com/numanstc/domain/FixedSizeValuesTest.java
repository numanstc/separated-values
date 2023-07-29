package com.numanstc.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeValuesTest {

    @Test
    void itShouldReturnAOneLineAndOneColumnValue() {
        FixedSizeValues sut = new FixedSizeValues(1, 1);

        sut.put(Point.create(1, 1), "Expected Message");

        assertEquals("Expected Message", sut.getSeparatedValues());
    }

    @Test
    void itShouldReturnAOneLineAndTwoColumnsValue() {
        FixedSizeValues sut = new FixedSizeValues(1, 2);
        sut.setSeparator(",");

        sut.put(Point.create(1, 1), "Col 1");
        sut.put(Point.create(1, 2), "Col 2");

        assertEquals("Col 1,Col 2", sut.getSeparatedValues());
    }

    @Test
    void itShouldReturnOneLineAndThreeColumnsAndFirsColumnNull() {
        FixedSizeValues sut = new FixedSizeValues(1, 3);
        sut.setSeparator(",");

        sut.put(Point.create(1, 2), "Col 2");
        sut.put(Point.create(1, 3), "Col 3");

        assertEquals(",Col 2,Col 3", sut.getSeparatedValues());
    }

    @Test
    void itShouldReturnOneLineAndThreeColumnsAndLastColumnNull() {
        FixedSizeValues sut = new FixedSizeValues(1, 3);
        sut.setSeparator(",");

        sut.put(Point.create(1, 1), "Col 1");
        sut.put(Point.create(1, 2), "Col 2");

        assertEquals("Col 1,Col 2,", sut.getSeparatedValues());
    }

}
