/* ---AdventureSorcerer--- */

public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    public void attack(Character target) {
        try {
            this.heal(this);
            int damage = (this.getWeapon() != null) ? this.getWeapon().getDamage() : 10;
            if (this.getCurrentHealth() <= 0) throw new DeadCharacterException(this);
            if (target.getCurrentHealth() > 0) {
                target.takeDamage(damage);
                if (target.getCurrentHealth() < 0) {
                    target.setCurrentHealth(0);
                }
            }
        } catch (DeadCharacterException e) {
            // Character is dead, do nothing
        }
    }

    public void takeDamage(int damage) {
        try {
            if (this.getCurrentHealth() <= 0) throw new DeadCharacterException(this);
            this.setCurrentHealth(this.getCurrentHealth() - damage);
            if (this.getCurrentHealth() < 0) {
                this.setCurrentHealth(0);
            }
        } catch (DeadCharacterException e) {
            // Already dead, do nothing
        }
    }

    @Override
    public void heal(Character character) {
        try {
            if (character.getCurrentHealth() <= 0) throw new DeadCharacterException(character);
            if (character.getCurrentHealth() < character.getMaxHealth()) {
                int newHealth = character.getCurrentHealth() + this.healCapacity;
                character.setCurrentHealth(newHealth);
            }
        } catch (DeadCharacterException e) {
            // Cannot heal dead character
        }
    }

    @Override
    public String toString() {
        String weaponStr = " He has the weapon " + this.getWeapon();
        if (this.getCurrentHealth() > 0) {
            return this.getName() + " is a sorcerer with " + this.getCurrentHealth() + " HP. It can heal "
                    + this.getHealCapacity() + " HP." + weaponStr;
        } else {
            return this.getName() + " is a dead sorcerer. So bad, it could heal "
                    + this.getHealCapacity() + " HP." + weaponStr;
        }
    }

}