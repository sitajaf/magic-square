package com.sitajaf.generators;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StracheyGeneratorTest {
    StracheyGenerator stracheyGenerator;

    @Before
    public void setUp() throws Exception {
        stracheyGenerator = new StracheyGenerator();
    }

    @Test
    public void shouldReturnSquareOfOrder6() throws Exception {
        int[][] expectedSquare = {
                {35, 1, 6, 26, 19, 24},
                {3, 32, 7, 21, 23, 25},
                {31, 9, 2, 22, 27, 20},
                {8, 28, 33, 17, 10, 15},
                {30, 5, 34, 12, 14, 16},
                {4, 36, 29, 13, 18, 11}
        };
        assertThat(stracheyGenerator.get(6), is(expectedSquare));
    }

    @Test
    public void shouldReturnSquareOfOrder10() throws Exception {
        int[][] expectedSquare = {
                {92, 99, 1, 8, 15, 67, 74, 51, 58, 40},
                {98, 80, 7, 14, 16, 73, 55, 57, 64, 41},
                {4, 81, 88, 20, 22, 54, 56, 63, 70, 47},
                {85, 87, 19, 21, 3, 60, 62, 69, 71, 28},
                {86, 93, 25, 2, 9, 61, 68, 75, 52, 34},
                {17, 24, 76, 83, 90, 42, 49, 26, 33, 65},
                {23, 5, 82, 89, 91, 48, 30, 32, 39, 66},
                {79, 6, 13, 95, 97, 29, 31, 38, 45, 72},
                {10, 12, 94, 96, 78, 35, 37, 44, 46, 53},
                {11, 18, 100, 77, 84, 36, 43, 50, 27, 59}
        };
        assertThat(stracheyGenerator.get(10), is(expectedSquare));
    }
}
