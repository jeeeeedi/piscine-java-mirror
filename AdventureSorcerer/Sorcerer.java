/* ---AdventureSorcerer--- */

public class Sorcerer extends Character implements Healer {
    private int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public Character heal(Character character) {
        if (character.getCurrentHealth() > 0 && character.getCurrentHealth() < character.getMaxHealth()) {
            int newHealth = character.getCurrentHealth() + this.healCapacity;
            if (newHealth > character.getMaxHealth()) {
                character.currentHealth = character.getMaxHealth();
            } else {
                character.currentHealth = newHealth;
            }
        }
        return character;
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() > 0) {
            return this.getName() + " is a sorcerer with " + this.getCurrentHealth() + " HP. It can heal "
                    + this.getHealCapacity() + " HP.";
        } else {
            return this.getName() + " is a dead sorcerer. So bad, it could heal "
                    + this.getHealCapacity() + " HP.";
        }
    }

}