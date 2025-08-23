import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null || value == null || !list.contains(value))
            return null;
        return list.lastIndexOf(value);
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null || list.isEmpty() || value == null || !list.contains(value))
            return null;
        return list.indexOf(value);
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        if (list == null || list.isEmpty() || value == null || !list.contains(value))
            return new ArrayList<>();
        if (!list.contains(value))
            return new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}