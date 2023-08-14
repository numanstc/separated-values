package com.numanstc.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderStyleValuesTest {

    @Test
    void itShouldBuildEmptyValues() {
        BuilderStyleValues sut = new BuilderStyleValues();

        assertEquals("", sut.build());
    }

    @Test
    void itShouldAddRows() {
        BuilderStyleValues sut = new BuilderStyleValues();

        assertEquals("""
                """,
                sut
                        .addRow()
                        .build()
        );
    }

    @Test
    void itShouldAddColumn() {
        BuilderStyleValues sut = new BuilderStyleValues();

        assertEquals("""
                Row 1, Col 1""",
                sut
                        .addRow()
                        .addCol("Row 1, Col 1")
                        .build()
        );
    }

}