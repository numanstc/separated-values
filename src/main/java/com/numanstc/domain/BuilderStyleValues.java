package com.numanstc.domain;

public class BuilderStyleValues {

    private BuilderStyleValues() {
    }

    public static BuilderStyleValues builder() {
        return new BuilderStyleValues();
    }

    private final StringBuilder builder = new StringBuilder();


    public String build() {
        return builder.toString();
    }

    public BuilderStyleValues addRow() {
        if (!builder.isEmpty())
            builder.append(System.lineSeparator());
        return this;
    }

    public BuilderStyleValues addCol(String value) {
        builder.append(value);
        return this;
    }
}
