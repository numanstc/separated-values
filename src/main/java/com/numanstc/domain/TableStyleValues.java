package com.numanstc.domain;

import java.util.Objects;

public class TableStyleValues {
    private static final String EMPTY_COLUMN = "";

    private final String[][] panel;
    private String separator;

    public TableStyleValues(int rowSize, int colSize) {
        panel = new String[rowSize][colSize];
    }

    public void put(Point point, String value) {
        panel[point.row() - 1][point.column() - 1] = value;
    }

    public String getSeparatedValues() {
        StringBuilder separatedValues = new StringBuilder();
        for (int rowIndex = 0; rowIndex < panel.length; rowIndex++) {
            for (int colIndex = 0; colIndex < panel[rowIndex].length; colIndex++) {
                separatedValues.append(Objects.requireNonNullElse(panel[rowIndex][colIndex], EMPTY_COLUMN));
                if (colIndex != panel[rowIndex].length - 1)
                    separatedValues.append(separator);
            }
            if (rowIndex != panel.length - 1)
                separatedValues.append(System.lineSeparator());
        }
        return separatedValues.toString();
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public void setSeparator(Separator separator) {
        this.separator = separator.getText();
    }
}
