package Model;

/**
 *
 * @author radum
 */
public class PScroll extends item {

    private int neededKnowdelge;
    private int value;

    public PScroll(int neededKnowdelge, int value, String id, String name, int sellPrice, int buyPrice, String rarity, String image) {
        super(id, name, sellPrice, buyPrice, rarity, image);
        this.neededKnowdelge = neededKnowdelge;
        this.value = value;
    }

    public int getNeededKnowdelge() {
        return neededKnowdelge;
    }

    public void setNeededKnowdelge(int neededKnowdelge) {
        this.neededKnowdelge = neededKnowdelge;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
