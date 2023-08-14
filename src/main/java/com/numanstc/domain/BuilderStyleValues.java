package com.numanstc.domain;

public class BuilderStyleValues {

    private final StringBuilder builder = new StringBuilder();


    public String build() {
        return builder.toString();
    }

    public BuilderStyleValues addRow() {
        builder.append(System.lineSeparator());
        return this;
    }
}
