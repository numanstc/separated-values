package com.numanstc.domain;

public class BuilderStyleValues {
    private static final String ROW_SEPARATOR = System.lineSeparator();
    private final String colSeparator;
    private final StringBuilder builder;

    private BuilderStyleValues(String colSeparator) {
        this.colSeparator = colSeparator;
        builder = new StringBuilder();
    }

    public static BuilderStyleValues builder(Separator separator) {
        return new BuilderStyleValues(separator.getText());
    }

    public static BuilderStyleValues builder(String separator) {
        return new BuilderStyleValues(separator);
    }

    public String build() {
        return builder.toString();
    }

    public BuilderStyleValues addRow() {
        if (!builder.isEmpty())
            builder.append(ROW_SEPARATOR);
        return this;
    }

    public BuilderStyleValues addCol(String value) {
        addSeparator();
        builder.append(value);
        return this;
    }

    private void addSeparator() {
        int lastLineIndex = builder.lastIndexOf(ROW_SEPARATOR);
        int length = builder.length();
        if (length > lastLineIndex + 1 && length > 0)
            builder.append(colSeparator);
    }
}
