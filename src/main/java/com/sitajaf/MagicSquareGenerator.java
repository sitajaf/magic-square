package com.sitajaf;

import com.sitajaf.enums.OrderType;
import com.sitajaf.exceptions.MagicSquareException;

public class MagicSquareGenerator {
    public int[][] generate(int order) throws MagicSquareException {
        if (order == 2) {
            throw new MagicSquareException("Can not generate magic of order 2");
        }

        if (order == 1) {
            return new int[][]{{1}};
        }

        OrderType orderType = determineOrderType(order);

        return orderType.square(order);

    }

    private OrderType determineOrderType(int order) {
        if (order % 2 == 0) {
            if (order % 4 == 0) {
                return OrderType.DOUBLY_EVEN;
            }
            return OrderType.SINGLY_EVEN;
        }
        return OrderType.ODD;
    }
}
