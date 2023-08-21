package com.numanstc.domain;

public class StringStyleValues {
    private static final String ROW_SEPARATOR = System.lineSeparator();
    private final String colSeparator;
    private final StringBuilder builder;
    private int maxRowNumber = 0;
    private int maxColNumber = 0;
    private int minColNumber = 0;
    private int currentColNumber = 0;

    private StringStyleValues(String colSeparator) {
        this.colSeparator = colSeparator;
        builder = new StringBuilder();
    }

    public static StringStyleValues builder(Separator separator) {
        return new StringStyleValues(separator.getText());
    }

    public static StringStyleValues builder(String separator) {
        return new StringStyleValues(separator);
    }

    public String build() {
        return builder.toString();
    }

    public StringStyleValues addRow() {
        if (currentColNumber < minColNumber)
            minColNumber = currentColNumber;

        currentColNumber = 0;
        maxRowNumber++;
        if (maxRowNumber <= 1)
            builder.append("");
        else
            builder.append(ROW_SEPARATOR);

        checkColNumber();
        return this;
    }

    private void checkColNumber() {
        int rowSeparatorIndex = builder.lastIndexOf(ROW_SEPARATOR);
        rowSeparatorIndex = builder.lastIndexOf(ROW_SEPARATOR, rowSeparatorIndex - 1);
        for (; minColNumber < maxColNumber && rowSeparatorIndex > 0; minColNumber++) {
            if (isFirstColumn(minColNumber))
                continue;

            builder.insert(rowSeparatorIndex + 1, colSeparator);
        }
    }

    public StringStyleValues addCol(String value) {
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
        if (++currentColNumber > maxColNumber && !isFirstColumn(currentColNumber)) {
            maxColNumber = currentColNumber;
            addEmptyColPreviousRows();
        }
    }

    private boolean isFirstColumn(int col) {
        return col == 1;
    }

    private void addEmptyColPreviousRows() {
        int rowSeparatorIndex = builder.indexOf(ROW_SEPARATOR);
        for (int rowNumber = 1; rowNumber < maxRowNumber; rowNumber++) {
            builder.insert(rowSeparatorIndex, colSeparator);

            rowSeparatorIndex = builder.indexOf(ROW_SEPARATOR, rowSeparatorIndex + colSeparator.length() + 1);
        }

    }
}
