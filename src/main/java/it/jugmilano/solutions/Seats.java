package it.jugmilano.solutions;

public class Seats {

    public int arrangePeople(String input) {

        int n = (int) input.chars().filter(ch -> ch =='x').count();

        int max = 0;
        int maxInWindow = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'x') {
                maxInWindow++;
            }
            if (i >= n && input.charAt(i - n) == 'x') {
                maxInWindow--;
            }

            max = Math.max(max, maxInWindow);
        }

        return n - max;
    }

}
