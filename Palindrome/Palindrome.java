public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}