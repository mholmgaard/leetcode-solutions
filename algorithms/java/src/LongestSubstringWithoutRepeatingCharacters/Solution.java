package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!set.contains(c)) {
                    set.add(c);
                } else {
                    break;
                }
            }

            if (set.size() > length) {
                length = set.size();
            }
        }
        return length;
    }
}