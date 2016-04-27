package com.sitajaf;

import com.sitajaf.exceptions.MagicSquareException;
import com.sitajaf.generators.SiameseGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MagicSquareGeneratorTest {
    private MagicSquareGenerator magicSquareGenerator;

    private SiameseGenerator mockSiameseGenerator = mock(SiameseGenerator.class);

    @Before
    public void setUp() throws Exception {
        magicSquareGenerator = new MagicSquareGenerator(mockSiameseGenerator);
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
        magicSquareGenerator.generate(0);
    }

    @Test(expected = MagicSquareException.class)
    public void shouldNotReturnMagicSquareOfNegativeNumbers() throws Exception {
        magicSquareGenerator.generate(-5);
    }

    @Test
    public void shouldUseSiameseGeneratorForOrder3() throws Exception {
        magicSquareGenerator.generate(3);

        verify(mockSiameseGenerator).get(3);
    }

    @Test
    public void shouldUseSiameseGeneratorForOrder91() throws Exception {
        magicSquareGenerator.generate(91);

        verify(mockSiameseGenerator).get(91);
    }

    @Test
    public void shouldReturnMagicSquareOfOrder67() throws Exception {
        magicSquareGenerator.generate(67);

        verify(mockSiameseGenerator).get(67);
    }


}
