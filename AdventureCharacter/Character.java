/* import java.util.ArrayList;
import java.util.List; */

public class Character {

    private final int maxHealth;
    private int currentHealth;
    // public int currentHealth; // AdventureSorcerer
    private final String name;
    // private static List<Character> allCharacters = new ArrayList<>(); // AdventureUtils

    public Character(String name, int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.name = name;
        // allCharacters.add(this); // AdventureUtils
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (currentHealth > 0) {
            return name + " : " + currentHealth + "/" + maxHealth;
        } else {
            return name + " : KO";
        }
    }

    public void takeDamage(int damage) {
        if (currentHealth > 0) {
            currentHealth -= damage;
        } // handle error <= 0?
    }

    public void attack(Character target) {
        if (currentHealth > 0) {
            target.takeDamage(9);
        } // handle error <= 0?
    }

    /*--- AdventureUtils ---*/
/* 
    public static String printStatus() {
        if (allCharacters.size() <= 0) {
            return "------------------------------------------\n" +
                    "Nobody's fighting right now !\n" +
                    "------------------------------------------";
        } else {
            StringBuilder status = new StringBuilder();
            status.append("------------------------------------------\n");
            status.append("Characters currently fighting : \n");
            for (Character character : allCharacters) {
                status.append(" - ").append(character.toString()).append("\n");
            }
            status.append("------------------------------------------");
            return status.toString();
        }
    }

    public static Character fight(Character char1, Character char2) {
        while (char1.getCurrentHealth() > 0 || char2.getCurrentHealth() > 0) {
            char1.attack(char2);
            if (char2.getCurrentHealth() <= 0) {
                return char1;
            }
            char2.attack(char1);
            if (char1.getCurrentHealth() <= 0) {
                return char2;
            }
        }
        return null;
    } */
}