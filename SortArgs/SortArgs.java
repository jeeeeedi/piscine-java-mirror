public class SortArgs {
    public static void sort(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println();
            return;
        }
        // Parse strings to numbers (as Double for generality)
        Double[] numbers = new Double[args.length];
        for (int i = 0; i < args.length; i++) {
            numbers[i] = Double.parseDouble(args[i]);
        }
        // Sort the numbers
        java.util.Arrays.sort(numbers);
        // Print sorted numbers as originally formatted (no trailing space, newline at end)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0) sb.append(" ");
            // Remove .0 for integer values
            if (numbers[i] == Math.floor(numbers[i]) && !Double.isInfinite(numbers[i])) {
                sb.append(String.valueOf(numbers[i].intValue()));
            } else {
                sb.append(numbers[i]);
            }
        }
        System.out.println(sb.toString());
    }
}