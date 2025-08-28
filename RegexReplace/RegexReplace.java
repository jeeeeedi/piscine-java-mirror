public class RegexReplace {
    public static String removeUnits(String s) {
        if (s == null) return null;
        // Remove 'cm' or '€' directly following a number when followed by a space or end of string
        // Examples to match: 15323cm, 15323cm et, 15323€ , 15323€et(not), 15323€ et
        // We only remove when the unit immediately follows a digit and is followed by a whitespace or end
        return s.replaceAll("(?<=\\d)(?:cm|€)(?=(?:\\s|$))", "");
    }
    
    public static String obfuscateEmail(String s) {
        if (s == null || !s.contains("@")) return s;
        String[] parts = s.split("@", 2);
        String user = parts[0];
        String domain = parts[1];

        // Username obfuscation
        String obfuscatedUser;
        int sepIndex = -1;
        for (char sep : new char[]{'-', '.', '_'}) {
            int idx = user.indexOf(sep);
            if (idx != -1 && (sepIndex == -1 || idx < sepIndex)) {
                sepIndex = idx; // first occurring separator
            }
        }
        if (sepIndex != -1) {
            // keep everything up to and including the first separator, star out the rest
            String prefix = user.substring(0, sepIndex + 1);
            String rest = user.substring(sepIndex + 1);
            obfuscatedUser = prefix + (rest.isEmpty() ? "" : repeat('*', rest.length()));
        } else {
            if (user.length() > 3) {
                // keep first 3 chars, hide up to last 3 chars (or remaining) with *
                int stars = Math.min(3, user.length() - 3);
                obfuscatedUser = user.substring(0, 3) + repeat('*', stars);
            } else {
                obfuscatedUser = user; // nothing to hide
            }
        }

        // Domain obfuscation
        String obfuscatedDomain;
        String[] labels = domain.split("\\.");
        if (labels.length == 3) {
            // third.second.top -> hide third and top, keep second
            obfuscatedDomain = repeat('*', labels[0].length()) + "." + labels[1] + "." + repeat('*', labels[2].length());
        } else if (labels.length == 2) {
            String second = labels[0];
            String top = labels[1];
            if (top.equals("com") || top.equals("org") || top.equals("net")) {
                obfuscatedDomain = repeat('*', second.length()) + "." + top;
            } else {
                obfuscatedDomain = repeat('*', second.length()) + "." + repeat('*', top.length());
            }
        } else {
            // Fallback: star out everything except keep dots structure
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < labels.length; i++) {
                if (i > 0) b.append('.');
                b.append(repeat('*', labels[i].length()));
            }
            obfuscatedDomain = b.toString();
        }

        return obfuscatedUser + "@" + obfuscatedDomain;
    }

    private static String repeat(char c, int count) {
        if (count <= 0) return "";
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) sb.append(c);
        return sb.toString();
    }
}