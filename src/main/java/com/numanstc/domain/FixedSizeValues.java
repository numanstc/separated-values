package com.numanstc.domain;

public class FixedSizeValues {

    private final String[][] panel;
    private String separator;

    public FixedSizeValues(int rowSize, int colSize) {
        panel = new String[rowSize][colSize];
    }

    public void put(int row, int col, String value) {
        panel[row][col] = value;
    }

    public String getSeparatedValues() {
        StringBuilder separatedValues = new StringBuilder();
        for (String[] row : panel) {
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                separatedValues.append(row[colIndex]);
                if (colIndex != row.length - 1)
                    separatedValues.append(separator);
            }
        }
        return separatedValues.toString();
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public void put(Point point, String value) {
        panel[point.getRow()][point.getCol()] = value;
    }
}
