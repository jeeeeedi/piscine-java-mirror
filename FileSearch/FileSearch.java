public class FileSearch {
    public static String searchFile(String fileName) {
        java.io.File root = new java.io.File("documents");
        String result = searchRecursive(root, fileName);
        return result;
    }

    private static String searchRecursive(java.io.File dir, String fileName) {
        if (dir == null || !dir.exists() || !dir.isDirectory()) {
            return null;
        }
        java.io.File[] files = dir.listFiles();
        if (files == null) return null;
        for (java.io.File file : files) {
            if (file.isDirectory()) {
                String found = searchRecursive(file, fileName);
                if (found != null) return found;
            } else if (file.getName().equals(fileName)) {
                return file.getAbsolutePath();
            }
        }
        return null;
    }
}