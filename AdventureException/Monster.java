/* ---AdventureMonster--- */

public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    public void attack(Character target) {
        int damage = (this.getWeapon() != null) ? this.getWeapon().getDamage() : 7;
        if (target.getCurrentHealth() > 0) {
            target.takeDamage(damage);
            if (target.getCurrentHealth() < 0) {
                target.setCurrentHealth(0);
            }
        }
    }

    public void takeDamage(int damage) {
        if (this.getCurrentHealth() > 0) {
            int reducedDamage = (int) Math.floor(damage * 0.8);
            this.setCurrentHealth(this.getCurrentHealth() - reducedDamage);
            if (this.getCurrentHealth() < 0) {
                this.setCurrentHealth(0);
            }
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
