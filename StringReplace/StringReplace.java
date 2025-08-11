public class StringReplace {
    public static String replace(String s, String target, String replacement) {
        if (s == null || target == null || replacement == null) {
            return s;
        }
        return s.replace(target, replacement);
    }

    public static String replace(String s, char target, char replacement) {
        return replace(s, String.valueOf(target), String.valueOf(replacement));
    }
}