package ca.ravelo.dta.hashtable;

import java.util.*;

/**
 * Given two integer arrays arr1 and arr2, and an integer target, write a method named findPairs that finds all
 * pairs of integers such that one integer is from arr1, the other is from arr2, and their sum equals the target value.
 *
 * The method should return a list of integer arrays, each containing a pair of integers.
 *
 *
 *
 * Method signature:
 *
 * public static List<int[]> findPairs(int[] arr1, int[] arr2, int target)
 *
 *
 * Input:
 *
 * arr1: An integer array
 *
 * arr2: An integer array
 *
 * target: An integer value
 *
 *
 *
 * Output:
 *
 * Return a list of integer arrays, where each array contains a pair of integers, one from arr1 and the other from arr2,
 * that sum up to the target value.
 *
 *
 *
 * Example:
 *
 * int[] arr1 = {1, 2, 3, 4, 5};
 * int[] arr2 = {2, 4, 6, 8, 10};
 * int target = 7;
 *
 * List<int[]> pairs = findPairs(arr1, arr2, target);
 *
 *  Expected output:
 *         [5, 2]
 *         [3, 4]
 *         [1, 6]
 *
 * In the given example, the method should return a list containing three integer arrays representing
 * the pairs of integers from arr1 and arr2 that sum up to the target value 7.
 */
public class FindPairs {


    // WRITE FINDPAIRS METHOD HERE //
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        List<int[]> pairs = new ArrayList<>();
        Set<Integer> unique = new HashSet<>();

        for (int v1 : arr1) {
            unique.add(v1);
        }

        for (int v2 : arr2) {
            int complement = target - v2;
            if (unique.contains(complement)) {
                pairs.add(new int[]{complement, v2});
            }
        }

        return pairs;
    }
    /////////////////////////////////


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        /*
            EXPECTED OUTPUT:
            ----------------
            [5, 2]
            [3, 4]
            [1, 6]

        */

    }

}
