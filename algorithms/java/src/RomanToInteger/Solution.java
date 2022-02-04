package RomanToInteger;

class Solution {
    public static int getInt(char c) {
        int num = 0;
        switch (c) {
            case 'I' -> num = 1;
            case 'V' -> num = 5;
            case 'X' -> num = 10;
            case 'L' -> num = 50;
            case 'C' -> num = 100;
            case 'D' -> num = 500;
            case 'M' -> num = 1000;
        }
        return num;
    }

    public static int romanToInt(String s) {
        if (s.length() == 1) {
            return getInt(s.charAt(0));
        }

        int sum = 0;
        char prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'I') {
                if (prev == 'V' || prev == 'X') {
                    sum -= 1;
                    prev = s.charAt(i);
                    continue;
                }
            }
            else if (s.charAt(i) == 'X') {
                if (prev == 'L' || prev == 'C') {
                    sum -= 10;
                    prev = s.charAt(i);
                    continue;
                }
            }
            else if (s.charAt(i) == 'C') {
                if (prev == 'D' || prev == 'M') {
                    sum -= 100;
                    prev = s.charAt(i);
                    continue;
                }
            }
            prev = s.charAt(i);
            sum += getInt(s.charAt(i));
        }
        return sum;
    }
}