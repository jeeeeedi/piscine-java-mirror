import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        // Gale-Shapley stable marriage algorithm
        Map<String, String> result = new HashMap<>();
        Map<String, String> reverseResult = new HashMap<>();
        Map<String, Integer> proposalIndex = new HashMap<>();
        Set<String> free = new HashSet<>(first.keySet());
        for (String proposer : first.keySet()) {
            proposalIndex.put(proposer, 0);
        }
        while (!free.isEmpty()) {
            String proposer = free.iterator().next();
            List<String> preferences = first.get(proposer);
            int idx = proposalIndex.get(proposer);
            String proposee = preferences.get(idx);
            proposalIndex.put(proposer, idx + 1);
            if (!reverseResult.containsKey(proposee)) {
                result.put(proposer, proposee);
                reverseResult.put(proposee, proposer);
                free.remove(proposer);
            } else {
                String current = reverseResult.get(proposee);
                List<String> proposeePrefs = second.get(proposee);
                if (proposeePrefs.indexOf(proposer) < proposeePrefs.indexOf(current)) {
                    result.put(proposer, proposee);
                    reverseResult.put(proposee, proposer);
                    free.remove(proposer);
                    free.add(current);
                }
            }
        }
        return result;
    }
}