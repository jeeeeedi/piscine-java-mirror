public class FileSearch {
    public static String searchFile(String fileName) {
        java.io.File root = new java.io.File("documents");
        String result = searchRecursive(root, fileName, "documents");
        return result;
    }

    private static String searchRecursive(java.io.File dir, String fileName, String relativePath) {
        if (dir == null || !dir.exists() || !dir.isDirectory()) {
            return null;
        }
        java.io.File[] files = dir.listFiles();
        if (files == null)
            return null;
        for (java.io.File file : files) {
            if (file.isDirectory()) {
                String found = searchRecursive(file, fileName, relativePath + "/" + file.getName());
                if (found != null)
                    return found;
            } else if (file.getName().equals(fileName)) {
                return relativePath + "/" + file.getName();
            }
        }
        return null;
    }
}