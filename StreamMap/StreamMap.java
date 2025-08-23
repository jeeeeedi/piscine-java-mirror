import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    public static Integer sumOfStringLength(Stream<String> s) {
        if (s == null) return 0;
        return s.filter(str -> str != null)
                .mapToInt(String::length)
                .sum();
    }

    public static List<String> upperCaseAllString(Stream<String> s) {
        if (s == null) return List.of();
        return s.filter(str -> str != null)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
    
    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        if (s == null) return Set.of();
        return s.filter(d -> d != null && d > 42)
                .map(Double::intValue)
                .collect(Collectors.toSet());
    }
}