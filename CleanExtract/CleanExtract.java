public class CleanExtract {
    public static String extract(String s) {
        if (s == null || s.isEmpty()) return "";
        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String trimmed = parts[i].trim();
            int firstDot = trimmed.indexOf('.');
            int lastDot = trimmed.lastIndexOf('.');
            if (firstDot != -1 && lastDot != -1 && firstDot != lastDot) {
                String between = trimmed.substring(firstDot + 1, lastDot).trim();
                if (!between.isEmpty()) {
                    if (result.length() > 0) result.append(" ");
                    result.append(between);
                }
            } else if (!trimmed.isEmpty()) {
                if (result.length() > 0) result.append(" ");
                result.append(trimmed);
            }
        }
        return result.toString();
    }
}