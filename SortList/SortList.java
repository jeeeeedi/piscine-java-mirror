import java.util.List;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
    if (list == null) return null;
    List<Integer> sorted = new java.util.ArrayList<>(list);
    java.util.Collections.sort(sorted);
    return sorted;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
    if (list == null) return null;
    List<Integer> sorted = new java.util.ArrayList<>(list);
    java.util.Collections.sort(sorted, java.util.Collections.reverseOrder());
    return sorted;
    }
}