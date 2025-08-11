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

/* NOTES:
No, it is not possible in Java to check the parameter type at runtime using an if statement like if (target type is char) {} when the method signature specifies String parameters. Java is statically typed, so the types must be known at compile time, and method overloading (as shown earlier) is the correct way to handle different parameter types.
You cannot write a single method that accepts both String and char types for the same parameter position and then branch based on their type inside the method. Overloading is the standard and only way to support both signatures in Java.
*/