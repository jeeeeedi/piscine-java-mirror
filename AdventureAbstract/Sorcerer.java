/* ---AdventureSorcerer--- */

public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    public void attack(Character target) {
        this.heal(this);

        if (target.getCurrentHealth() > 0) {
            target.takeDamage(10);
            if (target.getCurrentHealth() < 0) {
                target.setCurrentHealth(0);
            }
        }
    }

    public void takeDamage(int damage) {
        if (this.getCurrentHealth() > 0) {
            this.setCurrentHealth(this.getCurrentHealth() - damage);
            if (this.getCurrentHealth() < 0) {
                this.setCurrentHealth(0);
            }
        }
    }

    @Override
    public void heal(Character character) {
        if (character.getCurrentHealth() > 0 && character.getCurrentHealth() < character.getMaxHealth()) {
            int newHealth = character.getCurrentHealth() + this.healCapacity;
            character.setCurrentHealth(newHealth);
        }
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