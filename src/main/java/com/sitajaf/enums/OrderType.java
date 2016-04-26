package com.sitajaf.enums;

import com.sitajaf.generators.OddOrderGenerator;

public enum OrderType {
    ODD {
        OddOrderGenerator oddOrderGenerator = new OddOrderGenerator();

        @Override
        public int[][] square(int order) {
            return oddOrderGenerator.get(order);
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
