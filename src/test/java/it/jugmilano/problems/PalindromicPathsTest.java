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


@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class PalindromicPathsTest {

    static boolean isCorrect = true;

    @Before
    public void beforeMethod() {
        Assume.assumeTrue(isCorrect);
    }

    @Test
    public void correctness() {

        isCorrect = false;

        char mat[][] = new char[][]
                {
                        {'a', 'a', 'a', 'b'},
                        {'b', 'a', 'a', 'a'},
                        {'a', 'b', 'b', 'a'}
                };
        assertEquals(3, PalindromicPaths.countPaths(mat));

        mat = new char[][]
                {
                        {'a', 'b', 'c', 'd'},
                        {'e', 'f', 'g', 'h'},
                        {'i', 'j', 'k', 'l'}
                };
        assertEquals(0, PalindromicPaths.countPaths(mat));

        mat = new char[][]
                {
                        {'a', 'a', 'a'},
                        {'a', 'a', 'a'},
                        {'a', 'a', 'a'}
                };
        assertEquals(6, PalindromicPaths.countPaths(mat));

        mat = new char[][]
                {
                        {'a', 'a', 'a'},
                        {'a', 'b', 'a'},
                        {'a', 'a', 'a'}
                };
        assertEquals(6, PalindromicPaths.countPaths(mat));

        mat = new char[][]
                {
                        {'a', 'a', 'a'},
                        {'b', 'b', 'b'},
                        {'a', 'a', 'a'}
                };
        assertEquals(2, PalindromicPaths.countPaths(mat));

        mat = new char[][]
                {
                        {'a', 'a', 'a'},
                        {'b', 'b', 'b'},
                        {'b', 'b', 'b'},
                        {'a', 'a', 'a'}
                };
        assertEquals(4, PalindromicPaths.countPaths(mat));

        isCorrect = true;
    }

    @Test
    public void efficiency() throws Exception {

        final int size = 14;
        char mat[][] = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mat[i][j] = 'a';
            }
        }

        Callable<Boolean> callable = () -> PalindromicPaths.countPaths(mat) == 10400600;
        GenericThreadRunner runner = new GenericThreadRunner(callable, 2000);
        String result = runner.runExecutor();

        if (result != null) {
            fail(result);
        }
    }
}