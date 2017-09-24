import java.util.HashMap;
public class LongestSubstringNoRepeatingChar {
    /*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        //abba
        //Go through string find longest substring from beggining, if breaks then continue on from next char
        HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();
        int longestSubstring = 0;
        int currLength;
        for (int i = 0, j = 0; i < s.length(); i++) {
            //string from j to i
            if (charCounter.containsKey(s.charAt(i))) {
                j = Math.max(charCounter.get(s.charAt(i)) + 1, j);
                charCounter.put(s.charAt(i), i);
            } else {
                charCounter.put(s.charAt(i), i);
            }
            currLength = i - j + 1;//2
            longestSubstring = (currLength > longestSubstring) ? currLength : longestSubstring;//2
        }
        return longestSubstring;
    }
}