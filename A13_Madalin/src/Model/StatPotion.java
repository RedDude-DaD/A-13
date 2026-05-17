package Model;

/**
 *
 * @author radum
 */
public class StatPotion extends item {

    private int strength;
    private int will;
    private int knowledge;
    private int agility;

    public StatPotion(int strength, int will, int knowledge, int agility, String id, String name, int sellPrice, int buyPrice, String rarity, String image) {
        super(id, name, sellPrice, buyPrice, rarity, image);
        this.strength = strength;
        this.will = will;
        this.knowledge = knowledge;
        this.agility = agility;
    }

    

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getWill() {
        return will;
    }

    public void setWill(int will) {
        this.will = will;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    
    
}
