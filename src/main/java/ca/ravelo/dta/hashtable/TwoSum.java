package ca.ravelo.dta.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Given an array of integers nums and a target integer target, find the indices of two numbers
 * in the array that add up to the target.
 *
 * Input:
 *
 * An array of integers nums .
 *
 * A target integer target.
 *
 * Output:
 *
 * An array of two integers representing the indices of the two numbers in the input array nums
 * that add up to the target. If no two numbers in the input array add up to the target, return an empty array [].
 *
 * Return type:
 *
 * int[]
 *
 *
 *
 * Example:
 *
 *
 *
 * Input: int[] nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * Explanation: The numbers at indices 0 and 1 in the array add up to the target 9.
 *
 * Input: int[] nums = [3, 2, 4], target = 6
 * Output: [1, 2]
 * Explanation: The numbers at indices 1 and 2 in the array add up to the target 6.
 *
 * Input: int[] nums = [3, 3], target = 6
 * Output: [0, 1]
 * Explanation: The numbers at indices 0 and 1 in the array add up to the target 6.
 *
 * Input: int[] nums = [1, 2, 3, 4, 5], target = 10
 * Output: []
 * Explanation: There are no two numbers in the array add up to the target 10.
 *
 * Input: int[] nums = [], target = 0
 * Output: []
 * Explanation: There are no numbers in the input array, so the function returns an empty array [].
 */
public class TwoSum {

    // WRITE THE TWOSUM MEHTOD HERE //
    public static int[] twoSum(int[] ints, int target) {
        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < ints.length; i++) {
            int currentValue = ints[i];
            int complement = target - currentValue;

            if (complements.containsKey(complement)) {
                return new int[]{complements.get(complement), i};
            }

            complements.put(currentValue, i);
        }

        return new int[]{};
    }
    //////////////////////////////////


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [0, 1]
            [1, 2]
            [0, 1]
            []
            [2, 3]
            [0, 1]
            []

        */

    }
}
