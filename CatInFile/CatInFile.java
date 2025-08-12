import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Output file name required");
        }
        String outputFile = args[0];
        try (
            InputStream in = System.in;
            OutputStream out = new FileOutputStream(outputFile)
        ) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}