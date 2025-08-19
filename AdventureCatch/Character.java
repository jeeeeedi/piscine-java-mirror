import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>(); // AdventureUtils
    private Weapon weapon; // AdventureWeapon

    public Character(String name, int maxHealth, Weapon weapon) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.name = name;
        allCharacters.add(this); // AdventureUtils
        this.weapon = weapon;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    protected void setCurrentHealth(int newHealth) {
        if (newHealth > maxHealth) {
            this.currentHealth = maxHealth;
        } else if (newHealth < 0) {
            this.currentHealth = 0;
        } else {
            this.currentHealth = newHealth;
        }
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

    public abstract void takeDamage(int damage); /*
                                                  * {
                                                  * if (currentHealth > 0) {
                                                  * currentHealth -= damage;
                                                  * if (currentHealth < 0) {
                                                  * currentHealth = 0;
                                                  * }
                                                  * }
                                                  * }
                                                  */

    public abstract void attack(Character target) throws DeadCharacterException; /*
                                                    * {
                                                    * if (currentHealth > 0) {
                                                    * target.takeDamage(9);
                                                    * if (currentHealth < 0) {
                                                    * currentHealth = 0;
                                                    * }
                                                    * }
                                                    * }
                                                    */

    /*--- AdventureUtils ---*/

    public static String printStatus() {
        if (allCharacters.isEmpty() || allCharacters == null) {
            return "------------------------------------------\n" +
                    "Nobody's fighting right now !\n" +
                    "------------------------------------------\n";
        } else {
            StringBuilder string = new StringBuilder();

            for (Character c : allCharacters) {
                string.append(" - ").append(c.toString()).append("\n");
            }

            return "------------------------------------------\n" +
                    "Characters currently fighting :\n" +
                    string.toString() +
                    "------------------------------------------\n";
        }
    }

    public static Character fight(Character char1, Character char2) {
        while (char1.getCurrentHealth() > 0 || char2.getCurrentHealth() > 0) {
            try {
                char1.attack(char2);
            } catch (DeadCharacterException e) {
                // Should not happen, but ignore
            }
            if (char2.getCurrentHealth() <= 0) {
                return char1;
            }
            try {
                char2.attack(char1);
            } catch (DeadCharacterException e) {
                // Should not happen, but ignore
            }
            if (char1.getCurrentHealth() <= 0) {
                return char2;
            }
        }
        return null;
    }

}