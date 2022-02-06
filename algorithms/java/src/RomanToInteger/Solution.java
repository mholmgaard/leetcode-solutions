package RomanToInteger;

class Solution {
    public int getInt(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException("No such roman numeral.");
        };
    }

    public int romanToInt(String s) {
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