
package Model;

/**
 *
 * @author radum
 */
public class Monster {
    
    private String name;
    int level;
    int exp;
    int gold;
    String image;
    int HP;
    int damage;
    int magic;
    int pdr;
    int mdr;

    public Monster(String name, int level, int exp, int gold, String image, int HP, int damage, int magic, int pdr, int mdr) {
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.gold = gold;
        this.image = image;
        this.HP = HP;
        this.damage = damage;
        this.magic = magic;
        this.pdr = pdr;
        this.mdr = mdr;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getPdr() {
        return pdr;
    }

    public void setPdr(int pdr) {
        this.pdr = pdr;
    }

    public int getMdr() {
        return mdr;
    }

    public void setMdr(int mdr) {
        this.mdr = mdr;
    }
    
    
    
}
