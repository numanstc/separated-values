package com.numanstc.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeValuesTest {

    @Test
    void itShouldReturnAOneLineAndOneColumnValue() {
        FixedSizeValues sut = new FixedSizeValues(1, 1);

        sut.put(0, 0, "Expected Message");

        assertEquals("Expected Message", sut.getSeparatedValues());
    }

    @Test
    void itShouldReturnAOneLineAndTwoColumnsValue() {
        FixedSizeValues sut = new FixedSizeValues(1, 2);
        sut.setSeparator(",");

        sut.put(0, 0, "Col 1");
        sut.put(0, 1, "Col 2");

        assertEquals("Col 1,Col 2", sut.getSeparatedValues());
    }

}
