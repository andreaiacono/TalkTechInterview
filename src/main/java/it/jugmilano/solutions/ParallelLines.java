package it.jugmilano.solutions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  Given a set of points in a cartesian plane, find the maximum number of parallel lines passing
 *  from every couple of points
 */
public class ParallelLines {

    static public int findMaxParallelsCorrect(double[] x, double[] y) {

        if (x == null || y == null || x.length == 0 || y.length == 0) {
            return 0;
        }

        Set<Pair> pairs = getPairs(x, y);
        Map<Slope, Integer> slopes = new HashMap<>();
        int max = 0;
        for (Pair pair : pairs) {
            double slopeVal = pair.x2 - pair.x1 != 0
                    ? (pair.y2 - pair.y1) / (pair.x2 - pair.x1) : Double.POSITIVE_INFINITY;
            Slope slope = new Slope(slopeVal);

            int value = 1;
            if (slopes.containsKey(slope)) {
                value += slopes.get(slope);
            }
            max = Math.max(max, value);
            slopes.put(slope, value);
        }

        return max;
    }

    static class Slope {
        double value;
        final int DIGITS = 10;
        final double DELTA = 1/(double) DIGITS;

        public Slope(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            Slope other = (Slope) o;
            return Math.abs(this.value - other.value) < DELTA;
        }

        @Override
        public int hashCode() {
            return new Double(BigDecimal.valueOf(value).setScale(DIGITS, RoundingMode.HALF_UP).doubleValue()).hashCode();
        }
    }

    static private Set<Pair> getPairs(double[] x, double[] y) {
        Set<Pair> pairs = new HashSet<>();
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                pairs.add(new Pair(x[i], y[i], x[j], y[j]));
            }
        }
        return pairs;
    }


    static class Pair {
        final double x1;
        final double y1;
        final double x2;
        final double y2;

        public Pair(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public String toString() {
            return "[(" + x1 + "," + y1 + ")(" + x2 + "," + y2 + ")]";
        }
    }

}
