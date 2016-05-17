package com.sitajaf.generators;

public class StracheyGenerator {
    private int[][] miniSquareA;
    private int[][] miniSquareB;
    private int[][] miniSquareC;
    private int[][] miniSquareD;

    private int miniOrder;
    private int n;
    private int maxPosition = miniOrder - 1;

    private SiameseGenerator siameseGenerator = new SiameseGenerator();

    public int[][] get(int order) {

        this.miniOrder = order / 2;
        miniSquareA = siameseGenerator.get(this.miniOrder, 1);
        miniSquareB = siameseGenerator.get(this.miniOrder, ((order * order) / 4) + 1);
        miniSquareC = siameseGenerator.get(this.miniOrder, ((order * order * 2) / 4) + 1);
        miniSquareD = siameseGenerator.get(this.miniOrder, ((order * order * 3) / 4) + 1);

        this.maxPosition = this.miniOrder - 1;
        this.n = (order - 2) / 4;
        swapLeftMostNColumnsOfAAndD();

        exchangeRightMostNMinusOneColumnsOfBAndC();
        exchangeMiddleCellsOfLeftMostColumnsOfAAndD();
        exchangeCentralCellsOfAAndD();
        return combineSquare(order);
    }


    private void swapLeftMostNColumnsOfAAndD() {
        for (int i = 0; i <= this.maxPosition; i++) {
            for (int j = 0; j < this.n; j++) {
                int temp = miniSquareD[i][j];
                miniSquareD[i][j] = miniSquareA[i][j];
                miniSquareA[i][j] = temp;
            }
        }
    }

    private void exchangeRightMostNMinusOneColumnsOfBAndC() {
        int offSet = n - 1;
        int startPosition = maxPosition - offSet + 1;
        for (int i = 0; i <= maxPosition; i++) {
            for (int j = startPosition, counter = startPosition; j <= maxPosition; j++, counter++) {
                int temp = miniSquareC[i][j];
                miniSquareC[i][j] = miniSquareB[i][j];
                miniSquareB[i][j] = temp;
            }
        }
    }

    private void exchangeMiddleCellsOfLeftMostColumnsOfAAndD() {
        int midValue = maxPosition / 2;
        int temp = miniSquareA[midValue][0];
        miniSquareA[midValue][0] = miniSquareD[midValue][0];
        miniSquareD[midValue][0] = temp;
    }

    private void exchangeCentralCellsOfAAndD() {
        int midValue = maxPosition / 2;
        int temp = miniSquareA[midValue][midValue];
        miniSquareA[midValue][midValue] = miniSquareD[midValue][midValue];
        miniSquareD[midValue][midValue] = temp;
    }

    private int[][] combineSquare(int order) {
        int[][] wholeSquare = new int[order][order];
        int lastMiniCellPosition = order / 2 - 1;
        this.maxPosition = order - 1;
        int offSet = order / 2;
        for (int i = 0; i <= lastMiniCellPosition; i++) {
            System.arraycopy(miniSquareA[i], 0, wholeSquare[i], 0, lastMiniCellPosition + 1);
        }

        for (int i = 0; i <= lastMiniCellPosition; i++) {
            System.arraycopy(miniSquareC[i], lastMiniCellPosition + 1 - offSet, wholeSquare[i], lastMiniCellPosition + 1, maxPosition + 1 - (lastMiniCellPosition + 1));
        }

        for (int i = lastMiniCellPosition + 1; i <= maxPosition; i++) {
            System.arraycopy(miniSquareB[i - offSet], lastMiniCellPosition + 1 - offSet, wholeSquare[i], lastMiniCellPosition + 1, maxPosition + 1 - (lastMiniCellPosition + 1));
        }

        for (int i = lastMiniCellPosition + 1; i <= maxPosition; i++) {
            System.arraycopy(miniSquareD[i - offSet], 0, wholeSquare[i], 0, lastMiniCellPosition + 1);
        }

        return wholeSquare;
    }

}
