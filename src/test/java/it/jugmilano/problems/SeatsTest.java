package it.jugmilano.problems;

import it.jugmilano.GenericThreadRunner;
import org.junit.Assume;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.concurrent.Callable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeatsTest {

    static boolean isCorrect = true;

    @Before
    public void beforeMethod() {
        Assume.assumeTrue(isCorrect);
    }

    @Test
    public void correctness() throws Exception {

        isCorrect = false;

        String row = "xxx.xxx";
        assertEquals(1, Seats.arrangePeople(row));

        row = "xxxxxx";
        assertEquals(0, Seats.arrangePeople(row));

        row = "....xxx....";
        assertEquals(0, Seats.arrangePeople(row));

        row = "....x..xx...x..";
        assertEquals(2, Seats.arrangePeople(row));

        row = "xx..x.......x..";
        assertEquals(2, Seats.arrangePeople(row));

        row = "....x.....xx..x";
        assertEquals(2, Seats.arrangePeople(row));

        row = "x...x...x...x";
        assertEquals(3, Seats.arrangePeople(row));

        row = "x...x";
        assertEquals(1, Seats.arrangePeople(row));

        isCorrect = true;
    }


    @Test
    public void efficiency() throws Exception {

        final int SIZE = 200_000;
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            input.append((i % 2 == 0)  ? '.' : 'x');
        }

        Callable<Boolean> callable = () -> Seats.arrangePeople(input.toString()) == SIZE/4;
        GenericThreadRunner runner = new GenericThreadRunner(callable, 800);
        String result = runner.runExecutor();

        if (result != null) {
            fail(result);
        }
    }
}
