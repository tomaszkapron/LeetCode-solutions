package leetCode;

public class PalindromNumber {
    public static void main(String[] args) {
        System.out.println(PalindromNumber.isPalindrome3(10));
    }

    static public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String reveresed = new StringBuffer(s).reverse().toString();
        return s.equals(reveresed);
    }

    static public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int[] digits = Integer.toString(x).chars().map(c -> c - '0').toArray();
        int halfLength = digits.length / 2;
        for (int i = 0; i <= halfLength; i++) {
            if (digits[i] != digits[digits.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    static public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int len = getIntLen(x);
        int halfLen = len / 2;
        int reversedHalf = 0;
        for (int i = 0; i < halfLen; i++) {
            reversedHalf += (x % 10) * Math.pow(10, halfLen - i - 1);
            x /= 10;
        }
        return len % 2 == 0 ? x == reversedHalf : x / 10 == reversedHalf;
    }

    static int getIntLen(int x) {
        int length = 0;
        long temp = 1;
        while (temp <= x) {
            length++;
            temp *= 10;
        }
        return length;
    }
}
