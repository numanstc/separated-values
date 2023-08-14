package com.numanstc.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderStyleValuesTest {

    @Test
    void itShouldBuildEmptyValues() {
        assertEquals("", BuilderStyleValues.builder().build());
    }

    @Test
    void itShouldAddRows() {
        assertEquals("""
                """,
                BuilderStyleValues
                        .builder()
                        .addRow()
                        .build()
        );
    }

    @Test
    void itShouldAddColumn() {
        assertEquals("""
                Row 1, Col 1""",
                BuilderStyleValues
                        .builder()
                        .addRow()
                        .addCol("Row 1, Col 1")
                        .build()
        );
    }

    @Test
    void itShouldAddMultipleRowsColumn() {
        assertEquals("""
                Row 1, Col 1
                Row 2, Col 1""",
                BuilderStyleValues
                        .builder()
                        .addRow()
                        .addCol("Row 1, Col 1")
                        .addRow()
                        .addCol("Row 2, Col 1")
                        .build()
        );
    }

}