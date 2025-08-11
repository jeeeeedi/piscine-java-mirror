public class StringContains {
    public static boolean isStringContainedIn(String subString, String s) {
        if (subString == null || s == null) {
            return false;
        } else if (s.contains(subString)) {
            return true;
        }
        return false;
    }
}