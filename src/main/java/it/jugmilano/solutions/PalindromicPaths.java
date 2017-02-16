package it.jugmilano.solutions;

/**
 *
 */
public class PalindromicPaths {


    static int countPaths(char[][] mat) {
        return countPaths(mat, 0, 0, "");
    }

    static int countPaths(char[][] mat, int r, int c, String path) {
        path += mat[r][c];

        // goal
        if (r==mat.length-1 && c == mat[0].length-1) {
            return isPalindrome(path) ? 1 : 0;
        }

        int total = 0;
        if (r+1 < mat.length) {
            total += countPaths(mat, r+1, c, path);
        }

        if (c+1 < mat[0].length) {
            total += countPaths(mat, r, c+1, path);
        }

        return total;
    }

    private static boolean isPalindrome(String path) {
        return false;
    }
}
