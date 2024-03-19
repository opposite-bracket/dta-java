package ca.ravelo.dta.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function itemInCommon(array1, array2) that takes two arrays as input and returns
 * true if there is at least one common item between the two lists, false otherwise.
 * Use a HashMap to solve the problem that creates an O(n) time complexity.
 * You can learn more about HashMaps by clicking here.
 */
public class ItemInCommon {


    static public boolean itemInCommon(int[] array1, int[] array2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < array1.length; i++) {
            map.put(array1[i], array1[i]);
        }

        for(int i = 0; i < array2.length; i++) {
            if (map.containsKey(array2[i])) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));

        /*
            EXPECTED OUTPUT:
            ----------------
            true

        */

    }
}
