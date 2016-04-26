package com.sitajaf.enums;

public enum OrderType {
    ODD {
        int[][] square;
        int MAX_CELL;
        int valueToFill;
        int currentCellRow = -1;
        int currentCellColumn = -1;

        @Override
        public int[][] square(int order) {
            this.valueToFill = 1;
            this.square = new int[order][order];
            this.MAX_CELL = order - 1;
            int noOfCellsToFill = order * order;

            fillFirstRowMiddleCell();
            valueToFill++;

            while (valueToFill <= noOfCellsToFill) {
                fillNext();
                valueToFill++;
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
                this.currentCellRow += 1;
                this.square[this.currentCellRow][this.currentCellColumn] = valueToFill;
            } else {
                this.square[nextPossiblePosition[0]][nextPossiblePosition[1]] = valueToFill;
                this.currentCellRow = nextPossiblePosition[0];
                this.currentCellColumn = nextPossiblePosition[1];
            }
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
    },
    DOUBLY_EVEN {
        @Override
        public int[][] square(int order) {
            return new int[0][];
        }
    },
    SINGLY_EVEN {
        @Override
        public int[][] square(int order) {
            return new int[0][];
        }
    };

    public abstract int[][] square(int order);
}
