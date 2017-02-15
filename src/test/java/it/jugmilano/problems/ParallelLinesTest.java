package it.jugmilano.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParallelLinesTest {

    @Test
    public void shouldManageEdgeCases() throws Exception {

        // tests null input
        int result = ParallelLines.findMaxParallels(null, null);
        assertNotNull(result);
        assertEquals(0, result);

        // tests empty input
        result = ParallelLines.findMaxParallels(new double[]{}, new double[]{});
        assertNotNull(result);
        assertEquals(0, result);
    }

    @Test
    public void shouldManageVerticalLines() throws Exception {

        double[] x = new double[]{2, 2};
        double[] y = new double[]{0, 1};
        int result = ParallelLines.findMaxParallels(x, y);
        assertEquals(1, result);
    }

    @Test
    public void shouldFindOne() throws Exception {

        double[] x = new double[]{1, 2, 6, -1};
        double[] y = new double[]{2, 4, 10, 5};
        int result = ParallelLines.findMaxParallels(x, y);
        assertEquals(1, result);
    }

    @Test
    public void shouldManageSlopesCorrectly() throws Exception {

        double[] x = new double[]{0.2, 0.9, 0.6};
        double[] y = new double[]{0.02, 0.16, 0.1};
        int result = ParallelLines.findMaxParallels(x, y);
        assertEquals(3, result);
    }

}
