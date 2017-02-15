package it.jugmilano.problems;

import it.jugmilano.GenericThreadRunner;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.concurrent.Callable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TripleStepTest {

    static boolean isCorrect = true;

    @Before
    public void beforeMethod() {
        org.junit.Assume.assumeTrue(isCorrect);
    }

    @Test
    public void accuracy() {
        isCorrect = false;
        assertEquals(1, TripleStep.tripleSteps(1));
        assertEquals(2, TripleStep.tripleSteps(2));
        assertEquals(4, TripleStep.tripleSteps(3));
        assertEquals(7, TripleStep.tripleSteps(4));
        assertEquals(13, TripleStep.tripleSteps(5));
        isCorrect = true;
    }

    @Test
    public void efficiency() {

        Callable<Boolean> callable = () -> TripleStep.tripleSteps(40) == 23_837_527_729L;
        GenericThreadRunner runner = new GenericThreadRunner(callable, 500);
        String result = runner.runExecutor();

        if (result != null) {
            fail(result);
        }
    }



}