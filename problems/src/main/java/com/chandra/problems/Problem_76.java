package com.chandra.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 Example:

 Input: S = "ADOBECODEBANC", T = "ABC"
 Output: "BANC"

 Note:

 If there is no such window in S that covers all characters in T, return the empty string "".
 If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Problem_76 {
    public static class Solution_1 {
        public String minWindow(String s, String t) {
            String res = "";
            if (s == null || t == null || s.length() == 0 || t.length() == 0) return res;
            HashMap<Character, Integer> freqMap = new HashMap<>();

            for (int i = 0; i < t.length(); i++) {
                freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) + 1);
            }

            int left = 0, right = 0;
            int minLeft = 0;
            int minLen = Integer.MAX_VALUE;
            int count = freqMap.size();
            while (right < s.length()) {
                char c = s.charAt(right++); // keep expanding the sliding window in S till we have all chars of T in sliding window
                if (freqMap.containsKey(c)) {
                    freqMap.put(c, freqMap.get(c) - 1);
                    if (freqMap.get(c) == 0) count--; // keep a counter to check the characters of T present in S
                }

                while (count == 0) { // when we parse all the characters of T present in S, then
                    if (right - left < minLen) { // check if the current substring len is minimum, if yes
                        minLeft = left; // store left pointer
                        minLen = right - left; // store the min length
                    }

                    char c1 = s.charAt(left++); // shrink the sliding window from left to proceed further to parse other chars in S
                    if (freqMap.containsKey(c1)) { // when shrinking we care about only chars common in S & T
                        freqMap.put(c1, freqMap.get(c1) + 1); // since we are shrinking from left, we update the freq map to reflect T chars present in sliding window
                        if (freqMap.get(c1) > 0) count++; // also increment the counter to track the number of T chars being present in sliding window so far
                    }
                }
            }

            return minLen > s.length() ? res : s.substring(minLeft, minLeft + minLen); // if there's no substring with T chars, then return empty string or return the  minimum length substring
        }
    }

    public static class Solution_2 {
        public String minWindow(String s, String t) {
            //init a collection or int value to save the result according the question.
            String result = "";
            if(s == null || t == null || s.length() == 0 || t.length() == 0 || t.length()> s.length()) return result;

            //create a hashmap to save the Characters of the target substring.
            //(K, V) = (Character, Frequence of the Characters)
            Map<Character, Integer> map = new HashMap<>();
            for(char c : t.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            //maintain a counter to check whether match the target string.
            int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.

            //Two Pointers: begin - left pointer of the window; end - right pointer of the window
            int begin = 0, end = 0;

            //the length of the substring which match the target string.
            int len = Integer.MAX_VALUE;

            //loop at the begining of the source string
            while(end < s.length()){

                char c = s.charAt(end);//get a character

                if( map.containsKey(c) ){
                    map.put(c, map.get(c)-1);// plus or minus one
                    if(map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
                }
                end++;

                //increase begin pointer to make it invalid/valid again
                while(counter == 0 /* counter condition. different question may have different condition */){

                    char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                    if(map.containsKey(tempc)){
                        map.put(tempc, map.get(tempc) + 1);//plus or minus one
                        if(map.get(tempc) > 0) counter++;//modify the counter according the requirement(different condition).
                    }

                    /* save / update(min/max) the result if find a target*/
                    // result collections or result int value

                    begin++;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";

        System.out.println(new Problem_76.Solution_1().minWindow(S, T));
    }
}
