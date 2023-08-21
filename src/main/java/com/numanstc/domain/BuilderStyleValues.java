package com.numanstc.domain;

public class BuilderStyleValues {
    private static final String ROW_SEPARATOR = System.lineSeparator();
    private final String colSeparator;
    private final StringBuilder builder;
    private int maxRowNumber = 0;
    private int maxColNumber = 0;
    private int colNumber = 0;

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
        colNumber = 0;
        maxRowNumber++;
        if (maxRowNumber <= 1)
            builder.append("");
        else
            builder.append(ROW_SEPARATOR);
        return this;
    }

    public BuilderStyleValues addCol(String value) {
        addSeparator();
        builder.append(value);
        addColNumber();
        return this;
    }

    private void addSeparator() {
        int lastLineIndex = builder.lastIndexOf(ROW_SEPARATOR);
        int length = builder.length();
        if (length > lastLineIndex + 1 && length > 0)
            builder.append(colSeparator);
    }

    private void addColNumber() {
        if (++colNumber > maxColNumber && !isFirstColumn()) {
            maxColNumber = colNumber;
            addEmptyColPreviousRows();
        }
    }

    private boolean isFirstColumn() {
        return colNumber == 1;
    }

    private void addEmptyColPreviousRows() {
        int rowSeparatorIndex = builder.indexOf(ROW_SEPARATOR);
        for (int rowNumber = 1; rowNumber < maxRowNumber; rowNumber++) {
            builder.insert(rowSeparatorIndex, colSeparator);

            rowSeparatorIndex = builder.indexOf(ROW_SEPARATOR, rowSeparatorIndex + colSeparator.length() + 1);
        }

    }
}
