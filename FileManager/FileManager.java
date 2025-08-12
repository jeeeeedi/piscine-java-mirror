public class FileManager {
    public static void createFile(String fileName, String content) throws java.io.IOException {
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.write(content);
        }
    }

    public static String getContentFile(String fileName) throws java.io.IOException {
        StringBuilder sb = new StringBuilder();
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        // Remove the last line separator if present
        if (sb.length() > 0) {
            sb.setLength(sb.length() - System.lineSeparator().length());
        }
        return sb.toString();
    }

    public static void deleteFile(String fileName) {
        java.io.File file = new java.io.File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}