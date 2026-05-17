package Model;

/**
 *
 * @author radum
 */
public class Potion extends item {

    private int value;
    private String type;

    public Potion(int value, String type, String id, String name, int sellPrice, int buyPrice, String rarity, String image) {
        super(id, name, sellPrice, buyPrice, rarity, image);
        this.value = value;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
