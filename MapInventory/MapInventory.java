import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapInventory {
    /**
     * Returns the price of the specified product ID from the map.
     * If the product ID is not present, returns -1.
     */
    public static int getProductPrice(Map<String, Integer> inventory, String productId) {
        if (inventory == null || productId == null) return -1;
        return inventory.getOrDefault(productId, -1);
    }

    /**
     * Returns a list of product IDs that have the given price.
     * If no products are found for the specified price, returns an empty list.
     */
    public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
        List<String> result = new ArrayList<>();
        if (inventory == null) return result;
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() != null && entry.getValue() == price) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}