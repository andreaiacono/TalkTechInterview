package it.jugmilano.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairSum {


    /**
     * brute force approach
     * Time: O(n^2)
     * Space: O(1)
     */
    static int[] pairSum(int[] n, int sum) {

        int[] result = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[i] + n[j] == sum) {
                    if (n[i] < n[j] && n[i] < result[0]) {
                        result = new int[]{n[i], n[j]};
                    }
                    else if (n[i] > n[j] && n[j] < result[0]) {
                        result = new int[]{n[j], n[i]};
                    }
                }
            }
        }

        if (result[0] < Integer.MAX_VALUE && result[1] < Integer.MAX_VALUE) {
            return result;
        }
        return new int[] {};
    }

    /**
     * faster with no additional space
     * Time: O(n log n)
     * Space: O(1)
     */
    static int[] pairSumSlim(int[] n, int sum) {

        Arrays.sort(n);
        int left = 0;
        int right = n.length - 1;

        while (left < right) {
            int currentSum = n[left] + n[right];
            if (currentSum == sum) {
                return new int[]{n[left], n[right]};
            }

            if (currentSum < sum) {
                left++;
            }
            else {
                right--;
            }
        }
        return new int[] {};
    }

    /**
     * even faster but with increased space complexity
     * Time: O(n)
     * Space: O(n)
     */
    static int[] pairSumFast(int[] n, int sum) {

        Map<Integer, Integer> complements = new HashMap<>();
        int[] min = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

        // first puts the complements of the sum and the values into a map
        for (int i = 0; i < n.length; i++) {

            if (complements.containsKey(n[i])) {
                int[] result = n[i] < sum - n[i] ? new int[]{n[i], sum - n[i]} : new int[]{sum - n[i], n[i]};
                if (result[0] < min[0]) {
                    min = result;
                }
            }
            complements.put(sum - n[i], i);
        }

        if (min[0] < Integer.MAX_VALUE && min[1] < Integer.MAX_VALUE) {
            return min;
        }

        return new int[]{};
    }

}
