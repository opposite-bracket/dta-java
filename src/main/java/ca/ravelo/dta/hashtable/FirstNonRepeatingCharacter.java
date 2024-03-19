package ca.ravelo.dta.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * You have been given a string of lowercase letters.
 *
 * Write a function called firstNonRepeatingChar(String) that finds the first non-repeating character in the
 * given string using a hash table (HashMap). If there is no non-repeating character in the string,
 * the function should return null.
 *
 * For example, if the input string is "leetcode", the function should return "l" because "l" is the first
 * character that appears only once in the string. Similarly, if the input string is "hello", the function
 * should return "h" because "h" is the first non-repeating character in the string.
 *
 * Return type: Character
 */
public class FirstNonRepeatingCharacter {
    static public Character firstNonRepeatingChar(String l) {

        Map<Character, Integer> lc = new HashMap();

        for (Character c : l.toCharArray()) {
            if (!lc.containsKey(c)) {
                lc.put(c, 0);
            } else {
                lc.put(c, lc.get(c) + 1);
            }
        }

        for (Character c : l.toCharArray()) {
            if (lc.get(c) == 0) {
                return c;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */

    }

}
