/* ---AdventureMonster--- */

public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    public void attack(Character target) {
        try {
            int damage = (this.getWeapon() != null) ? this.getWeapon().getDamage() : 7;
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
            int reducedDamage = (int) Math.floor(damage * 0.8);
            this.setCurrentHealth(this.getCurrentHealth() - reducedDamage);
            if (this.getCurrentHealth() < 0) {
                this.setCurrentHealth(0);
            }
        } catch (DeadCharacterException e) {
            // Already dead, do nothing
        }
    }

    @Override
    public String toString() {
        String weaponStr = " He has the weapon " + this.getWeapon();
        if (getCurrentHealth() > 0) {
            return getName() + " is a monster with " + getCurrentHealth() + " HP" + weaponStr;
        } else {
            return getName() + " is a monster and is dead" + weaponStr;
        }
    }
}
