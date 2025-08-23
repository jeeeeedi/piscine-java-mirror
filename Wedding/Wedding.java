import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Wedding {
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        if (first == null || second == null || first.isEmpty() || second.isEmpty()) return Map.of();
        ArrayList<String> list1 = new ArrayList<>(first);
        ArrayList<String> list2 = new ArrayList<>(second);
        Collections.shuffle(list1);
        Collections.shuffle(list2);
        int size = Math.min(list1.size(), list2.size());
        Map<String, String> couples = new HashMap<>();
        for (int i = 0; i < size; i++) {
            couples.put(list1.get(i), list2.get(i));
        }
        return couples;
    }
}