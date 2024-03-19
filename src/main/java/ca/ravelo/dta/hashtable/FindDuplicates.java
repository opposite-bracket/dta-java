package ca.ravelo.dta.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Given an array of integers nums, find all the duplicates in the array using a hash table (HashMap).
 *
 *
 * Input:
 *
 * An array of integers nums.
 *
 *
 *
 * Return Type:
 *
 * List<Integer> implemented as an ArrayList
 *
 * List is an interface and ArrayList is a way of implementing the List interface
 *
 * For more information about interfaces click on "Hints".
 *
 *
 *
 *
 *
 *
 *
 * Input: int[] nums = [4, 3, 2, 7, 8, 2, 3, 1]
 * Output: [2, 3]
 * Explanation: The numbers 2 and 3 appear more than once in the input array.
 *
 * Input: int[] nums = [1, 2, 3, 4, 5]
 * Output: []
 * Explanation: There are no duplicates in the input array, so the function returns an empty list [].
 *
 * Input: int[] nums = [3, 3, 3, 3, 3]
 * Output: [3]
 * Explanation: The number 3 appears more than once in the input array.
 *
 * Input: int[] nums = [-1, 0, 1, 0, -1, -1, 2, 2]
 * Output: [-1, 0, 2]
 * Explanation: The numbers -1, 0, and 2 appear more than once in the input array.
 *
 * Input: int[] nums = []
 * Output: []
 * Explanation: There are no numbers in the input array, so the function returns an empty list [].
 */
public class FindDuplicates {

    static public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dups = new ArrayList();
        Map<Integer, Boolean> checked = new HashMap();
        for( int num : nums) {
            if (checked.containsKey(num)) {
                if (!dups.contains(num)) {
                    dups.add(num);
                }
                checked.put(num, true);
            } else {
                checked.put(num, false);
            }
        }

        return dups;

    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);

        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */

    }
}
