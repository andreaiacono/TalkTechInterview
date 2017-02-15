package it.jugmilano.problems;

import it.jugmilano.GenericThreadRunner;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.concurrent.Callable;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PairSumTest {

    static boolean isCorrect = true;

    @Before
    public void beforeMethod() {
        org.junit.Assume.assumeTrue(isCorrect);
    }

    @Test
    public void correctness() throws Exception {

        isCorrect = false;

        int[] result = PairSum.pairSum(new int[]{}, 0);
        assertNotNull(result);
        assertEquals(0, result.length);

        int[] input = new int[]{2, 3, 4, 5, 6, 7};
        int sum = 8;
        int[] expected = new int[]{2, 6};
        result = PairSum.pairSum(input, sum);
        assertNotNull(result);
        assertEquals(expected.length, result.length);
        assertTrue(Arrays.equals(expected, result));
        assertEquals(sum, result[0] + result[1]);

        input = new int[]{0, 25, 0, 0, 0, 10, 0};
        sum = 35;
        expected = new int[]{10, 25};
        result = PairSum.pairSum(input, sum);
        assertNotNull(result);
        assertEquals(expected.length, result.length);
        assertTrue(Arrays.equals(expected, result));
        assertEquals(sum, result[0] + result[1]);

        input = new int[]{1, 1, 12, 2, 0, -1, -10};
        sum = 2;
        expected = new int[]{-10, 12};
        result = PairSum.pairSum(input, sum);
        assertNotNull(result);
        assertEquals(expected.length, result.length);
        assertTrue(Arrays.equals(expected, result));
        assertEquals(sum, result[0] + result[1]);

        isCorrect = true;
    }


    @Test
    public void efficiency() throws Exception {

        final int SIZE = 250_000;
        int[] input = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            input[i] = i + 1;
        }
        int sum = SIZE + SIZE-1;
        final boolean[] failed = {false};

        Callable<Boolean> callable = () -> Arrays.equals(PairSum.pairSum(input, sum), new int[]{SIZE-1, SIZE});
        GenericThreadRunner runner = new GenericThreadRunner(callable, 800);
        String result = runner.runExecutor();

        if (result != null) {
            fail(result);
        }
    }
}