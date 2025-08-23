import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        if (coins == null || coins.isEmpty() || amount <= 0) return List.of();
        List<Integer> coinList = new ArrayList<>(coins);
        coinList.removeIf(c -> c == null || c <= 0);
        coinList.sort(Collections.reverseOrder());
        List<Integer> result = new ArrayList<>();
        int remaining = amount;
        for (int coin : coinList) {
            while (remaining >= coin) {
                result.add(coin);
                remaining -= coin;
            }
        }
        if (remaining != 0) return List.of(); // No solution
        return result;
    }
}