package it.jugmilano.solutions;

public class TripleSteps {


    /**
     * recursive approach (won't pass efficiency test)
     */
    static long tripleSteps(int steps) {

        if (steps < 4) {
            switch (steps) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 4;
                default:
                    return -1;
            }
        }

        return tripleSteps(steps-1) + tripleSteps(steps-2) + tripleSteps(steps-3);
    }

    /**
     * dynamic programming approach with array
     * Time: O(n)
     * Space: O(n)
     */
    static long tripleStepsWithArray(int steps) {

        long[] partials = new long[Math.max(4, steps + 1)];
        partials[1] = 1;
        partials[2] = 2;
        partials[3] = 4;
        for (int i = 4; i <= steps; i++) {
            partials[i] = partials[i - 1] + partials[i - 2] + partials[i - 3];
        }

        return partials[steps];
    }

    /**
     * dynamic programming approach without array
     * Time: O(n)
     * Space: O(1)
     */
    static long tripleStepsSlim(int steps) {

        if (steps < 4) {
            switch (steps) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 4;
                default:
                    return -1;
            }
        }

        long first = 1;
        long second = 2;
        long third = 4;
        int n = 3;
        while (n < steps) {
            long newValue = first + second + third;
            first = second;
            second = third;
            third = newValue;
            n++;
        }
        return third;
    }
}
