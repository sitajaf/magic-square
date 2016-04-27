package com.sitajaf;

import com.sitajaf.exceptions.MagicSquareException;
import com.sitajaf.generators.SiameseGenerator;

class MagicSquareGenerator {
    private SiameseGenerator siameseGenerator;

    MagicSquareGenerator(SiameseGenerator siameseGenerator) {
        this.siameseGenerator = siameseGenerator;
    }

    int[][] generate(int order) throws MagicSquareException {
        if (order == 2 || order <=0) {
            throw new MagicSquareException("Can not generate magic of order 2");
        }

        if (order == 1) {
            return new int[][]{{1}};
        }

        return getSqaure(order);
    }

    private int[][] getSqaure(int order) throws MagicSquareException {
        if (order % 2 == 0) {
//            if (order % 4 == 0) {
//                 Doubly even
//            }
//            singly even
            throw new MagicSquareException("Even Order Not yet supported!");
        }
        return siameseGenerator.get(order);
    }
}
