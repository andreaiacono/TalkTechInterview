package it.jugmilano.problems;

/**
 * Given a row of N seats with a group of people who are seated in the row randomly,
 * which is the minimum number of people who have to change seat for grouping all together
 * (without any empty seat in between them)?
 * <p>
 * For example:
 * given the row "....x..xx...x.."  (where an 'x' is a person and a '.' is an empty seat)
 * the minimum number of people to move is 2. One of the possible solutions is:
 * - Person moves from index 4 to index 6
 * - Person moves from index 12 to index 9
 * <p>
 * Another possible solution is:
 * - Person moves from index 12 to index 5
 * - Person moves from index 8 to index 6
 * <p>
 * They both use 2 moves to group the people.
 */
public class Seats {

    /**
     * the minimum number of seat changes to group all the people together
     *
     * @param input uses a '.' for an empty seat and an 'x' for an occupied seat
     * @return the number of changes
     */
    public static int arrangePeople(String input) {

        return -1;
    }

}
