package com.numanstc.domain;

public class Point {
    private final int row;
    private final int col;
    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Point create(int row, int col) {
        return new Point(row, col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
