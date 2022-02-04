package PalindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int result = 0;
        while (x > result) {
            int move = x % 10;
            x /= 10;
            result = (result * 10) + move;
        }
        return result == x || x == result / 10;
    }
}