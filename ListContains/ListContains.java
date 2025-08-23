import java.util.List;

public class ListContains {
    public static boolean containsValue(List<Integer> list, Integer value) {
        if (list == null || value == null) {
            return false;
        }
        for (Integer i : list) {
            if (i.equals(value)) {
                return true;
            }
        }
        return false;
    }
}