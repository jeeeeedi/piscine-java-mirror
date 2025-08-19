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

    public void attack(Character target) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0) throw new DeadCharacterException(this);
        this.heal(this);
        int damage = (this.getWeapon() != null) ? this.getWeapon().getDamage() : 10;
        if (target.getCurrentHealth() > 0) {
            target.takeDamage(damage);
            if (target.getCurrentHealth() < 0) {
                target.setCurrentHealth(0);
            }
        }
    }

    public void takeDamage(int damage) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0) throw new DeadCharacterException(this);
        this.setCurrentHealth(this.getCurrentHealth() - damage);
        if (this.getCurrentHealth() < 0) {
            this.setCurrentHealth(0);
        }
    }

    @Override
    public void heal(Character character) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0) throw new DeadCharacterException(this);
        if (character.getCurrentHealth() <= 0) throw new DeadCharacterException(character);
        if (character.getCurrentHealth() < character.getMaxHealth()) {
            int newHealth = character.getCurrentHealth() + this.healCapacity;
            character.setCurrentHealth(newHealth);
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