package Model;

import java.util.ArrayList;

/**
 *
 * @author radum
 */
public class Player {

    private String id;
    private String name;
    private String playerModel;
    private int level;
    private int exp;
    private int gold;
    private int maxHP;
    private int currentHP;
    private int shield;
    private int strength;
    private int will;
    private int knowledge;
    private int agility;
    private ArrayList<Weapon> weapon = new ArrayList();
    private ArrayList<Armour> armour = new ArrayList();
    private int dungeonsCleared;

    public Player(String id, String name, String playerModel, int level, int exp, int gold, int maxHP, int currentHP, int shield, int strength, int will, int knowledge, int agility, int dungeonsCleared) {
        this.id = id;
        this.name = name;
        this.playerModel = playerModel;
        this.level = level;
        this.exp = exp;
        this.gold = gold;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.shield = shield;
        this.strength = strength;
        this.will = will;
        this.knowledge = knowledge;
        this.agility = agility;
        this.dungeonsCleared = dungeonsCleared;
    }

    public void addWeapon(Weapon w) {
        weapon.add(w);
    }

    public void addArmour(Armour a) {
        armour.add(a);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerModel() {
        return playerModel;
    }

    public void setPlayerModel(String playerModel) {
        this.playerModel = playerModel;
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

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
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

    public String getWeapon() {
        return weapon.getFirst().getId();
    }

    public Weapon getWeaponA() {
        return weapon.getFirst();
    }

    public String getWeaponImg() {
        return weapon.getFirst().getImage();
    }
    
    public ArrayList<Armour> returnArmourArry(){
        return armour;
    }
    
    public ArrayList<Weapon> returnWeaponArry(){
        return weapon;
    }

    public void setWeapon(ArrayList<Weapon> weapon) {
        this.weapon = weapon;
    }

    public String getArmour() {
        return armour.getFirst().getId();
    }

    public Armour getArmourA() {
        return armour.getFirst();
    }

    public void delArmour() {
        armour.clear();
    }

    public void delWeapon() {
        weapon.clear();
    }

    public String getArmourImg() {
        return armour.getFirst().getImage();
    }

    public void setArmour(ArrayList<Armour> armour) {
        this.armour = armour;
    }

    public int getDungeonsCleared() {
        return dungeonsCleared;
    }

    public void setDungeonsCleared(int dungeonsCleared) {
        this.dungeonsCleared = dungeonsCleared;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", name=" + name + ", playerModel=" + playerModel + ", level=" + level + ", exp=" + exp + ", gold=" + gold + ", maxHP=" + maxHP + ", currentHP=" + currentHP + ", shield=" + shield + ", strength=" + strength + ", will=" + will + ", knowledge=" + knowledge + ", agility=" + agility + ", weapon=" + weapon + ", armour=" + armour + ", dungeonsCleared=" + dungeonsCleared + '}';
    }

}
