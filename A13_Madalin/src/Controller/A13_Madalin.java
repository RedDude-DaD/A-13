package Controller;

import Base.Connexio;
import static Controller.log.creacioLog;
import Model.*;
import View.frmScreen;
import java.util.ArrayList;

/**
 *
 * @author radum
 */
public class A13_Madalin {

    public static String rutaIFitxerLogActual = "";

    // screen
    public static frmScreen screen = new frmScreen();
    // database
    public static Connexio c = new Connexio();
    // arrays
    public static ArrayList<Player> CaracterSelect = new ArrayList();
    public static ArrayList<Weapon> CCdefaultWeapons = new ArrayList();
    public static ArrayList<Armour> CCdefaultArmour = new ArrayList();
    public static ArrayList<Player> currentPlayer = new ArrayList();
    public static ArrayList<Monster> currentMonster = new ArrayList();
    // inventory
    public static ArrayList<Potion> InvPotion = new ArrayList();
    public static ArrayList<StatPotion> InvSPotion = new ArrayList();
    public static ArrayList<PScroll> InvPScroll = new ArrayList();
    public static ArrayList<SScroll> InvSScroll = new ArrayList();
    public static ArrayList<Weapon> InvWeapon = new ArrayList();
    public static ArrayList<Armour> InvArmour = new ArrayList();
    // shop
    public static ArrayList<Potion> ShopPotion = new ArrayList();
    public static ArrayList<StatPotion> ShopSPotion = new ArrayList();
    public static ArrayList<PScroll> ShopPScroll = new ArrayList();
    public static ArrayList<SScroll> ShopSScroll = new ArrayList();
    public static ArrayList<Weapon> ShopWeapon = new ArrayList();
    public static ArrayList<Armour> ShopArmour = new ArrayList();

    public static void main(String[] args) {
        creacioLog();
        c.connect();
        screen.setVisible(true);
    }
}
