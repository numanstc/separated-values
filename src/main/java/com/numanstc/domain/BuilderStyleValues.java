package com.numanstc.domain;

public class BuilderStyleValues {
    private final String separator;
    private final StringBuilder builder;

    private BuilderStyleValues(String separator) {
        this.separator = separator;
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
            builder.append(System.lineSeparator());
        return this;
    }

    public BuilderStyleValues addCol(String value) {
        addSeparator();
        builder.append(value);
        return this;
    }

    private void addSeparator() {
        int lastLineIndex = builder.lastIndexOf(System.lineSeparator());
        int length = builder.length();
        if (length > lastLineIndex + 1 && length > 0)
            builder.append(separator);
    }
}
