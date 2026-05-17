package Model;

/**
 *
 * @author radum
 */
public class Weapon extends item {

    private int weaponDamage;
    private int magicDamage;
    private int armourPenetration;
    private int magicPenetration;

    public Weapon(int weaponDamage, int magicDamage, int armourPenetration, int magicPenetration, String id, String name, int sellPrice, int buyPrice, String rarity, String image) {
        super(id, name, sellPrice, buyPrice, rarity, image);
        this.weaponDamage = weaponDamage;
        this.magicDamage = magicDamage;
        this.armourPenetration = armourPenetration;
        this.magicPenetration = magicPenetration;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int magicDamage) {
        this.magicDamage = magicDamage;
    }

    public int getArmourPenetration() {
        return armourPenetration;
    }

    public void setArmourPenetration(int armourPenetration) {
        this.armourPenetration = armourPenetration;
    }

    public int getMagicPenetration() {
        return magicPenetration;
    }

    public void setMagicPenetration(int magicPenetration) {
        this.magicPenetration = magicPenetration;
    }
}