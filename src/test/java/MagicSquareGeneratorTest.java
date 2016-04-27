import com.sitajaf.MagicSquareGenerator;
import com.sitajaf.exceptions.MagicSquareException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MagicSquareGeneratorTest {
    private MagicSquareGenerator magicSquareGenerator;

    @Before
    public void setUp() throws Exception {
        magicSquareGenerator = new MagicSquareGenerator();
    }

    @Test
    public void shouldReturnMagicSquareOfOrder1() throws Exception {
        int[][] expectedValues = {{1}};
        assertThat(magicSquareGenerator.generate(1), is(expectedValues));
    }

    @Test(expected = MagicSquareException.class)
    public void shouldNotReturnMagicSquareOfOrder2() throws Exception {
        magicSquareGenerator.generate(2);
    }

    @Test(expected = MagicSquareException.class)
    public void shouldNotReturnMagicSquareOfOrderZero() throws Exception {
        magicSquareGenerator.generate(-5);
    }

    @Test(expected = MagicSquareException.class)
    public void shouldNotReturnMagicSquareOfNegativeNumbers() throws Exception {
        magicSquareGenerator.generate(-5);
    }

    @Test
    public void shouldReturnMagicSquareOfOrder3() throws Exception {
        int[][] expectedSquare = {
                {8, 1, 6},
                {3, 5, 7},
                {4, 9, 2}
        };
        assertThat(magicSquareGenerator.generate(3), is(expectedSquare));
    }

    @Test
    public void shouldReturnMagicSquareOfOrder5() throws Exception {
        int[][] expectedSquare = {
                {17, 24, 1, 8, 15},
                {23, 5, 7, 14, 16},
                {4, 6, 13, 20, 22},
                {10, 12, 19, 21, 3},
                {11, 18, 25, 2, 9}
        };
        assertThat(magicSquareGenerator.generate(5), is(expectedSquare));
    }

    @Test
    public void shouldReturnMagicSquareOfOrder9() throws Exception {
        int[][] expectedSquare = {
                {47, 58, 69, 80, 1, 12, 23, 34, 45},
                {57, 68, 79, 9, 11, 22, 33, 44, 46},
                {67, 78, 8, 10, 21, 32, 43, 54, 56},
                {77, 7, 18, 20, 31, 42, 53, 55, 66},
                {6, 17, 19, 30, 41, 52, 63, 65, 76},
                {16, 27, 29, 40, 51, 62, 64, 75, 5},
                {26, 28, 39, 50, 61, 72, 74, 4, 15},
                {36, 38, 49, 60, 71, 73, 3, 14, 25},
                {37, 48, 59, 70, 81, 2, 13, 24, 35}
        };
        assertThat(magicSquareGenerator.generate(9), is(expectedSquare));
    }

    @Test
    public void shouldReturnCorrectMagicSquareOfOrder17() throws Exception {
        int[][] square = magicSquareGenerator.generate(17);
        int expectedMagicNumber = (17*(17*17+1))/2;    // = 2465 ~> ((order(order*order + 1)/2)
        int sumOfRows = square[0][0] + square[0][1] + square[0][2] + square[0][3] + square[0][4] +
                square[0][5] + square[0][6] + square[0][7] + square[0][8] + square[0][9] +
                square[0][10] + square[0][11] + square[0][12] + square[0][13] + square[0][14] +
                square[0][15] + square[0][16];
        
        int sumOfColumns = square[0][0] + square[1][0] + square[2][0] + square[3][0] + square[4][0] +
                square[5][0] + square[6][0] + square[7][0] + square[8][0] + square[9][0] +
                square[10][0] + square[11][0] + square[12][0] + square[13][0] + square[14][0] +
                square[15][0] + square[16][0];

        int sumOfDiagonal = square[0][0] + square[1][1] + square[2][2] + square[3][3] + square[4][4] +
                square[5][5] + square[6][6] + square[7][7] + square[8][8] + square[9][9] +
                square[10][10] + square[11][11] + square[12][12] + square[13][13] + square[14][14] +
                square[15][15] + square[16][16];

        assertThat(sumOfRows, is(expectedMagicNumber));
        assertThat(sumOfColumns, is(expectedMagicNumber));
        assertThat(sumOfDiagonal, is(expectedMagicNumber));
    }


}
