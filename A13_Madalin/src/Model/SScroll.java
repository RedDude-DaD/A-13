package Model;

/**
 *
 * @author radum
 */
public class SScroll extends item {

    private int neededKnowdelge;
    private int strength;
    private int will;
    private int knowledge;
    private int agility;

    public SScroll(int neededKnowdelge, int strength, int will, int knowledge, int agility, String id, String name, int sellPrice, int buyPrice, String rarity, String image) {
        super(id, name, sellPrice, buyPrice, rarity, image);
        this.neededKnowdelge = neededKnowdelge;
        this.strength = strength;
        this.will = will;
        this.knowledge = knowledge;
        this.agility = agility;
    }

    public int getNeededKnowdelge() {
        return neededKnowdelge;
    }

    public void setNeededKnowdelge(int neededKnowdelge) {
        this.neededKnowdelge = neededKnowdelge;
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
