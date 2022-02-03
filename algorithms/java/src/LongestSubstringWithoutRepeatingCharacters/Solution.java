package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!map.containsKey(c)) {
                    map.put(c, i);
                } else {
                    break;
                }
            }

            if (map.size() > length) {
                length = map.size();
            }
        }
        return length;
    }
}