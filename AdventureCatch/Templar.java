public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    public void attack(Character target) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0)
            throw new DeadCharacterException(this);
        this.heal(this);
        int damage = (this.getWeapon() != null) ? this.getWeapon().getDamage() : 6;
        if (target.getCurrentHealth() > 0) {
            target.takeDamage(damage);
            if (target.getCurrentHealth() < 0) {
                target.setCurrentHealth(0);
            }
        }
    }catch(

    DeadCharacterException e)
    {
        // Character is dead, do nothing
    }
    }

    public void takeDamage(int damage) throws DeadCharacterException {
        try {
            if (this.getCurrentHealth() <= 0)
                throw new DeadCharacterException(this);
            this.setCurrentHealth(this.getCurrentHealth() - damage + this.shield);
            if (this.getCurrentHealth() <= 0) {
                this.setCurrentHealth(0);
            }
        } catch (DeadCharacterException e) {
            // Already dead, do nothing
        }
    }

    public void heal(Character ch) throws DeadCharacterException {
        try {
            if (ch.getCurrentHealth() <= 0)
                throw new DeadCharacterException(ch);
            if (ch.getCurrentHealth() < ch.getMaxHealth()) {
                int newHealth = ch.getCurrentHealth() + this.healCapacity;
                ch.setCurrentHealth(newHealth);
            }
        } catch (DeadCharacterException e) {
            // Cannot heal dead character
        }
    }

    public int getShield() {
        return this.shield;
    }

    @Override
    public String toString() {
        String weaponStr = " He has the weapon " + this.getWeapon();
        if (this.getCurrentHealth() <= 0) {
            return this.getName() + " has been beaten, even with its " + this.shield + " shield. So bad, it could heal "
                    + this.healCapacity + " HP." + weaponStr;
        } else {
            return this.getName() + " is a strong Templar with " + this.getCurrentHealth() + " HP. It can heal "
                    + this.getHealCapacity() + " HP and has a shield of " + this.getShield() + "." + weaponStr;
        }
    }
}