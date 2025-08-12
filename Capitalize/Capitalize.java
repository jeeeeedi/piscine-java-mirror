import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Input and output file names required");
        }
        String inputFile = args[0];
        String outputFile = args[1];
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(' ');
            }
        }
        String cleaned = sb.toString().trim().replaceAll("\\s+", " ");
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        for (char c : cleaned.toCharArray()) {
            if (Character.isWhitespace(c)) {
                result.append(c);
                capitalizeNext = true;
            } else if (capitalizeNext) {
                result.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(result.toString());
        }
    }
}