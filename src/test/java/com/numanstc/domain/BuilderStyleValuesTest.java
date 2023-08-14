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

}