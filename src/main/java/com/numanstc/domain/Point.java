package com.numanstc.domain;

/**
 * Points start from 1, 1 like an Excel sheet.
 */
public record Point(int row, int column) {
    public Point {
        if (row <= 0 || column <= 0)
            throw new IndexOutOfBoundsException("The row or column number must be bigger than zero.");
    }

    public static Point create(int row, int column) {
        return new Point(row, column);
    }
}
