import com.sitajaf.MagicSquareGenerator;
import com.sitajaf.exceptions.MagicSquareException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MagicSquareGeneratorTest {
    MagicSquareGenerator magicSquareGenerator;

    @Before
    public void setUp() throws Exception {
        magicSquareGenerator = new MagicSquareGenerator();
    }

    @Test
    public void shouldName() throws Exception {
        int[][] expectedValues = {{1}};
        assertThat(magicSquareGenerator.generate(1), is(expectedValues));
    }

    @Test(expected = MagicSquareException.class)
    public void shouldNotReturnMagicSquare() throws Exception {
        magicSquareGenerator.generate(2);
    }
}
