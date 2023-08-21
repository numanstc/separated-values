package com.numanstc.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringStyleValuesTest {

    @Test
    void itShouldBuildEmptyValues() {
        assertEquals("",
                StringStyleValues
                        .builder("!")
                        .create()
        );
    }

    @Test
    void itShouldAddRows() {
        assertEquals("""
                """,
                StringStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .create()
        );
    }

    @Test
    void itShouldAddColumn() {
        assertEquals("""
                        Row 1, Col 1""",
                StringStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addCol("Row 1, Col 1")
                        .create()
        );
    }

    @Test
    void itShouldAddMultipleRowsColumn() {
        assertEquals("""
                        Row 1, Col 1
                        Row 2, Col 1""",
                StringStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addCol("Row 1, Col 1")
                        .addRow()
                        .addCol("Row 2, Col 1")
                        .create()
        );
    }

    @Test
    void itShouldAddMultipleRows() {
        assertEquals("""
                        Row 1, Col 1;Row 1, Col 2""",
                StringStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addCol("Row 1, Col 1")
                        .addCol("Row 1, Col 2")
                        .create()
        );
    }

    @Test
    void itShouldReturnTwoLinesAndTwoColumnsAndFirsLineNull() {
        assertEquals(
                """
                        ;
                        Row 2, Col 1;Row 2, Col 2""",
                StringStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addRow()
                        .addCol("Row 2, Col 1")
                        .addCol("Row 2, Col 2")
                        .create()
        );
    }

    @Test
    void itShouldReturnTwoLinesAndThreeColumnsAndFirsLineNull() {
        assertEquals(
                """
                        ;;
                        Row 2, Col 1;Row 2, Col 2;Row 2, Col 3""",
                StringStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addRow()
                        .addCol("Row 2, Col 1")
                        .addCol("Row 2, Col 2")
                        .addCol("Row 2, Col 3")
                        .create()
        );
    }

    @Test
    void itShouldReturnTwoLinesAndTwoColumnsAndSecondLineNull() {
        assertEquals(
                """
                        Row 1, Col 1;Row 1, Col 2
                        """,
                StringStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addCol("Row 1, Col 1")
                        .addCol("Row 1, Col 2")
                        .addRow()
                        .create()
        );
    }

    @Test
    void itShouldReturnTreeLinesAndTreeColumnsAndSecondLineNull() {
        assertEquals(
                """
                        Row 1, Col 1;Row 1, Col 2;Row 1, Col 3
                        ;;
                        Row 3, Col 1;Row 3, Col 2;Row 3, Col 3""",
                StringStyleValues
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
                        .create()
        );
    }

    @Test
    void itShouldReturnFourLinesAndTreeColumnsAndSecondLineNull() {
        assertEquals(
                """
                        Row 1, Col 1;Row 1, Col 2;Row 1, Col 3
                        ;;
                        ;;
                        Row 3, Col 1;Row 3, Col 2;Row 3, Col 3""",
                StringStyleValues
                        .builder(Separator.SEMICOLON)
                        .addRow()
                        .addCol("Row 1, Col 1")
                        .addCol("Row 1, Col 2")
                        .addCol("Row 1, Col 3")
                        .addRow()
                        .addRow()
                        .addRow()
                        .addCol("Row 3, Col 1")
                        .addCol("Row 3, Col 2")
                        .addCol("Row 3, Col 3")
                        .create()
        );
    }
}