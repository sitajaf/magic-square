package com.sitajaf.generators;

public class SiameseGenerator {
    private int[][] square;
    private int MAX_CELL;
    private int valueToFill;
    private int filled = 1;
    private int currentCellRow = -1;
    private int currentCellColumn = -1;

    public int[][] get(int order) {
        this.valueToFill = 1;
        return square(order);
    }

    public int[][] get(int order, int startingValue) {
        this.valueToFill = startingValue;
        return square(order);
    }

    private int[][] square(int order) {
        this.square = new int[order][order];
        this.MAX_CELL = order - 1;
        int noOfCellsToFill = order * order;

        fillFirstRowMiddleCell();
        valueToFill++;
        this.filled++;

        while (this.filled <= noOfCellsToFill) {
            fillNext();
            valueToFill++;
            filled++;
        }

        return square;
    }

    private void fillFirstRowMiddleCell() {
        int firstRow = 0;
        int middleColumnNo = (MAX_CELL) / 2;

        this.square[firstRow][middleColumnNo] = valueToFill;
        this.currentCellRow = firstRow;
        this.currentCellColumn = middleColumnNo;
    }

    private void fillNext() {
        int[] nextPossiblePosition = nextPossiblePosition();
        if (this.square[nextPossiblePosition[0]][nextPossiblePosition[1]] > 0) {
            this.currentCellRow += 1;    //just move to the row below
        } else {
            this.currentCellRow = nextPossiblePosition[0];
            this.currentCellColumn = nextPossiblePosition[1];
        }
        this.square[this.currentCellRow][this.currentCellColumn] = valueToFill;
    }

    private int[] nextPossiblePosition() {
        int possibleCellRow, possibleCellColumn;

        //move up
        possibleCellRow = this.currentCellRow - 1;
        if (possibleCellRow < 0) {
            possibleCellRow = MAX_CELL;
        }

        //move right
        possibleCellColumn = this.currentCellColumn + 1;
        if (possibleCellColumn > MAX_CELL) {
            possibleCellColumn = 0;
        }
        return new int[]{possibleCellRow, possibleCellColumn};
    }
}
