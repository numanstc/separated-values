package com.numanstc.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuilderStyleValuesTest {

    @Test
    void itShouldBuildEmptyValues() {
        assertEquals("",
                BuilderStyleValues
                        .builder("!")
                        .build()
        );
    }

    @Test
    void itShouldAddRows() {
        assertEquals("""
                """,
                BuilderStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .build()
        );
    }

    @Test
    void itShouldAddColumn() {
        assertEquals("""
                        Row 1, Col 1""",
                BuilderStyleValues
                        .builder(Separator.SEMICOLON)
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
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addCol("Row 1, Col 1")
                        .addRow()
                        .addCol("Row 2, Col 1")
                        .build()
        );
    }

    @Test
    void itShouldAddMultipleRows() {
        assertEquals("""
                        Row 1, Col 1;Row 1, Col 2""",
                BuilderStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addCol("Row 1, Col 1")
                        .addCol("Row 1, Col 2")
                        .build()
        );
    }

    @Test
    void itShouldReturnTwoLinesAndTwoColumnsAndFirsLineNull() {
        assertEquals(
                """
                        ;
                        Row 2, Col 1;Row 2, Col 2""",
                BuilderStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addRow()
                        .addCol("Row 2, Col 1")
                        .addCol("Row 2, Col 2")
                        .build()
        );
    }

    @Test
    void itShouldReturnTwoLinesAndThreeColumnsAndFirsLineNull() {
        assertEquals(
                """
                        ;;
                        Row 2, Col 1;Row 2, Col 2;Row 2, Col 3""",
                BuilderStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addRow()
                        .addCol("Row 2, Col 1")
                        .addCol("Row 2, Col 2")
                        .addCol("Row 2, Col 3")
                        .build()
        );
    }

    @Test
    void itShouldReturnTwoLinesAndTwoColumnsAndSecondLineNull() {
        assertEquals(
                """
                        Row 1, Col 1;Row 1, Col 2
                        """,
                BuilderStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addCol("Row 1, Col 1")
                        .addCol("Row 1, Col 2")
                        .addRow()
                        .build()
        );
    }

    @Test
    void itShouldReturnTreeLinesAndTreeColumnsAndSecondLineNull() {
        assertEquals(
                """
                        Row 1, Col 1;Row 1, Col 2;Row 1, Col 3
                        ;;
                        Row 3, Col 1;Row 3, Col 2;Row 3, Col 3""",
                BuilderStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addCol("Row 1, Col 1")
                        .addCol("Row 1, Col 2")
                        .addCol("Row 1, Col 3")
                        .addRow()
                        .addRow()
                        .addCol("Row 3, Col 1")
                        .addCol("Row 3, Col 2")
                        .addCol("Row 3, Col 3")
                        .build()
        );
    }
}