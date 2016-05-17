package com.sitajaf;

import com.sitajaf.exceptions.MagicSquareException;
import com.sitajaf.generators.SiameseGenerator;
import com.sitajaf.generators.StracheyGenerator;

class MagicSquareGenerator {
    private SiameseGenerator siameseGenerator;
    private StracheyGenerator stracheyGenerator;

    MagicSquareGenerator(SiameseGenerator siameseGenerator, StracheyGenerator stracheyGenerator) {
        this.siameseGenerator = siameseGenerator;
        this.stracheyGenerator = stracheyGenerator;
    }

    MagicSquareGenerator() {
        this.siameseGenerator = new SiameseGenerator();
        this.stracheyGenerator = new StracheyGenerator();
    }

    int[][] generate(int order) throws MagicSquareException {
        if (order == 2 || order <= 0) {
            throw new MagicSquareException("Can not generate magic of order 2");
        }

        if (order == 1) {
            return new int[][]{{1}};
        }

        return getSqaure(order);
    }

    private int[][] getSqaure(int order) throws MagicSquareException {
        if (order % 2 == 0) {
            if (order % 4 == 0) {
                throw new MagicSquareException("Even Order Not yet supported!");
            }
            return stracheyGenerator.get(order);

        }
        return siameseGenerator.get(order);
    }
}
