package it.jugmilano.problems;

/**
 * Given a matrix containing lower alphabetical characters only, we need to count number of palindromic paths in given
 * matrix. A path is defined as a sequence of cells starting from top-left cell and ending at bottom-right cell. We
 * are allowed to move to right and down only from current cell.
 *
 * Given the matrix:
 *  a  a  a  b
 *  b  a  a  a
 *  a  b  b  a
 *
 *  there are three palindromic paths from top-left cell to bottom-right cell (the '.' are cells on the path followed):
 *  1)  .  .  .  b
 *      b  a  .  .      Path = aaaaaa
 *      a  b  b  .
 *
 *  2)  .  .  a  b
 *      b  .  .  .      Path = aaaaaa
 *      a  b  b  .
 *
 *  3)  .  a  a  b
 *      .  .  .  a      Path = abaaba
 *      a  b  .  .
 *
 */
public class PalindromicPaths {

    static int countPaths(char[][] mat) {
        return -1;
    }

    static boolean isPalindrome(String path) {
        for (int i=0; i<path.length()/2; i++) {
            if (path.charAt(i) != path.charAt(path.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}
