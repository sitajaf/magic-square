package com.sitajaf;

import com.sitajaf.exceptions.MagicSquareException;

public class MagicSquareGenerator {
    public int[][] generate(int order) throws MagicSquareException {
        if (order == 2) {
            throw new MagicSquareException("Can not generate magic of order 2");
        }

        return new int[][]{{1}};
    }
}
