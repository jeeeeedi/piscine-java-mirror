public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    public void heal(Character ch) {
        if (ch.getCurrentHealth() > 0 && ch.getCurrentHealth() < ch.getMaxHealth()) {
            int newHealth = ch.getCurrentHealth() + this.healCapacity;
            ch.setCurrentHealth(newHealth);
        } // else same currentHealth ?
    }

    public int getShield() {
        return this.shield;
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() <= 0) {
            return this.getName() + " has been beaten, even with its " + this.shield + " shield. So bad, it could heal "
                    + this.healCapacity + " HP.";
        } else {
            return this.getName() + " is a strong Templar with " + this.getCurrentHealth() + " HP. It can heal "
                    + this.getHealCapacity() + " HP and has a shield of " + this.getShield() + ".";
        }
    }
}