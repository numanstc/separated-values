package com.numanstc.domain;

public class FixedSizeValues {

    private final String[][] panel;

    public FixedSizeValues(int rowSize, int colSize) {
        panel = new String[rowSize][colSize];
    }

    public void put(int row, int col, String value) {
        panel[row][col] = value;
    }

    public String getSeparatedValues() {
        StringBuilder separatedValues = new StringBuilder();
        for (String[] row : panel) {
            for (String col : row) {
                separatedValues.append(col);
            }
        }
        return separatedValues.toString();
    }
}
