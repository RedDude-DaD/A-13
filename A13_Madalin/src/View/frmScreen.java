package View;

import static Base.Querry.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import static Controller.A13_Madalin.*;
import static Controller.log.addLogLine;
import Model.*;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author radum
 */
public class frmScreen extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmScreen.class.getName());

    /**
     * Creates new form frmScreen
     */
    public frmScreen() {
        initComponents();
        pRegister.setVisible(false);
        pCharacterSelect.setVisible(false);
        pCharacterCreate.setVisible(false);
        pForest.setVisible(false);
        pBattleForest.setVisible(false);
        pInventory.setVisible(false);
        pStats.setVisible(false);
        pVillage.setVisible(false);
        pInn.setVisible(false);
        pShop.setVisible(false);
        pSell.setVisible(false);
        inventory.add(lblInv1);
        inventory.add(lblInv2);
        inventory.add(lblInv3);
        inventory.add(lblInv4);
        inventory.add(lblInv5);
        inventory.add(lblInv6);
        inventory.add(lblInv7);
        inventory.add(lblInv8);
        inventory.add(lblInv9);
        inventory.add(lblInv10);
        inventory.add(lblInv11);
        inventory.add(lblInv12);
        inventory.add(lblInv13);
        inventory.add(lblInv14);
        inventory.add(lblInv15);
        inventory.add(lblInv16);
        inventory.add(lblInv17);
        inventory.add(lblInv18);
        inventory.add(lblInv19);
        inventory.add(lblInv20);
        inventory.add(lblInv21);
        inventory.add(lblInv22);
        inventory.add(lblInv23);
        inventory.add(lblInv24);
        inventory.add(lblInv25);
        inventory.add(lblInv26);
        inventory.add(lblInv27);
        inventory.add(lblInv28);
        inventory.add(lblInv29);
        inventory.add(lblInv30);
        inventory.add(lblInv31);
        inventory.add(lblInv32);
        shop.add(shop0);
        shop.add(shop1);
        shop.add(shop2);
        shop.add(shop3);
        shop.add(shop4);
        shop.add(shop5);
        shop.add(shop6);
        shop.add(shop7);
        shop.add(shop8);
        shop.add(shop9);
        sell.add(sell1);
        sell.add(sell2);
        sell.add(sell3);
        sell.add(sell4);
        sell.add(sell5);
        sell.add(sell6);
        sell.add(sell7);
        sell.add(sell8);
        sell.add(sell9);
        sell.add(sell10);
        sell.add(sell11);
        sell.add(sell12);
        sell.add(sell13);
        sell.add(sell14);
        sell.add(sell15);
        sell.add(sell16);
        sell.add(sell17);
        sell.add(sell18);
        sell.add(sell19);
        sell.add(sell20);
        sell.add(sell21);
        sell.add(sell22);
        sell.add(sell23);
        sell.add(sell24);
        sell.add(sell25);
        sell.add(sell26);
        sell.add(sell27);
        sell.add(sell28);
        sell.add(sell29);
        sell.add(sell30);
        sell.add(sell31);
        sell.add(sell32);
    }
    static String lastVisitedPanel = "";

    static String AccountName = "";
    static int AccountID = 0;
    static int AccountItems = 0;

    static int CCweaponSelector = 0;

    static int SelectCharacter = 0;

    static ArrayList<JLabel> inventory = new ArrayList();
    static ArrayList<String> InvItemId = new ArrayList();
    static int InvItemPos = 0;
    static String selectedEquipped = "";

    static ArrayList<JLabel> shop = new ArrayList();
    static ArrayList<String> shopItemID = new ArrayList();
    static int ShopItemPos = 0;
    static int itemGen = 0;

    static ArrayList<JLabel> sell = new ArrayList();
    static ArrayList<String> sellItemId = new ArrayList();
    static int sellItemPos = 0;

    static boolean usedStatChange = false;
    static int oldStrength = 0;
    static int oldWill = 0;
    static int oldKnowledge = 0;
    static int oldAgility = 0;

    /**
     * sets the image for player in character create
     */
    void setPlayerImageCC() {
        String imageFile = "";
        if (rbMale.isSelected()) {
            imageFile = "src/Images/playerMan.jpg";
        } else {
            imageFile = "src/Images/playerWoman.jpg";
        }
        ImageIcon icon = new ImageIcon(imageFile);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(CCimagePlayer.getWidth(), CCimagePlayer.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        CCimagePlayer.setIcon(scaledIcon);
    }

    /**
     * creates the default weapons the player can choose
     */
    static void createDefaultWeaponsCC() {
        CCdefaultWeapons.clear();
        // sword 
        AccountItems++;

       
        CCdefaultWeapons.add(new Weapon(36, 0, 14, 0, AccountID + "-" + AccountItems, "Sword", 2, 5, "common", "src/Images/sword.jpg"));

        // magic sword
        CCdefaultWeapons.add(new Weapon(19, 20, 11, 12, AccountID + "-" + AccountItems, "Crystal Sword", 2, 5, "common", "src/Images/crystal.jpg"));

        // spellbook
        CCdefaultWeapons.add(new Weapon(0, 31, 0, 16, AccountID + "-" + AccountItems, "SpellBook", 2, 5, "common", "src/Images/book.jpg"));

    }

    /**
     * sets the images when changed
     */
    void setWeaponImageCC() {
        // CCweaponSelector
        ImageIcon icon = new ImageIcon(CCdefaultWeapons.get(CCweaponSelector).getImage());
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(CCweaponImage.getWidth(), CCweaponImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        CCweaponImage.setIcon(scaledIcon);
        // stats and name
        lblCCweaponName.setText(CCdefaultWeapons.get(CCweaponSelector).getName());
        lblCCWD.setText(CCdefaultWeapons.get(CCweaponSelector).getWeaponDamage() + "");
        lblCCMD.setText(CCdefaultWeapons.get(CCweaponSelector).getMagicDamage() + "");
        lblCCAP.setText(CCdefaultWeapons.get(CCweaponSelector).getArmourPenetration() + "");
        lblCCMP.setText(CCdefaultWeapons.get(CCweaponSelector).getMagicPenetration() + "");
    }

    /**
     * inicializes the character selection
     */
    void setCharacterSelect() {
        // array list de players, 
        getPlayers(AccountID);
        Player p = CaracterSelect.get(SelectCharacter);
        // CaracterSelect CSImage lblCSname lblCSLevel btnCharacterReturn btnCharacterNext
        String imageFile = p.getPlayerModel();
        ImageIcon icon = new ImageIcon(imageFile);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(CSImage.getWidth(), CSImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        CSImage.setIcon(scaledIcon);

        lblCSname.setText(p.getName());
        lblCSLevel.setText(p.getLevel() + "");

        btnCharacterReturn.setEnabled(false);
        btnCharacterNext.setEnabled(true);
        if (CaracterSelect.size() == 1) {
            btnCharacterNext.setEnabled(false);
        }
    }

    /**
     * next / back button to select characters
     *
     * @param direction go forward or back
     */
    void setCharacterSelect(String direction) {
        // array list de players,        
        if (direction.equals("+")) {
            if (SelectCharacter + 1 < CaracterSelect.size()) {
                SelectCharacter++;
            }
        } else {
            if (SelectCharacter - 1 > -1) {
                SelectCharacter--;
            }
        }

        Player p = CaracterSelect.get(SelectCharacter);
        // CaracterSelect CSImage lblCSname lblCSLevel btnCharacterReturn btnCharacterNext
        String imageFile = p.getPlayerModel();
        ImageIcon icon = new ImageIcon(imageFile);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(CSImage.getWidth(), CSImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        CSImage.setIcon(scaledIcon);

        lblCSname.setText(p.getName());
        lblCSLevel.setText(p.getLevel() + "");
    }

    /**
     * sets the images and stats in forest
     */
    void setForest() {
        // background
        String imageFile = "src/Images/forest.jpg";
        ImageIcon icon = new ImageIcon(imageFile);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(lblBackgroundForest.getWidth(), lblBackgroundForest.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        lblBackgroundForest.setIcon(scaledIcon);

        // player 
        imageFile = currentPlayer.get(0).getPlayerModel();
        icon = new ImageIcon(imageFile);
        img = icon.getImage();
        imgScale = img.getScaledInstance(lblForestPlayerImage.getWidth(), lblForestPlayerImage.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        lblForestPlayerImage.setIcon(scaledIcon);

        // stats
        lblForestName.setText(currentPlayer.get(0).getName());
        lblForestLevel.setText(currentPlayer.get(0).getLevel() + "");
        lblForestExp.setText(currentPlayer.get(0).getExp() + "");
        lblForestGold.setText(currentPlayer.get(0).getGold() + "");
        lblForestHealth.setText(currentPlayer.get(0).getCurrentHP() + " / " + currentPlayer.get(0).getMaxHP());

    }

    /**
     * sets the stat and images in stats
     */
    void setStats() {
        // lblStatsPlayer  lblStatsLevel lblStatsExp 
        String imageFile = currentPlayer.getFirst().getPlayerModel();
        ImageIcon icon = new ImageIcon(imageFile);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(lblStatsPlayer.getWidth(), lblStatsPlayer.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        lblStatsPlayer.setIcon(scaledIcon);

        lblStatsLevel.setText(currentPlayer.getFirst().getLevel() + "");

        lblStatsExp.setText(currentPlayer.getFirst().getExp() + "");

        lblStatK.setText(currentPlayer.getFirst().getKnowledge() + "");
        lblStatS.setText(currentPlayer.getFirst().getStrength() + "");
        lblStatW.setText(currentPlayer.getFirst().getWill() + "");
        lblStatA.setText(currentPlayer.getFirst().getAgility() + "");

    }

    /**
     * enables or disables the stat buttons
     */
    void setStatButton() {

        int base = currentPlayer.getFirst().getLevel() + 49;
        int totalStats = currentPlayer.getFirst().getStrength() + currentPlayer.getFirst().getWill() + currentPlayer.getFirst().getKnowledge() + currentPlayer.getFirst().getAgility();

        lblStatsPoints.setText(base - totalStats + "");

        int points = Integer.parseInt(lblStatsPoints.getText());

        if (points == 0) {
            btnStatS.setEnabled(false);
            btnStatW.setEnabled(false);
            btnStatK.setEnabled(false);
            btnStatA.setEnabled(false);
        } else {
            btnStatS.setEnabled(true);
            btnStatW.setEnabled(true);
            btnStatK.setEnabled(true);
            btnStatA.setEnabled(true);
        }
    }

    /**
     * sets the images in inventory
     */
    void setInventory() {
        String imageFile;
        ImageIcon icon;
        Image img;
        Image imgScale;
        ImageIcon scaledIcon;

        // lblInvArmour lblInvWeapon btnInvUse btnInvEquip btnInvRemove btnInvDrop
        InvItemId.clear();
        for (int i = 0; i < inventory.size(); i++) {
            inventory.get(i).setIcon(null);
        }

        if (currentPlayer.getFirst().returnArmourArry().size() > 0) {
            imageFile = currentPlayer.getFirst().getArmourImg();
            icon = new ImageIcon(imageFile);
            img = icon.getImage();
            imgScale = img.getScaledInstance(lblInvArmour.getWidth(), lblInvArmour.getHeight(), Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            lblInvArmour.setIcon(scaledIcon);
        } else {
            lblInvArmour.setIcon(null);
        }

        if (currentPlayer.getFirst().returnWeaponArry().size() > 0) {
            imageFile = currentPlayer.getFirst().getWeaponImg();
            icon = new ImageIcon(imageFile);
            img = icon.getImage();
            imgScale = img.getScaledInstance(lblInvWeapon.getWidth(), lblInvWeapon.getHeight(), Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            lblInvWeapon.setIcon(scaledIcon);
        } else {
            lblInvWeapon.setIcon(null);
        }

        btnInvUse.setEnabled(false);
        btnInvEquip.setEnabled(false);
        btnInvRemove.setEnabled(false);
        btnInvDrop.setEnabled(false);

        clearInvInfo();

        // items  InvPotion InvSPotion InvPScroll InvSScroll InvWeapon InvArmour
        int InvCount = 0;

        for (int i = 0; i < InvPotion.size(); i++) {
            imageFile = InvPotion.get(i).getImage();
            icon = new ImageIcon(imageFile);
            img = icon.getImage();
            imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("potion");
            inventory.get(InvCount).setIcon(scaledIcon);
            InvItemId.add(InvPotion.get(i).getId());
            InvCount++;
        }

        for (int i = 0; i < InvSPotion.size(); i++) {
            imageFile = InvSPotion.get(i).getImage();
            icon = new ImageIcon(imageFile);

            img = icon.getImage();
            imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("spotion");
            inventory.get(InvCount).setIcon(scaledIcon);
            InvItemId.add(InvSPotion.get(i).getId());
            InvCount++;
        }

        for (int i = 0; i < InvPScroll.size(); i++) {
            imageFile = InvPScroll.get(i).getImage();
            icon = new ImageIcon(imageFile);

            img = icon.getImage();
            imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("pscroll");
            inventory.get(InvCount).setIcon(scaledIcon);
            InvItemId.add(InvPScroll.get(i).getId());
            InvCount++;
        }

        for (int i = 0; i < InvSScroll.size(); i++) {
            imageFile = InvSScroll.get(i).getImage();
            icon = new ImageIcon(imageFile);

            img = icon.getImage();
            imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("sscroll");
            inventory.get(InvCount).setIcon(scaledIcon);
            InvItemId.add(InvSScroll.get(i).getId());
            InvCount++;
        }

        for (int i = 0; i < InvWeapon.size(); i++) {
            imageFile = InvWeapon.get(i).getImage();
            icon = new ImageIcon(imageFile);

            img = icon.getImage();
            imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("weapon");
            inventory.get(InvCount).setIcon(scaledIcon);
            InvItemId.add(InvWeapon.get(i).getId());
            InvCount++;
        }

        for (int i = 0; i < InvArmour.size(); i++) {
            imageFile = InvArmour.get(i).getImage();
            icon = new ImageIcon(imageFile);

            img = icon.getImage();
            imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("armour");
            inventory.get(InvCount).setIcon(scaledIcon);
            InvItemId.add(InvArmour.get(i).getId());
            InvCount++;
        }
    }

    /**
     * sets the images in sell screen in shop
     */
    void setSell() {
        String imageFile;
        ImageIcon icon;
        Image img;
        Image imgScale;
        ImageIcon scaledIcon;

        clearSellInfo();
        sellItemId.clear();
        for (int i = 0; i < sell.size(); i++) {
            sell.get(i).setIcon(null);
        }

        int InvCount = 0;

        sellGold.setText("Gold : " + currentPlayer.getFirst().getGold());

        for (int i = 0; i < InvPotion.size(); i++) {
            imageFile = InvPotion.get(i).getImage();
            icon = new ImageIcon(imageFile);
            img = icon.getImage();
            imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("potion");
            sell.get(InvCount).setIcon(scaledIcon);
            sellItemId.add(InvPotion.get(i).getId());
            InvCount++;
        }

        for (int i = 0; i < InvSPotion.size(); i++) {
            imageFile = InvSPotion.get(i).getImage();
            icon = new ImageIcon(imageFile);

            img = icon.getImage();
            imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("spotion");
            sell.get(InvCount).setIcon(scaledIcon);
            sellItemId.add(InvSPotion.get(i).getId());
            InvCount++;
        }

        for (int i = 0; i < InvPScroll.size(); i++) {
            imageFile = InvPScroll.get(i).getImage();
            icon = new ImageIcon(imageFile);

            img = icon.getImage();
            imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("pscroll");
            sell.get(InvCount).setIcon(scaledIcon);
            sellItemId.add(InvPScroll.get(i).getId());
            InvCount++;
        }

        for (int i = 0; i < InvSScroll.size(); i++) {
            imageFile = InvSScroll.get(i).getImage();
            icon = new ImageIcon(imageFile);

            img = icon.getImage();
            imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("sscroll");
            sell.get(InvCount).setIcon(scaledIcon);
            sellItemId.add(InvSScroll.get(i).getId());
            InvCount++;
        }

        for (int i = 0; i < InvWeapon.size(); i++) {
            imageFile = InvWeapon.get(i).getImage();
            icon = new ImageIcon(imageFile);

            img = icon.getImage();
            imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("weapon");
            sell.get(InvCount).setIcon(scaledIcon);
            sellItemId.add(InvWeapon.get(i).getId());
            InvCount++;
        }

        for (int i = 0; i < InvArmour.size(); i++) {
            imageFile = InvArmour.get(i).getImage();
            icon = new ImageIcon(imageFile);

            img = icon.getImage();
            imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("armour");
            sell.get(InvCount).setIcon(scaledIcon);
            sellItemId.add(InvArmour.get(i).getId());
            InvCount++;
        }
    }

    /**
     * clears info from sell in shop
     */
    void clearSellInfo() {
        sellName.setText("");
        sellRarity.setText("");
        sellSell.setText("");
        sellinfo1.setText("");
        sellinfo2.setText("");
        sellinfo3.setText("");
        sellinfo4.setText("");
        sellinfo5.setText("");
        sellinfo6.setText("");
    }

    /**
     * clears info from inventory
     */
    void clearInvInfo() {
        // info 
        lblInvName.setText("");
        lblInvRarity.setText("");
        lblInvSell.setText("");
        lblInvinfo1.setText("");
        lblInvinfo2.setText("");
        lblInvinfo3.setText("");
        lblInvinfo4.setText("");
        lblInvinfo5.setText("");
        lblInvinfo6.setText("");
        lvlInvNotice.setText("");

        btnInvUse.setEnabled(false);
        btnInvEquip.setEnabled(false);
        btnInvRemove.setEnabled(false);
        btnInvDrop.setEnabled(false);
    }

    /**
     * returns the position in the inventory array
     *
     * @param ItemID id of item selected
     * @return returns index of item with specified id
     */
    int InvPotionInt(String ItemID) {
        int index = 0;
        for (int i = 0; i < InvPotion.size(); i++) {
            if (InvPotion.get(i).getId().equals(ItemID)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * returns the position in the inventory array
     *
     * @param ItemID id of item selected
     * @return returns index of item with specified id
     */
    int InvSPotionInt(String ItemID) {
        int index = 0;
        for (int i = 0; i < InvSPotion.size(); i++) {
            if (InvSPotion.get(i).getId().equals(ItemID)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * returns the position in the inventory array
     *
     * @param ItemID id of item selected
     * @return returns index of item with specified id
     */
    int InvPScrollInt(String ItemID) {
        int index = 0;
        for (int i = 0; i < InvPScroll.size(); i++) {
            if (InvPScroll.get(i).getId().equals(ItemID)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * returns the position in the inventory array
     *
     * @param ItemID id of item selected
     * @return returns index of item with specified id
     */
    int InvSScrollInt(String ItemID) {
        int index = 0;
        for (int i = 0; i < InvSScroll.size(); i++) {
            if (InvSScroll.get(i).getId().equals(ItemID)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * returns the position in the inventory array
     *
     * @param ItemID id of item selected
     * @return returns index of item with specified id
     */
    int InvWeaponInt(String ItemID) {
        int index = 0;
        for (int i = 0; i < InvWeapon.size(); i++) {
            if (InvWeapon.get(i).getId().equals(ItemID)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * returns the position in the inventory array
     *
     * @param ItemID id of item selected
     * @return returns index of item with specified id
     */
    int InvArmourInt(String ItemID) {
        int index = 0;
        for (int i = 0; i < InvArmour.size(); i++) {
            if (InvArmour.get(i).getId().equals(ItemID)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * shown the info of selected item in inventory
     *
     * @param pos the selected item
     */
    void InvItemClick(int pos) {
        // show info 
        String ItemID = "";
        String ItemType = "";
        try {
            ItemID = InvItemId.get(pos);
            ImageIcon icon = (ImageIcon) inventory.get(pos).getIcon();
            ItemType = icon.getDescription();
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        InvItemPos = pos;
        clearInvInfo();
        int index = 0;
        switch (ItemType) {
            case "potion":
                index = InvPotionInt(ItemID);
                lblInvName.setText(InvPotion.get(index).getName());
                lblInvRarity.setText("Rarity: " + InvPotion.get(index).getRarity());
                lblInvSell.setText("Price: " + InvPotion.get(index).getSellPrice() + "");
                lblInvinfo1.setText("Value: " + InvPotion.get(index).getValue() + "");
                btnInvUse.setEnabled(true);
                break;
            case "spotion":
                index = InvSPotionInt(ItemID);
                lblInvName.setText(InvSPotion.get(index).getName());
                lblInvRarity.setText("Rarity: " + InvSPotion.get(index).getRarity());
                lblInvSell.setText("Price: " + InvSPotion.get(index).getSellPrice() + "");
                lblInvinfo1.setText("Strength: " + InvSPotion.get(index).getStrength() + "");
                lblInvinfo2.setText("Will: " + InvSPotion.get(index).getWill() + "");
                lblInvinfo3.setText("Knowledge: " + InvSPotion.get(index).getKnowledge() + "");
                lblInvinfo4.setText("Agility: " + InvSPotion.get(index).getAgility() + "");
                if (lastVisitedPanel.equals("battleForest")) {
                    btnInvUse.setEnabled(true);
                }
                break;
            case "pscroll":
                index = InvPScrollInt(ItemID);
                lblInvName.setText(InvPScroll.get(index).getName());
                lblInvRarity.setText("Rarity: " + InvPScroll.get(index).getRarity());
                lblInvSell.setText("Price: " + InvPScroll.get(index).getSellPrice() + "");
                lblInvinfo1.setText("Needed Knowledge: " + InvPScroll.get(index).getNeededKnowdelge() + "");
                lblInvinfo2.setText("Value: " + InvPScroll.get(index).getValue() + "");
                if (lastVisitedPanel.equals("battleForest")) {
                    btnInvUse.setEnabled(true);
                }
                break;
            case "sscroll":
                index = InvSScrollInt(ItemID);
                lblInvName.setText(InvSScroll.get(index).getName());
                lblInvRarity.setText("Rarity: " + InvSScroll.get(index).getRarity());
                lblInvSell.setText("Price: " + InvSScroll.get(index).getSellPrice() + "");
                lblInvinfo1.setText("Needed Knowledge: " + InvSScroll.get(index).getNeededKnowdelge() + "");
                lblInvinfo2.setText("Strength: " + InvSScroll.get(index).getStrength() + "");
                lblInvinfo3.setText("Will: " + InvSScroll.get(index).getWill() + "");
                lblInvinfo4.setText("Knowledge: " + InvSScroll.get(index).getKnowledge() + "");
                lblInvinfo5.setText("Agility: " + InvSScroll.get(index).getAgility() + "");
                if (lastVisitedPanel.equals("battleForest")) {
                    btnInvUse.setEnabled(true);
                }
                break;
            case "weapon":
                index = InvWeaponInt(ItemID);
                lblInvName.setText(InvWeapon.get(index).getName());
                lblInvRarity.setText("Rarity: " + InvWeapon.get(index).getRarity());
                lblInvSell.setText("Price: " + InvWeapon.get(index).getSellPrice() + "");
                lblInvinfo1.setText("Weapon Damage: " + InvWeapon.get(index).getWeaponDamage() + "");
                lblInvinfo2.setText("Magic Damage: " + InvWeapon.get(index).getMagicDamage() + "");
                lblInvinfo3.setText("Armour Penetration: " + InvWeapon.get(index).getArmourPenetration() + "");
                lblInvinfo4.setText("Magic Penetration: " + InvWeapon.get(index).getMagicPenetration() + "");
                if (!lastVisitedPanel.equals("battleForest")) {
                    btnInvEquip.setEnabled(true);
                }

                break;
            case "armour":
                index = InvArmourInt(ItemID);
                lblInvName.setText(InvArmour.get(index).getName());
                lblInvRarity.setText("Rarity: " + InvArmour.get(index).getRarity());
                lblInvSell.setText("Price: " + InvArmour.get(index).getSellPrice() + "");
                lblInvinfo1.setText("PDR: " + InvArmour.get(index).getPDR() + "");
                lblInvinfo2.setText("MDR " + InvArmour.get(index).getMDR() + "");
                lblInvinfo3.setText("Strength: " + InvArmour.get(index).getStrength() + "");
                lblInvinfo4.setText("Will: " + InvArmour.get(index).getWill() + "");
                lblInvinfo5.setText("Knowledge: " + InvArmour.get(index).getKnowledge() + "");
                lblInvinfo6.setText("Agility: " + InvArmour.get(index).getAgility() + "");
                if (!lastVisitedPanel.equals("battleForest")) {
                    btnInvEquip.setEnabled(true);
                }
                break;
        }
        btnInvDrop.setEnabled(true);

    }

    /**
     * generates a monster for a battle
     */
    void GenerateMonster() {
        // 1-6 slime wolf bear goblin orc skeleton
        // level -2 +5 
        // xp (+lvl), gold (+lvl), hp ,damage (+lvl/2), magic (+lvl/2),pdr ,mdr
        String random = Math.floor(Math.random() * 6) + "";
        String levelDir = Math.floor(Math.random() * 2) + "";
        int Levelvalue;
        int level;
        if (levelDir.equals("1.0")) {
            // up
            Levelvalue = Integer.parseInt((int) Math.floor(Math.random() * 5) + "");
            level = currentPlayer.getFirst().getLevel() + Levelvalue;
        } else {
            // down
            Levelvalue = Integer.parseInt((int) Math.floor(Math.random() * 2) + "");
            level = currentPlayer.getFirst().getLevel() - Levelvalue;
            if (level < 1) {
                level = 1;
            }
        }
        int halflevel = level / 2;
        switch (random) {
            case "0.0":// slime:   23 , 6 , 40 , 17 , 12 , 40 , 16
                currentMonster.add(new Monster("Slime", level, 23 + level, 4 + level, "src/Images/slime.jpg", 40 + level, 17 + (level * 2), 17 + (level * 2), 60 + level, 36 + level));
                break;
            case "1.0":   // wolf:    36 , 11 , 60 , 25 , 0 , 23 , 20
                currentMonster.add(new Monster("Wolf", level, 36 + level, 7 + level, "src/Images/wolf.jpg", 60 + level, 30 + (level * 2), 0, 43 + level, 40 + level));
                break;
            case "2.0": // bear:    51 , 23 , 80 , 37 , 0 , 50 , 20
                currentMonster.add(new Monster("Bear", level, 51 + level, 17 + level, "src/Images/bear.jpg", 80 + level, 42 + (level * 2), 0, 70 + level, 46 + level));
                break;
            case "3.0":// goblin:  34 , 13 , 45 , 21 , 18 , 30 , 21
                currentMonster.add(new Monster("Goblin", level, 34 + level, 9 + level, "src/Images/goblin.jpg", 45 + level, 25 + (level * 2), 19 + (level * 2), 50 + level, 41 + level));
                break;
            case "4.0":// skele:   38 , 12 , 50 , 24 , 0 , 20 , 30
                currentMonster.add(new Monster("Skeleton", level, 38 + level, 11 + level, "src/Images/skeleton.jpg", 50 + level, 29 + (level * 2), 0, 40 + level, 50 + level));
                break;
            case "5.0":// orc:     61 , 41 , 85 , 40 , 20 , 50 , 50
                currentMonster.add(new Monster("Orc", level, 53 + level, 20 + level, "src/Images/orc.jpg", 85 + level, 37 + (level * 2), 18 + (level * 2), 70 + level, 70 + level));
                break;
        }

    }

    /**
     * check if player died
     */
    void PlayerDeadForest() {
        if (currentPlayer.getFirst().getCurrentHP() == 0) {
            // you die
            btnBattleRunAway.setEnabled(false);
            btnAttack.setEnabled(false);
            btnBattleInv.setEnabled(false);
            pnlFBat.setVisible(true);
            lblFbatInfo.setText("You Died to the monster");
            lblFBGold.setText("");
            lblFBXP.setText("");
            btnFBatbut.setText("Continue");
            //currentPlayer.clear();
            return;
        }
    }

    /**
     * sets the images in the battle
     */
    void SetBattleForest() {
        btnBattleRunAway.setEnabled(true);
        btnAttack.setEnabled(true);
        btnBattleInv.setEnabled(true);
        PlayerDamageF.setText("");
        MonsterDamageF.setText("");
        lblminShield.setText("");
        pnlFBat.setVisible(false);

        // background
        String imageFile = "src/Images/battleForest.jpg";
        ImageIcon icon = new ImageIcon(imageFile);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(lblForestBackgroundBattle.getWidth(), lblForestBackgroundBattle.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        lblForestBackgroundBattle.setIcon(scaledIcon);

        // player image / health
        imageFile = currentPlayer.get(0).getPlayerModel();
        icon = new ImageIcon(imageFile);
        img = icon.getImage();
        imgScale = img.getScaledInstance(lblForestBattlePlayer.getWidth(), lblForestBattlePlayer.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        lblForestBattlePlayer.setIcon(scaledIcon);
        lblFBshield.setText(currentPlayer.getFirst().getShield() + "");
        lblbattleForestPlayerHP.setText(currentPlayer.getFirst().getCurrentHP() + " / " + currentPlayer.getFirst().getMaxHP());

        // monster lblForestBattleMonster
        imageFile = currentMonster.get(0).getImage();
        icon = new ImageIcon(imageFile);
        img = icon.getImage();
        imgScale = img.getScaledInstance(lblForestBattleMonster.getWidth(), lblForestBattleMonster.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        lblForestBattleMonster.setIcon(scaledIcon);

        MNameBat.setText(currentMonster.getFirst().getName());
        MlevelBat.setText("Level: " + currentMonster.getFirst().getLevel());
        MHealthBat.setText("HP: " + currentMonster.getFirst().getHP());

    }

    /**
     * sets images in village
     */
    void SetVillage() {
        // background
        String imageFile = "src/Images/village.jpg";
        ImageIcon icon = new ImageIcon(imageFile);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(BackgroundVillage.getWidth(), BackgroundVillage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        BackgroundVillage.setIcon(scaledIcon);

        // player 
        imageFile = currentPlayer.get(0).getPlayerModel();
        icon = new ImageIcon(imageFile);
        img = icon.getImage();
        imgScale = img.getScaledInstance(lblVillageP.getWidth(), lblVillageP.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        lblVillageP.setIcon(scaledIcon);

        // stats
        lblVillageName.setText(currentPlayer.get(0).getName());
        lblVillageLevel.setText(currentPlayer.get(0).getLevel() + "");
        lblVillageExp.setText(currentPlayer.get(0).getExp() + "");
        lblVillageGold.setText(currentPlayer.get(0).getGold() + "");
        lblVillageHealth.setText(currentPlayer.get(0).getCurrentHP() + " / " + currentPlayer.get(0).getMaxHP());
    }

    /**
     * sets images in inn
     */
    void SetInn() {
        // background
        String imageFile = "src/Images/inn.jpg";
        ImageIcon icon = new ImageIcon(imageFile);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(InnBackground.getWidth(), InnBackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        InnBackground.setIcon(scaledIcon);

        // player 
        imageFile = currentPlayer.get(0).getPlayerModel();
        icon = new ImageIcon(imageFile);
        img = icon.getImage();
        imgScale = img.getScaledInstance(PlayerInn.getWidth(), PlayerInn.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(imgScale);
        PlayerInn.setIcon(scaledIcon);

        // stats
        lblInnName.setText(currentPlayer.get(0).getName());
        lblInnLevel.setText(currentPlayer.get(0).getLevel() + "");
        lblInnExp.setText(currentPlayer.get(0).getExp() + "");
        lblInnGold.setText(currentPlayer.get(0).getGold() + "");
        lblInnHealth.setText(currentPlayer.get(0).getCurrentHP() + " / " + currentPlayer.get(0).getMaxHP());

        lblInnInfo.setText("");
    }

    /**
     * generates the items you find in the shop
     *
     * @param count how many to create
     */
    void GenerateShop(int count) {
        itemGen = count;
        // potion | spotion | sscroll | pscroll | weapon | armour 
        for (int i = 0; i < count; i++) {
            AccountItems++;

           
            int randomType = (int) Math.floor(Math.random() * 6);
            String[] rarity = {"common", "rare", "epic", "legendary"};
            int rarityR = (int) Math.floor(Math.random() * 4);
            String rarityChoose = rarity[rarityR];
            String idItem = AccountID + "-" + AccountItems;
            String Name = "";
            String image = "";
            int sell = 0;
            int buy = 0;

            switch (randomType) {
                case 0:// potion value type
                    int value = 0;
                    String typePotion;
                    switch (rarityChoose) {
                        case "common":
                            value = 20;
                            sell = 2;
                            buy = 5;
                            break;
                        case "rare":
                            value = 25;
                            sell = 4;
                            buy = 8;
                            break;
                        case "epic":
                            value = 30;
                            sell = 6;
                            buy = 13;
                            break;
                        case "legendary":
                            value = 40;
                            sell = 9;
                            buy = 20;
                            break;
                    }
                    int typing = (int) Math.floor(Math.random() * 2);

                    if (typing == 0) {
                        // hp
                        Name = "Healing Potion";
                        image = "src/Images/Hppotion.jpg";
                        typePotion = "HP";
                    } else {
                        // protecion
                        Name = "Protecion Potion";
                        image = "src/Images/protectionPotion.jpg";
                        typePotion = "PROT";
                    }
                    ShopPotion.add(new Potion(value, typePotion, idItem, Name, sell, buy, rarityChoose, image));

                    break;
                case 1:// spotion str will knw agi
                    Name = "Stat Potion";
                    image = "src/Images/statPotion.jpg";
                    int str = 0;
                    int will = 0;
                    int knw = 0;
                    int agi = 0;
                    int statCount = 0;
                    switch (rarityChoose) {
                        case "common":
                            statCount = 1;
                            sell = 2;
                            buy = 7;
                            break;
                        case "rare":
                            statCount = 2;
                            sell = 4;
                            buy = 10;
                            break;
                        case "epic":
                            statCount = 3;
                            sell = 6;
                            buy = 15;
                            break;
                        case "legendary":
                            statCount = 4;
                            sell = 9;
                            buy = 22;
                            break;
                    }

                    switch (statCount) {
                        case 1:
                            str = statItem(4);
                            break;
                        case 2:
                            str = statItem(4);
                            will = statItem(4);
                            break;
                        case 3:
                            str = statItem(4);
                            will = statItem(4);
                            agi = statItem(4);
                            break;
                        case 4:
                            str = statItem(4);
                            will = statItem(4);
                            agi = statItem(4);
                            knw = statItem(4);
                            break;
                    }
                    ShopSPotion.add(new StatPotion(str, will, knw, agi, idItem, Name, sell, buy, rarityChoose, image));

                    break;
                case 2:// sscroll
                    int neededKnw = 0;
                    str = 0;
                    will = 0;
                    knw = 0;
                    agi = 0;
                    Name = "Stat Scroll";
                    image = "src/Images/SScroll.jpg";
                    statCount = 0;
                    switch (rarityChoose) {
                        case "common":
                            statCount = 1;
                            sell = 4;
                            buy = 11;
                            neededKnw = 12;
                            break;
                        case "rare":
                            statCount = 2;
                            sell = 8;
                            buy = 17;
                            neededKnw = 14;
                            break;
                        case "epic":
                            statCount = 3;
                            sell = 6;
                            buy = 15;
                            neededKnw = 16;
                            break;
                        case "legendary":
                            statCount = 4;
                            sell = 17;
                            buy = 31;
                            neededKnw = 18;
                            break;
                    }
                    switch (statCount) {
                        case 1:
                            str = statItem(4);
                            break;
                        case 2:
                            str = statItem(4);
                            will = statItem(4);
                            break;
                        case 3:
                            str = statItem(4);
                            will = statItem(4);
                            agi = statItem(4);
                            break;
                        case 4:
                            str = statItem(4);
                            will = statItem(4);
                            agi = statItem(4);
                            knw = statItem(4);
                            break;
                    }

                    ShopSScroll.add(new SScroll(neededKnw, str, will, knw, agi, idItem, Name, sell, buy, rarityChoose, image));

                    break;
                case 3:// pscroll
                    Name = "Protection Scroll";
                    image = "src/Images/PScroll.jpg";
                    neededKnw = 0;
                    value = 0;
                    switch (rarityChoose) {
                        case "common":
                            sell = 4;
                            buy = 11;
                            value = 25;
                            neededKnw = 12;
                            break;
                        case "rare":
                            sell = 8;
                            buy = 17;
                            value = 30;
                            neededKnw = 14;
                            break;
                        case "epic":
                            sell = 12;
                            buy = 23;
                            value = 40;
                            neededKnw = 16;
                            break;
                        case "legendary":
                            sell = 17;
                            buy = 31;
                            value = 50;
                            neededKnw = 18;
                            break;
                    }
                    ShopPScroll.add(new PScroll(neededKnw, value, idItem, Name, sell, buy, rarityChoose, image));
                    break;
                case 4:// weapon wd, md, ap, mp |||| ,  ,
                    Name = "";
                    image = "";
                    int wd = 0;
                    int md = 0;
                    int ap = 0;
                    int mp = 0;
                    int WeaponType = (int) Math.floor(Math.random() * 3);
                    switch (WeaponType) {
                        case 0:// Sword 
                            Name = "Sword";
                            image = "src/Images/sword.jpg";
                            switch (rarityChoose) {
                                case "common":
                                    sell = 9;
                                    buy = 25;
                                    wd = 36;
                                    ap = 14;
                                    break;
                                case "rare":
                                    sell = 14;
                                    buy = 36;
                                    wd = 38;
                                    ap = 16;
                                    break;
                                case "epic":
                                    sell = 18;
                                    buy = 51;
                                    wd = 40;
                                    ap = 17;
                                    break;
                                case "legendary":
                                    sell = 21;
                                    buy = 60;
                                    wd = 42;
                                    ap = 19;
                                    break;
                            }
                            break;
                        case 1:// Crystal Sword
                            Name = "Crystal Sword";
                            image = "src/Images/crystal.jpg";
                            switch (rarityChoose) {
                                case "common":
                                    sell = 9;
                                    buy = 25;
                                    wd = 20;
                                    ap = 12;
                                    md = 20;
                                    mp = 12;
                                    break;
                                case "rare":
                                    sell = 14;
                                    buy = 36;
                                    wd = 24;
                                    ap = 14;
                                    md = 24;
                                    mp = 13;
                                    break;
                                case "epic":
                                    sell = 18;
                                    buy = 51;
                                    wd = 28;
                                    ap = 15;
                                    md = 28;
                                    mp = 16;
                                    break;
                                case "legendary":
                                    sell = 21;
                                    buy = 60;
                                    wd = 31;
                                    ap = 18;
                                    md = 31;
                                    mp = 18;
                                    break;
                            }
                            break;
                        case 2:// SpellBook
                            Name = "SpellBook";
                            image = "src/Images/book.jpg";
                            switch (rarityChoose) {
                                case "common":
                                    sell = 9;
                                    buy = 25;
                                    md = 32;
                                    mp = 16;
                                    break;
                                case "rare":
                                    sell = 14;
                                    buy = 36;
                                    md = 32;
                                    mp = 16;
                                    break;
                                case "epic":
                                    sell = 18;
                                    buy = 51;
                                    md = 32;
                                    mp = 16;
                                    break;
                                case "legendary":
                                    sell = 21;
                                    buy = 60;
                                    md = 32;
                                    mp = 16;
                                    break;
                            }
                            break;
                    }
                    ShopWeapon.add(new Weapon(wd, md, ap, mp, idItem, Name, sell, buy, rarityChoose, image));
                    break;
                case 5:// armour 
                    Name = "";
                    image = "";
                    str = 0;
                    will = 0;
                    knw = 0;
                    agi = 0;
                    int pdr = 0;
                    int mdr = 0;
                    statCount = 0;
                    int ArmourType = (int) Math.floor(Math.random() * 3);

                    switch (ArmourType) {
                        case 0: // Cloth Armour
                            Name = "Cloth Armour";
                            image = "src/Images/clothArmour.jpg";
                            switch (rarityChoose) {
                                case "common":
                                    sell = 12;
                                    buy = 30;
                                    pdr = 32;
                                    mdr = 14;
                                    statCount = 1;
                                    break;
                                case "rare":
                                    sell = 18;
                                    buy = 41;
                                    pdr = 38;
                                    mdr = 16;
                                    statCount = 2;
                                    break;
                                case "epic":
                                    sell = 23;
                                    buy = 61;
                                    pdr = 40;
                                    mdr = 20;
                                    statCount = 3;
                                    break;
                                case "legendary":
                                    sell = 33;
                                    buy = 80;
                                    pdr = 45;
                                    mdr = 26;
                                    statCount = 4;
                                    break;
                            }
                            break;
                        case 1: // Leather Armour
                            Name = "Leather Armour";
                            image = "src/Images/LeatherArmour.jpg";
                            switch (rarityChoose) {
                                case "common":
                                    sell = 11;
                                    buy = 28;
                                    pdr = 32;
                                    mdr = 30;
                                    statCount = 1;
                                    break;
                                case "rare":
                                    sell = 14;
                                    buy = 36;
                                    pdr = 38;
                                    mdr = 34;
                                    statCount = 2;
                                    break;
                                case "epic":
                                    sell = 18;
                                    buy = 51;
                                    pdr = 40;
                                    mdr = 41;
                                    statCount = 3;
                                    break;
                                case "legendary":
                                    sell = 21;
                                    buy = 60;
                                    pdr = 45;
                                    mdr = 50;
                                    statCount = 4;
                                    break;
                            }
                            break;
                        case 2: // Metal Armour
                            Name = "Metal Armour";
                            image = "src/Images/metalArmour.jpg";
                            switch (rarityChoose) {
                                case "common":
                                    sell = 17;
                                    buy = 40;
                                    pdr = 50;
                                    mdr = 12;
                                    statCount = 1;
                                    break;
                                case "rare":
                                    sell = 21;
                                    buy = 51;
                                    pdr = 63;
                                    mdr = 13;
                                    statCount = 2;
                                    break;
                                case "epic":
                                    sell = 22;
                                    buy = 67;
                                    pdr = 73;
                                    mdr = 15;
                                    statCount = 3;
                                    break;
                                case "legendary":
                                    sell = 31;
                                    buy = 81;
                                    pdr = 81;
                                    mdr = 17;
                                    statCount = 4;
                                    break;
                            }
                            break;
                    }

                    switch (statCount) {
                        case 1:
                            str = statItem(4);
                            break;
                        case 2:
                            str = statItem(4);
                            will = statItem(4);
                            break;
                        case 3:
                            str = statItem(4);
                            will = statItem(4);
                            agi = statItem(4);
                            break;
                        case 4:
                            str = statItem(4);
                            will = statItem(4);
                            agi = statItem(4);
                            knw = statItem(4);
                            break;
                    }

                    // add to array
                    ShopArmour.add(new Armour(pdr, mdr, str, will, knw, agi, idItem, Name, sell, buy, rarityChoose, image));
                    break;
            }

        }

    }

    /**
     * generates a number to give items that use str, will, knw, agi
     *
     * @param i size of number
     * @return random number
     */
    int statItem(int i) {
        int output = 0;

        output = (int) Math.floor(Math.random() * i) + 1;

        return output;
    }

    /**
     * sets images in shop
     */
    void setShop() {
        // background
        String imageFile = "src/Images/shop.jpg";
        ImageIcon icon = new ImageIcon(imageFile);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(shopBack.getWidth(), shopBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        shopBack.setIcon(scaledIcon);

        btnShopBuy.setEnabled(false);

        // info
        lblShopGold.setText(currentPlayer.getFirst().getGold() + "");
        shopinfoname.setText("");
        shopinfoprice.setText("");
        shopinforarity.setText("");
        shopinfo1.setText("");
        shopinfo2.setText("");
        shopinfo3.setText("");
        shopinfo4.setText("");
        shopinfo5.setText("");
        shopinfo6.setText("");

        // set items
        shopItemID.clear();
        for (int i = 0; i < shop.size(); i++) {
            shop.get(i).setIcon(null);
        }

        int shopCount = 0;

        for (int i = 0; i < ShopPotion.size(); i++) {
            imageFile = ShopPotion.get(i).getImage();
            icon = new ImageIcon(imageFile);
            img = icon.getImage();
            imgScale = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("potion");
            shop.get(shopCount).setIcon(scaledIcon);
            shopItemID.add(ShopPotion.get(i).getId());
            shopCount++;
        }

        for (int i = 0; i < ShopSPotion.size(); i++) {
            imageFile = ShopSPotion.get(i).getImage();
            icon = new ImageIcon(imageFile);
            img = icon.getImage();
            imgScale = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("spotion");
            shop.get(shopCount).setIcon(scaledIcon);
            shopItemID.add(ShopSPotion.get(i).getId());
            shopCount++;
        }

        for (int i = 0; i < ShopSScroll.size(); i++) {
            imageFile = ShopSScroll.get(i).getImage();
            icon = new ImageIcon(imageFile);
            img = icon.getImage();
            imgScale = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("sscroll");
            shop.get(shopCount).setIcon(scaledIcon);
            shopItemID.add(ShopSScroll.get(i).getId());
            shopCount++;
        }

        for (int i = 0; i < ShopPScroll.size(); i++) {
            imageFile = ShopPScroll.get(i).getImage();
            icon = new ImageIcon(imageFile);
            img = icon.getImage();
            imgScale = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("pscroll");
            shop.get(shopCount).setIcon(scaledIcon);
            shopItemID.add(ShopPScroll.get(i).getId());
            shopCount++;
        }

        for (int i = 0; i < ShopWeapon.size(); i++) {
            imageFile = ShopWeapon.get(i).getImage();
            icon = new ImageIcon(imageFile);
            img = icon.getImage();
            imgScale = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("weapon");
            shop.get(shopCount).setIcon(scaledIcon);
            shopItemID.add(ShopWeapon.get(i).getId());
            shopCount++;
        }

        for (int i = 0; i < ShopArmour.size(); i++) {
            imageFile = ShopArmour.get(i).getImage();
            icon = new ImageIcon(imageFile);
            img = icon.getImage();
            imgScale = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(imgScale);
            scaledIcon.setDescription("armour");
            shop.get(shopCount).setIcon(scaledIcon);
            shopItemID.add(ShopArmour.get(i).getId());
            shopCount++;
        }

    }

    /**
     * clears info in shop
     */
    void clearShopInfo() {
        lblShopGold.setText(currentPlayer.getFirst().getGold() + "");
        shopinfoname.setText("");
        shopinfoprice.setText("");
        shopinforarity.setText("");
        shopinfo1.setText("");
        shopinfo2.setText("");
        shopinfo3.setText("");
        shopinfo4.setText("");
        shopinfo5.setText("");
        shopinfo6.setText("");
    }

    /**
     * returns the position in the shop array
     *
     * @param ItemID id of item selected
     * @return returns index of item with specified id
     */
    int ShopPotionInt(String ItemID) {
        int index = 0;
        for (int i = 0; i < ShopPotion.size(); i++) {
            if (ShopPotion.get(i).getId().equals(ItemID)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * returns the position in the shop array
     *
     * @param ItemIDid of item selected
     * @returnreturns index of item with specified id
     */
    int ShopSPotionInt(String ItemID) {
        int index = 0;
        for (int i = 0; i < ShopSPotion.size(); i++) {
            if (ShopSPotion.get(i).getId().equals(ItemID)) {
                index = i;
            }
        }
        return index;
    }

    /**
     *
     * @param ItemID id of item selected
     * @returnreturns index of item with specified id
     */
    int ShopPScrollInt(String ItemID) {
        int index = 0;
        for (int i = 0; i < ShopPScroll.size(); i++) {
            if (ShopPScroll.get(i).getId().equals(ItemID)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * returns the position in the shop array
     *
     * @param ItemID id of item selected
     * @returnreturns index of item with specified id
     */
    int ShopSScrollInt(String ItemID) {
        int index = 0;
        for (int i = 0; i < ShopSScroll.size(); i++) {
            if (ShopSScroll.get(i).getId().equals(ItemID)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * returns the position in the shop array
     *
     * @param ItemID id of item selected
     * @returnreturns index of item with specified id
     */
    int ShopWeaponInt(String ItemID) {
        int index = 0;
        for (int i = 0; i < ShopWeapon.size(); i++) {
            if (ShopWeapon.get(i).getId().equals(ItemID)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * returns the position in the shop array
     *
     * @param ItemID id of item selected
     * @returnreturns index of item with specified id
     */
    int ShopArmourInt(String ItemID) {
        int index = 0;
        for (int i = 0; i < ShopArmour.size(); i++) {
            if (ShopArmour.get(i).getId().equals(ItemID)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * shows info when clicked a item in shop
     *
     * @param pos
     */
    void shopitemClick(int pos) {
        String ItemID = "";
        String ItemType = "";
        try {
            ItemID = shopItemID.get(pos);
            ImageIcon icon = (ImageIcon) shop.get(pos).getIcon();
            ItemType = icon.getDescription();
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        btnShopBuy.setEnabled(true);
        ShopItemPos = pos;
        clearShopInfo();
        int index = 0;
        switch (ItemType) {
            case "potion":
                index = ShopPotionInt(ItemID);
                shopinfoname.setText(ShopPotion.get(index).getName());
                shopinfoprice.setText("Price: " + ShopPotion.get(index).getBuyPrice() + "");
                shopinforarity.setText("Rarity: " + ShopPotion.get(index).getRarity());
                shopinfo1.setText("Value: " + ShopPotion.get(index).getValue() + "");

                break;
            case "spotion":
                index = ShopSPotionInt(ItemID);
                shopinfoname.setText(ShopSPotion.get(index).getName());
                shopinfoprice.setText("Price: " + ShopSPotion.get(index).getBuyPrice() + "");
                shopinforarity.setText("Rarity: " + ShopSPotion.get(index).getRarity());
                shopinfo1.setText("Strength: " + ShopSPotion.get(index).getStrength() + "");
                shopinfo2.setText("Will: " + ShopSPotion.get(index).getWill() + "");
                shopinfo3.setText("Knowledge: " + ShopSPotion.get(index).getKnowledge() + "");
                shopinfo4.setText("Agility: " + ShopSPotion.get(index).getAgility() + "");

                break;
            case "pscroll":
                index = ShopPScrollInt(ItemID);
                shopinfoname.setText(ShopPScroll.get(index).getName());
                shopinfoprice.setText("Price: " + ShopPScroll.get(index).getBuyPrice() + "");
                shopinforarity.setText("Rarity: " + ShopPScroll.get(index).getRarity());
                shopinfo1.setText("Needed Knowledge: " + ShopPScroll.get(index).getNeededKnowdelge() + "");
                shopinfo2.setText("Value: " + ShopPScroll.get(index).getValue() + "");
                break;
            case "sscroll":
                index = ShopSScrollInt(ItemID);
                shopinfoname.setText(ShopSScroll.get(index).getName());
                shopinforarity.setText("Rarity: " + ShopSScroll.get(index).getRarity());
                shopinfoprice.setText("Price: " + ShopSScroll.get(index).getBuyPrice() + "");
                shopinfo1.setText("Needed Knowledge: " + ShopSScroll.get(index).getNeededKnowdelge() + "");
                shopinfo2.setText("Strength: " + ShopSScroll.get(index).getStrength() + "");
                shopinfo3.setText("Will: " + ShopSScroll.get(index).getWill() + "");
                shopinfo4.setText("Knowledge: " + ShopSScroll.get(index).getKnowledge() + "");
                shopinfo5.setText("Agility: " + ShopSScroll.get(index).getAgility() + "");
                break;
            case "weapon":
                index = ShopWeaponInt(ItemID);
                shopinfoname.setText(ShopWeapon.get(index).getName());
                shopinfoprice.setText("Price: " + ShopWeapon.get(index).getBuyPrice() + "");
                shopinforarity.setText("Rarity: " + ShopWeapon.get(index).getRarity());
                shopinfo1.setText("Weapon Damage: " + ShopWeapon.get(index).getWeaponDamage() + "");
                shopinfo2.setText("Magic Damage: " + ShopWeapon.get(index).getMagicDamage() + "");
                shopinfo3.setText("Armour Penetration: " + ShopWeapon.get(index).getArmourPenetration() + "");
                shopinfo4.setText("Magic Penetration: " + ShopWeapon.get(index).getMagicPenetration() + "");
                break;
            case "armour":
                index = ShopArmourInt(ItemID);
                shopinfoname.setText(ShopArmour.get(index).getName());
                shopinfoprice.setText("Price: " + ShopArmour.get(index).getBuyPrice() + "");
                shopinforarity.setText("Rarity: " + ShopArmour.get(index).getRarity());
                shopinfo1.setText("PDR: " + ShopArmour.get(index).getPDR() + "");
                shopinfo2.setText("MDR " + ShopArmour.get(index).getMDR() + "");
                shopinfo3.setText("Strength: " + ShopArmour.get(index).getStrength() + "");
                shopinfo4.setText("Will: " + ShopArmour.get(index).getWill() + "");
                shopinfo5.setText("Knowledge: " + ShopArmour.get(index).getKnowledge() + "");
                shopinfo6.setText("Agility: " + ShopArmour.get(index).getAgility() + "");
                break;
        }
    }

    /**
     * shows info when item is selected in sell shop
     *
     * @param pos
     */
    void sellitemClick(int pos) {
        String ItemID = "";
        String ItemType = "";
        try {
            ItemID = sellItemId.get(pos);
            ImageIcon icon = (ImageIcon) sell.get(pos).getIcon();
            ItemType = icon.getDescription();
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        sellItemPos = pos;
        clearSellInfo();
        int index = 0;
        switch (ItemType) {
            case "potion":
                index = InvPotionInt(ItemID);
                sellName.setText(InvPotion.get(index).getName());
                sellRarity.setText("Rarity: " + InvPotion.get(index).getRarity());
                sellSell.setText("Price: " + InvPotion.get(index).getSellPrice() + "");
                sellinfo1.setText("Value: " + InvPotion.get(index).getValue() + "");

                break;
            case "spotion":
                index = InvSPotionInt(ItemID);
                sellName.setText(InvSPotion.get(index).getName());
                sellRarity.setText("Rarity: " + InvSPotion.get(index).getRarity());
                sellSell.setText("Price: " + InvSPotion.get(index).getSellPrice() + "");
                sellinfo1.setText("Strength: " + InvSPotion.get(index).getStrength() + "");
                sellinfo2.setText("Will: " + InvSPotion.get(index).getWill() + "");
                sellinfo3.setText("Knowledge: " + InvSPotion.get(index).getKnowledge() + "");
                sellinfo4.setText("Agility: " + InvSPotion.get(index).getAgility() + "");

                break;
            case "pscroll":
                index = InvPScrollInt(ItemID);
                sellName.setText(InvPScroll.get(index).getName());
                sellRarity.setText("Rarity: " + InvPScroll.get(index).getRarity());
                sellSell.setText("Price: " + InvPScroll.get(index).getSellPrice() + "");
                sellinfo1.setText("Needed Knowledge: " + InvPScroll.get(index).getNeededKnowdelge() + "");
                sellinfo2.setText("Value: " + InvPScroll.get(index).getValue() + "");
                break;
            case "sscroll":
                index = InvSScrollInt(ItemID);
                sellName.setText(InvSScroll.get(index).getName());
                sellRarity.setText("Rarity: " + InvSScroll.get(index).getRarity());
                sellSell.setText("Price: " + InvSScroll.get(index).getSellPrice() + "");
                sellinfo1.setText("Needed Knowledge: " + InvSScroll.get(index).getNeededKnowdelge() + "");
                sellinfo2.setText("Strength: " + InvSScroll.get(index).getStrength() + "");
                sellinfo3.setText("Will: " + InvSScroll.get(index).getWill() + "");
                sellinfo4.setText("Knowledge: " + InvSScroll.get(index).getKnowledge() + "");
                sellinfo5.setText("Agility: " + InvSScroll.get(index).getAgility() + "");
                break;
            case "weapon":
                index = InvWeaponInt(ItemID);
                sellName.setText(InvWeapon.get(index).getName());
                sellRarity.setText("Rarity: " + InvWeapon.get(index).getRarity());
                sellSell.setText("Price: " + InvWeapon.get(index).getSellPrice() + "");
                sellinfo1.setText("Weapon Damage: " + InvWeapon.get(index).getWeaponDamage() + "");
                sellinfo2.setText("Magic Damage: " + InvWeapon.get(index).getMagicDamage() + "");
                sellinfo3.setText("Armour Penetration: " + InvWeapon.get(index).getArmourPenetration() + "");
                sellinfo4.setText("Magic Penetration: " + InvWeapon.get(index).getMagicPenetration() + "");

                break;
            case "armour":
                index = InvArmourInt(ItemID);
                sellName.setText(InvArmour.get(index).getName());
                sellRarity.setText("Rarity: " + InvArmour.get(index).getRarity());
                sellSell.setText("Price: " + InvArmour.get(index).getSellPrice() + "");
                sellinfo1.setText("PDR: " + InvArmour.get(index).getPDR() + "");
                sellinfo2.setText("MDR " + InvArmour.get(index).getMDR() + "");
                sellinfo3.setText("Strength: " + InvArmour.get(index).getStrength() + "");
                sellinfo4.setText("Will: " + InvArmour.get(index).getWill() + "");
                sellinfo5.setText("Knowledge: " + InvArmour.get(index).getKnowledge() + "");
                sellinfo6.setText("Agility: " + InvArmour.get(index).getAgility() + "");

                break;
        }
    }

    // |--------------------------------------------------------------------------------|
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtfUsername = new javax.swing.JTextField();
        txtfPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jLabel142 = new javax.swing.JLabel();
        lblErrorLogin = new javax.swing.JLabel();
        pRegister = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtfUsernameRegister = new javax.swing.JTextField();
        pfPasswordRegister = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAddAccount = new javax.swing.JButton();
        lblErrorRegister = new javax.swing.JLabel();
        btnRegisterBack = new javax.swing.JButton();
        pCharacterSelect = new javax.swing.JPanel();
        CSImage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnChooseCharacter = new javax.swing.JButton();
        btnCreateCharacter = new javax.swing.JButton();
        btnCharacterNext = new javax.swing.JButton();
        btnCharacterReturn = new javax.swing.JButton();
        btnCharacterSelectExit = new javax.swing.JButton();
        lblCSname = new javax.swing.JLabel();
        lblCSLevel = new javax.swing.JLabel();
        pCharacterCreate = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtfCCPlayerName = new javax.swing.JTextField();
        CCimagePlayer = new javax.swing.JLabel();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnSplus = new javax.swing.JButton();
        btnSminus = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        lblCCPointsRemaining = new javax.swing.JLabel();
        lblCCS = new javax.swing.JLabel();
        lblCCW = new javax.swing.JLabel();
        lblCCK = new javax.swing.JLabel();
        lblCCA = new javax.swing.JLabel();
        btnWplus = new javax.swing.JButton();
        btnWminus = new javax.swing.JButton();
        btnKplus = new javax.swing.JButton();
        btnKminus = new javax.swing.JButton();
        btnAminus = new javax.swing.JButton();
        btnAplus = new javax.swing.JButton();
        CCweaponImage = new javax.swing.JLabel();
        btnNextWeapon = new javax.swing.JButton();
        btnBackWeapon = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btncharacterCreateLeave = new javax.swing.JButton();
        btnCharacterCreate = new javax.swing.JButton();
        lblCCWD = new javax.swing.JLabel();
        lblCCMD = new javax.swing.JLabel();
        lblCCAP = new javax.swing.JLabel();
        lblCCMP = new javax.swing.JLabel();
        lblCCweaponName = new javax.swing.JLabel();
        lblCCerror = new javax.swing.JLabel();
        pForest = new javax.swing.JPanel();
        jPanel93 = new javax.swing.JPanel();
        lblForestName = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        lblForestLevel = new javax.swing.JLabel();
        lblForestExp = new javax.swing.JLabel();
        lblForestGold = new javax.swing.JLabel();
        lblForestHealth = new javax.swing.JLabel();
        lblForestPlayerImage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnForestGo = new javax.swing.JButton();
        btnForestInv = new javax.swing.JButton();
        btnForestStats = new javax.swing.JButton();
        btnSaveAndExitForest = new javax.swing.JButton();
        lblBackgroundForest = new javax.swing.JLabel();
        pBattleForest = new javax.swing.JPanel();
        pcontrolBatF = new javax.swing.JPanel();
        btnBattleInv = new javax.swing.JButton();
        btnBattleRunAway = new javax.swing.JButton();
        btnAttack = new javax.swing.JButton();
        lblForestBattlePlayer = new javax.swing.JLabel();
        lblForestBattleMonster = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblbattleForestPlayerHP = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        MonsterDamageF = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblFBshield = new javax.swing.JLabel();
        lblminShield = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        MNameBat = new javax.swing.JLabel();
        MlevelBat = new javax.swing.JLabel();
        MHealthBat = new javax.swing.JLabel();
        PlayerDamageF = new javax.swing.JLabel();
        pnlFBat = new javax.swing.JPanel();
        lblFbatInfo = new javax.swing.JLabel();
        btnFBatbut = new javax.swing.JButton();
        lblFBGold = new javax.swing.JLabel();
        lblFBXP = new javax.swing.JLabel();
        lblForestBackgroundBattle = new javax.swing.JLabel();
        pInventory = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnInvUse = new javax.swing.JButton();
        btnInvEquip = new javax.swing.JButton();
        btnInvRemove = new javax.swing.JButton();
        btnInvDrop = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnExitInv = new javax.swing.JButton();
        lblInvName = new javax.swing.JLabel();
        lblInvRarity = new javax.swing.JLabel();
        lblInvSell = new javax.swing.JLabel();
        lblInvinfo1 = new javax.swing.JLabel();
        lblInvinfo2 = new javax.swing.JLabel();
        lblInvinfo3 = new javax.swing.JLabel();
        lblInvinfo4 = new javax.swing.JLabel();
        lblInvinfo5 = new javax.swing.JLabel();
        lblInvinfo6 = new javax.swing.JLabel();
        lvlInvNotice = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblInv1 = new javax.swing.JLabel();
        lblInv2 = new javax.swing.JLabel();
        lblInv4 = new javax.swing.JLabel();
        lblInv5 = new javax.swing.JLabel();
        lblInv3 = new javax.swing.JLabel();
        lblInv7 = new javax.swing.JLabel();
        lblInv8 = new javax.swing.JLabel();
        lblInv6 = new javax.swing.JLabel();
        lblInv9 = new javax.swing.JLabel();
        lblInv10 = new javax.swing.JLabel();
        lblInv11 = new javax.swing.JLabel();
        lblInv12 = new javax.swing.JLabel();
        lblInv13 = new javax.swing.JLabel();
        lblInv14 = new javax.swing.JLabel();
        lblInv15 = new javax.swing.JLabel();
        lblInv16 = new javax.swing.JLabel();
        lblInv17 = new javax.swing.JLabel();
        lblInv18 = new javax.swing.JLabel();
        lblInv19 = new javax.swing.JLabel();
        lblInv20 = new javax.swing.JLabel();
        lblInv21 = new javax.swing.JLabel();
        lblInv22 = new javax.swing.JLabel();
        lblInv23 = new javax.swing.JLabel();
        lblInv24 = new javax.swing.JLabel();
        lblInv25 = new javax.swing.JLabel();
        lblInv26 = new javax.swing.JLabel();
        lblInv27 = new javax.swing.JLabel();
        lblInv28 = new javax.swing.JLabel();
        lblInv29 = new javax.swing.JLabel();
        lblInv30 = new javax.swing.JLabel();
        lblInv31 = new javax.swing.JLabel();
        lblInv32 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        lblInvArmour = new javax.swing.JLabel();
        lblInvWeapon = new javax.swing.JLabel();
        pStats = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        lblStatW = new javax.swing.JLabel();
        lblStatK = new javax.swing.JLabel();
        lblStatA = new javax.swing.JLabel();
        lblStatS = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        lblStatsPoints = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        lblStatsLevel = new javax.swing.JLabel();
        lblStatsExp = new javax.swing.JLabel();
        btnStatsBack = new javax.swing.JButton();
        btnStatS = new javax.swing.JButton();
        btnStatK = new javax.swing.JButton();
        btnStatA = new javax.swing.JButton();
        btnStatW = new javax.swing.JButton();
        lblStatsPlayer = new javax.swing.JLabel();
        pVillage = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        btnVillageLeave = new javax.swing.JButton();
        btnVillageInv = new javax.swing.JButton();
        btnVillageStats = new javax.swing.JButton();
        lblVillageP = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel94 = new javax.swing.JPanel();
        lblVillageName = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        lblVillageLevel = new javax.swing.JLabel();
        lblVillageExp = new javax.swing.JLabel();
        lblVillageGold = new javax.swing.JLabel();
        lblVillageHealth = new javax.swing.JLabel();
        BackgroundVillage = new javax.swing.JLabel();
        pInn = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        PlayerInn = new javax.swing.JLabel();
        jPanel95 = new javax.swing.JPanel();
        lblInnName = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        lblInnLevel = new javax.swing.JLabel();
        lblInnExp = new javax.swing.JLabel();
        lblInnGold = new javax.swing.JLabel();
        lblInnHealth = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblInnInfo = new javax.swing.JLabel();
        InnBackground = new javax.swing.JLabel();
        pShop = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        btnShopLeave = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        btnShopBuy = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        lblShopGold = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        shop9 = new javax.swing.JLabel();
        shop5 = new javax.swing.JLabel();
        shop6 = new javax.swing.JLabel();
        shop7 = new javax.swing.JLabel();
        shop8 = new javax.swing.JLabel();
        shop0 = new javax.swing.JLabel();
        shop1 = new javax.swing.JLabel();
        shop2 = new javax.swing.JLabel();
        shop3 = new javax.swing.JLabel();
        shop4 = new javax.swing.JLabel();
        shopBack = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        shopinfoprice = new javax.swing.JLabel();
        shopinforarity = new javax.swing.JLabel();
        shopinfoname = new javax.swing.JLabel();
        shopinfo1 = new javax.swing.JLabel();
        shopinfo2 = new javax.swing.JLabel();
        shopinfo3 = new javax.swing.JLabel();
        shopinfo5 = new javax.swing.JLabel();
        shopinfo4 = new javax.swing.JLabel();
        shopinfo6 = new javax.swing.JLabel();
        pSell = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        sell1 = new javax.swing.JLabel();
        sell2 = new javax.swing.JLabel();
        sell3 = new javax.swing.JLabel();
        sell4 = new javax.swing.JLabel();
        sell5 = new javax.swing.JLabel();
        sell6 = new javax.swing.JLabel();
        sell7 = new javax.swing.JLabel();
        sell8 = new javax.swing.JLabel();
        sell9 = new javax.swing.JLabel();
        sell10 = new javax.swing.JLabel();
        sell11 = new javax.swing.JLabel();
        sell12 = new javax.swing.JLabel();
        sell13 = new javax.swing.JLabel();
        sell14 = new javax.swing.JLabel();
        sell15 = new javax.swing.JLabel();
        sell16 = new javax.swing.JLabel();
        sell17 = new javax.swing.JLabel();
        sell18 = new javax.swing.JLabel();
        sell19 = new javax.swing.JLabel();
        sell20 = new javax.swing.JLabel();
        sell21 = new javax.swing.JLabel();
        sell22 = new javax.swing.JLabel();
        sell23 = new javax.swing.JLabel();
        sell24 = new javax.swing.JLabel();
        sell25 = new javax.swing.JLabel();
        sell26 = new javax.swing.JLabel();
        sell27 = new javax.swing.JLabel();
        sell28 = new javax.swing.JLabel();
        sell29 = new javax.swing.JLabel();
        sell30 = new javax.swing.JLabel();
        sell31 = new javax.swing.JLabel();
        sell32 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        btnExitInv1 = new javax.swing.JButton();
        btnSell = new javax.swing.JButton();
        sellGold = new javax.swing.JLabel();
        sellName = new javax.swing.JLabel();
        sellRarity = new javax.swing.JLabel();
        sellSell = new javax.swing.JLabel();
        sellinfo1 = new javax.swing.JLabel();
        sellinfo2 = new javax.swing.JLabel();
        sellinfo3 = new javax.swing.JLabel();
        sellinfo4 = new javax.swing.JLabel();
        sellinfo5 = new javax.swing.JLabel();
        sellinfo6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Roots of Ruin");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pLogin.setPreferredSize(new java.awt.Dimension(1150, 590));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel2.setText("Roots of Ruin");

        jLabel3.setText("Username:");

        jLabel4.setText("Password:");

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel142.setText("If you don't have an account register here ");

        lblErrorLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pLoginLayout = new javax.swing.GroupLayout(pLogin);
        pLogin.setLayout(pLoginLayout);
        pLoginLayout.setHorizontalGroup(
            pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLoginLayout.createSequentialGroup()
                .addContainerGap(438, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(434, 434, 434))
            .addGroup(pLoginLayout.createSequentialGroup()
                .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLoginLayout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(jLabel1))
                    .addGroup(pLoginLayout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pLoginLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pLoginLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pLoginLayout.createSequentialGroup()
                        .addGap(526, 526, 526)
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pLoginLayout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jLabel142))
                    .addGroup(pLoginLayout.createSequentialGroup()
                        .addGap(523, 523, 523)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pLoginLayout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(lblErrorLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pLoginLayout.setVerticalGroup(
            pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLoginLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblErrorLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel142)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegister)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        getContentPane().add(pLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1150, 590));

        pRegister.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel5.setText("Register");

        jLabel6.setText("Username:");

        jLabel7.setText("Password:");

        btnAddAccount.setText("Register");
        btnAddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAccountActionPerformed(evt);
            }
        });

        lblErrorRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnRegisterBack.setText("Back");
        btnRegisterBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pRegisterLayout = new javax.swing.GroupLayout(pRegister);
        pRegister.setLayout(pRegisterLayout);
        pRegisterLayout.setHorizontalGroup(
            pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegisterLayout.createSequentialGroup()
                .addGroup(pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pRegisterLayout.createSequentialGroup()
                        .addGap(524, 524, 524)
                        .addComponent(jLabel5))
                    .addGroup(pRegisterLayout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addGroup(pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(25, 25, 25)
                        .addGroup(pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtfUsernameRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(pfPasswordRegister)))
                    .addGroup(pRegisterLayout.createSequentialGroup()
                        .addGap(514, 514, 514)
                        .addGroup(pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegisterBack, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pRegisterLayout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(lblErrorRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        pRegisterLayout.setVerticalGroup(
            pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegisterLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addGap(56, 56, 56)
                .addGroup(pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfUsernameRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfPasswordRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(33, 33, 33)
                .addComponent(btnAddAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegisterBack)
                .addGap(26, 26, 26)
                .addComponent(lblErrorRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        getContentPane().add(pRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1150, 590));

        pCharacterSelect.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Name : ");

        jLabel10.setText("Level : ");

        btnChooseCharacter.setText("Choose");
        btnChooseCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseCharacterActionPerformed(evt);
            }
        });

        btnCreateCharacter.setText("Create");
        btnCreateCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCharacterActionPerformed(evt);
            }
        });

        btnCharacterNext.setText(">");
        btnCharacterNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCharacterNextActionPerformed(evt);
            }
        });

        btnCharacterReturn.setText("<");
        btnCharacterReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCharacterReturnActionPerformed(evt);
            }
        });

        btnCharacterSelectExit.setText("Exit");
        btnCharacterSelectExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCharacterSelectExitActionPerformed(evt);
            }
        });

        lblCSname.setText("name");

        lblCSLevel.setText("lvl");

        javax.swing.GroupLayout pCharacterSelectLayout = new javax.swing.GroupLayout(pCharacterSelect);
        pCharacterSelect.setLayout(pCharacterSelectLayout);
        pCharacterSelectLayout.setHorizontalGroup(
            pCharacterSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCharacterSelectLayout.createSequentialGroup()
                .addGap(0, 421, Short.MAX_VALUE)
                .addComponent(btnCharacterReturn)
                .addGap(32, 32, 32)
                .addComponent(CSImage, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnCharacterNext)
                .addGap(427, 427, 427))
            .addGroup(pCharacterSelectLayout.createSequentialGroup()
                .addGroup(pCharacterSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCharacterSelectLayout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addGroup(pCharacterSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pCharacterSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCSname, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(lblCSLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pCharacterSelectLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(pCharacterSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCharacterSelectExit)
                            .addComponent(btnCreateCharacter)))
                    .addGroup(pCharacterSelectLayout.createSequentialGroup()
                        .addGap(527, 527, 527)
                        .addComponent(btnChooseCharacter)))
                .addContainerGap(496, Short.MAX_VALUE))
        );
        pCharacterSelectLayout.setVerticalGroup(
            pCharacterSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCharacterSelectLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnCreateCharacter)
                .addGroup(pCharacterSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCharacterSelectLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(pCharacterSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCharacterNext, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCharacterReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(pCharacterSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblCSname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pCharacterSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lblCSLevel))
                        .addGap(18, 18, 18)
                        .addComponent(btnChooseCharacter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(btnCharacterSelectExit)
                        .addGap(82, 82, 82))
                    .addGroup(pCharacterSelectLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(CSImage, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(pCharacterSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1150, 590));

        pCharacterCreate.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pCharacterCreate.setMinimumSize(new java.awt.Dimension(1150, 590));
        pCharacterCreate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("Name:");
        pCharacterCreate.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 63, -1, -1));
        pCharacterCreate.add(txtfCCPlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 60, 151, -1));
        pCharacterCreate.add(CCimagePlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 190, 190));

        rbMale.setText("Male");
        rbMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMaleActionPerformed(evt);
            }
        });
        pCharacterCreate.add(rbMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 120, 98, -1));

        rbFemale.setText("Female");
        rbFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemaleActionPerformed(evt);
            }
        });
        pCharacterCreate.add(rbFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 153, 98, -1));

        jLabel13.setText("Strength : ");
        pCharacterCreate.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        jLabel14.setText("Will : ");
        pCharacterCreate.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jLabel15.setText("Knowledge : ");
        pCharacterCreate.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, -1, -1));

        jLabel16.setText(" Agility : ");
        pCharacterCreate.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, -1, 20));

        btnSplus.setText("+");
        btnSplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSplusActionPerformed(evt);
            }
        });
        pCharacterCreate.add(btnSplus, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        btnSminus.setText("-");
        btnSminus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSminusActionPerformed(evt);
            }
        });
        pCharacterCreate.add(btnSminus, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        jLabel17.setText("Remaining Points : ");
        pCharacterCreate.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        lblCCPointsRemaining.setText("10");
        pCharacterCreate.add(lblCCPointsRemaining, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 43, -1));

        lblCCS.setText("10");
        pCharacterCreate.add(lblCCS, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));

        lblCCW.setText("10");
        pCharacterCreate.add(lblCCW, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));

        lblCCK.setText("10");
        pCharacterCreate.add(lblCCK, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, -1, -1));

        lblCCA.setText("10");
        pCharacterCreate.add(lblCCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 20, 20));

        btnWplus.setText("+");
        btnWplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWplusActionPerformed(evt);
            }
        });
        pCharacterCreate.add(btnWplus, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, -1, -1));

        btnWminus.setText("-");
        btnWminus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWminusActionPerformed(evt);
            }
        });
        pCharacterCreate.add(btnWminus, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, -1, -1));

        btnKplus.setText("+");
        btnKplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKplusActionPerformed(evt);
            }
        });
        pCharacterCreate.add(btnKplus, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, -1, -1));

        btnKminus.setText("-");
        btnKminus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKminusActionPerformed(evt);
            }
        });
        pCharacterCreate.add(btnKminus, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, -1, -1));

        btnAminus.setText("-");
        btnAminus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAminusActionPerformed(evt);
            }
        });
        pCharacterCreate.add(btnAminus, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, -1, -1));

        btnAplus.setText("+");
        btnAplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplusActionPerformed(evt);
            }
        });
        pCharacterCreate.add(btnAplus, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, -1, -1));
        pCharacterCreate.add(CCweaponImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 190, 190));

        btnNextWeapon.setText("Next");
        btnNextWeapon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextWeaponActionPerformed(evt);
            }
        });
        pCharacterCreate.add(btnNextWeapon, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        btnBackWeapon.setText("Back");
        btnBackWeapon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackWeaponActionPerformed(evt);
            }
        });
        pCharacterCreate.add(btnBackWeapon, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));

        jLabel24.setText("Weapon Damage :");
        pCharacterCreate.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, -1, 20));

        jLabel25.setText(" Magic Damage :");
        pCharacterCreate.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, -1, -1));

        jLabel26.setText("Armour Penetration :");
        pCharacterCreate.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, -1, 20));

        jLabel27.setText("  Magic Penetration :");
        pCharacterCreate.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, -1, 20));

        btncharacterCreateLeave.setText("Leave");
        btncharacterCreateLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncharacterCreateLeaveActionPerformed(evt);
            }
        });
        pCharacterCreate.add(btncharacterCreateLeave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        btnCharacterCreate.setText("Create");
        btnCharacterCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCharacterCreateActionPerformed(evt);
            }
        });
        pCharacterCreate.add(btnCharacterCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 220, -1, -1));

        lblCCWD.setText("0");
        pCharacterCreate.add(lblCCWD, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, 20, -1));

        lblCCMD.setText("0");
        pCharacterCreate.add(lblCCMD, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 430, 20, 20));

        lblCCAP.setText("0");
        pCharacterCreate.add(lblCCAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 460, 20, -1));

        lblCCMP.setText("0");
        pCharacterCreate.add(lblCCMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 490, 20, -1));

        lblCCweaponName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCCweaponName.setText("Name");
        pCharacterCreate.add(lblCCweaponName, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 120, -1));

        lblCCerror.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pCharacterCreate.add(lblCCerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 320, 20));

        getContentPane().add(pCharacterCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1150, 590));

        pForest.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pForest.setMaximumSize(new java.awt.Dimension(1150, 590));
        pForest.setMinimumSize(new java.awt.Dimension(1150, 590));
        pForest.setPreferredSize(new java.awt.Dimension(1150, 590));
        pForest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel93.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblForestName.setText("name");

        jLabel35.setText("Level :");

        jLabel36.setText("Experience :");

        jLabel37.setText("Gold :");

        jLabel42.setText("Health :");

        lblForestLevel.setText("0");

        lblForestExp.setText("0");

        lblForestGold.setText("0");

        lblForestHealth.setText("80/100");

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblForestName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel93Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblForestLevel))
                    .addGroup(jPanel93Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblForestExp))
                    .addGroup(jPanel93Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblForestGold))
                    .addGroup(jPanel93Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblForestHealth)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblForestName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lblForestLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(lblForestExp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lblForestGold))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(lblForestHealth))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pForest.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 150, 130));

        lblForestPlayerImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pForest.add(lblForestPlayerImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 150, 150));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnForestGo.setText("Go Forward");
        btnForestGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForestGoActionPerformed(evt);
            }
        });

        btnForestInv.setText("Inventory");
        btnForestInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForestInvActionPerformed(evt);
            }
        });

        btnForestStats.setText("Stats");
        btnForestStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForestStatsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnForestInv, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnForestStats, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnForestGo)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnForestGo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnForestInv)
                    .addComponent(btnForestStats))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pForest.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 460, 220, -1));

        btnSaveAndExitForest.setText("Save and Exit");
        btnSaveAndExitForest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAndExitForestActionPerformed(evt);
            }
        });
        pForest.add(btnSaveAndExitForest, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        pForest.add(lblBackgroundForest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 590));

        getContentPane().add(pForest, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1150, 590));

        pBattleForest.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pBattleForest.setMaximumSize(new java.awt.Dimension(1150, 590));
        pBattleForest.setMinimumSize(new java.awt.Dimension(1150, 590));
        pBattleForest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pcontrolBatF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnBattleInv.setText("Inventory");
        btnBattleInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBattleInvActionPerformed(evt);
            }
        });

        btnBattleRunAway.setText("Run Away");
        btnBattleRunAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBattleRunAwayActionPerformed(evt);
            }
        });

        btnAttack.setText("Attack");
        btnAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pcontrolBatFLayout = new javax.swing.GroupLayout(pcontrolBatF);
        pcontrolBatF.setLayout(pcontrolBatFLayout);
        pcontrolBatFLayout.setHorizontalGroup(
            pcontrolBatFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcontrolBatFLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnAttack)
                .addGap(18, 18, 18)
                .addComponent(btnBattleInv, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(pcontrolBatFLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnBattleRunAway, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pcontrolBatFLayout.setVerticalGroup(
            pcontrolBatFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcontrolBatFLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnBattleRunAway)
                .addGap(18, 18, 18)
                .addGroup(pcontrolBatFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBattleInv)
                    .addComponent(btnAttack))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pBattleForest.add(pcontrolBatF, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, 220, -1));
        pBattleForest.add(lblForestBattlePlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 160, 160));
        pBattleForest.add(lblForestBattleMonster, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 160, 160));

        lblbattleForestPlayerHP.setText("100 / 100");

        jLabel41.setText("Health :");

        MonsterDamageF.setText("jLabel8");

        jLabel18.setText("Shield : ");

        lblFBshield.setText("0");

        lblminShield.setText("jLabel19");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblbattleForestPlayerHP)
                        .addGap(12, 12, 12)
                        .addComponent(MonsterDamageF, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFBshield, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblminShield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblFBshield)
                    .addComponent(lblminShield))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(lblbattleForestPlayerHP)
                    .addComponent(MonsterDamageF))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pBattleForest.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 180, 80));

        MNameBat.setText("Monster Name");

        MlevelBat.setText("Monster Level");

        MHealthBat.setText("HP: 100");

        PlayerDamageF.setText("jLabel8");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(MHealthBat)
                        .addGap(26, 26, 26)
                        .addComponent(PlayerDamageF, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(MlevelBat)
                    .addComponent(MNameBat))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(MNameBat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MlevelBat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MHealthBat)
                    .addComponent(PlayerDamageF))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pBattleForest.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 150, 110));

        pnlFBat.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFbatInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFbatInfo.setText("jLabel8");

        btnFBatbut.setText("jButton1");
        btnFBatbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFBatbutActionPerformed(evt);
            }
        });

        lblFBGold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFBGold.setText("jLabel8");

        lblFBXP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFBXP.setText("jLabel8");

        javax.swing.GroupLayout pnlFBatLayout = new javax.swing.GroupLayout(pnlFBat);
        pnlFBat.setLayout(pnlFBatLayout);
        pnlFBatLayout.setHorizontalGroup(
            pnlFBatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFBatLayout.createSequentialGroup()
                .addGroup(pnlFBatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFBatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFbatInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFBatLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnFBatbut)
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addGroup(pnlFBatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFBGold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFBatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFBXP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFBatLayout.setVerticalGroup(
            pnlFBatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFBatLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblFbatInfo)
                .addGap(18, 18, 18)
                .addComponent(lblFBGold)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFBXP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnFBatbut)
                .addContainerGap())
        );

        pBattleForest.add(pnlFBat, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 210, 150));
        pBattleForest.add(lblForestBackgroundBattle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 590));

        getContentPane().add(pBattleForest, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1150, 590));

        pInventory.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pInventory.setMaximumSize(new java.awt.Dimension(1150, 590));
        pInventory.setMinimumSize(new java.awt.Dimension(1150, 590));
        pInventory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnInvUse.setText("USE");
        btnInvUse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvUseActionPerformed(evt);
            }
        });

        btnInvEquip.setText("EQUIP");
        btnInvEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvEquipActionPerformed(evt);
            }
        });

        btnInvRemove.setText("REMOVE");
        btnInvRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvRemoveActionPerformed(evt);
            }
        });

        btnInvDrop.setText("DROP");
        btnInvDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvDropActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInvUse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInvRemove))
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInvDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInvEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInvUse)
                    .addComponent(btnInvEquip))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInvRemove)
                    .addComponent(btnInvDrop))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pInventory.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 360, 160));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnExitInv.setText("Exit");
        btnExitInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitInvActionPerformed(evt);
            }
        });

        lblInvName.setText("jLabel8");

        lblInvRarity.setText("jLabel8");

        lblInvSell.setText("jLabel8");

        lblInvinfo1.setText("jLabel8");

        lblInvinfo2.setText("jLabel8");

        lblInvinfo3.setText("jLabel8");

        lblInvinfo4.setText("jLabel8");

        lblInvinfo5.setText("jLabel8");

        lblInvinfo6.setText("jLabel8");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(btnExitInv)
                .addGap(124, 124, 124))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInvName, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(lblInvRarity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInvSell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInvinfo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInvinfo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInvinfo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInvinfo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInvinfo5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInvinfo6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lvlInvNotice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblInvName)
                .addGap(18, 18, 18)
                .addComponent(lblInvRarity)
                .addGap(18, 18, 18)
                .addComponent(lblInvSell)
                .addGap(18, 18, 18)
                .addComponent(lblInvinfo1)
                .addGap(18, 18, 18)
                .addComponent(lblInvinfo2)
                .addGap(18, 18, 18)
                .addComponent(lblInvinfo3)
                .addGap(18, 18, 18)
                .addComponent(lblInvinfo4)
                .addGap(18, 18, 18)
                .addComponent(lblInvinfo5)
                .addGap(18, 18, 18)
                .addComponent(lblInvinfo6)
                .addGap(67, 67, 67)
                .addComponent(lvlInvNotice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(btnExitInv)
                .addGap(32, 32, 32))
        );

        pInventory.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 320, 570));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblInv1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv1MousePressed(evt);
            }
        });

        lblInv2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv2MousePressed(evt);
            }
        });

        lblInv4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv4MousePressed(evt);
            }
        });

        lblInv5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv5MousePressed(evt);
            }
        });

        lblInv3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv3MousePressed(evt);
            }
        });

        lblInv7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv7MousePressed(evt);
            }
        });

        lblInv8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv8MousePressed(evt);
            }
        });

        lblInv6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv6MousePressed(evt);
            }
        });

        lblInv9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv9MousePressed(evt);
            }
        });

        lblInv10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv10MousePressed(evt);
            }
        });

        lblInv11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv11MousePressed(evt);
            }
        });

        lblInv12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv12MousePressed(evt);
            }
        });

        lblInv13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv13MousePressed(evt);
            }
        });

        lblInv14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv14MousePressed(evt);
            }
        });

        lblInv15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv15MousePressed(evt);
            }
        });

        lblInv16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv16MousePressed(evt);
            }
        });

        lblInv17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv17MousePressed(evt);
            }
        });

        lblInv18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv18MousePressed(evt);
            }
        });

        lblInv19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv19MousePressed(evt);
            }
        });

        lblInv20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv20MousePressed(evt);
            }
        });

        lblInv21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv21MousePressed(evt);
            }
        });

        lblInv22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv22MousePressed(evt);
            }
        });

        lblInv23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv23MousePressed(evt);
            }
        });

        lblInv24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv24MousePressed(evt);
            }
        });

        lblInv25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv25MousePressed(evt);
            }
        });

        lblInv26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv26MousePressed(evt);
            }
        });

        lblInv27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv27MousePressed(evt);
            }
        });

        lblInv28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv28MousePressed(evt);
            }
        });

        lblInv29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv29MousePressed(evt);
            }
        });

        lblInv30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv30MousePressed(evt);
            }
        });

        lblInv31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv31MousePressed(evt);
            }
        });

        lblInv32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInv32MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblInv25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInv26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInv27, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInv28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInv29, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInv30, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInv31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInv32, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lblInv17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lblInv9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lblInv1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInv8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInv8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInv16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInv24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInv32, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv30, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv27, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv29, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInv31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pInventory.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 790, 400));

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel43.setText("Equipped Items");

        lblInvArmour.setToolTipText("");
        lblInvArmour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInvArmourMousePressed(evt);
            }
        });

        lblInvWeapon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInvWeaponMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblInvArmour, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(lblInvWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInvWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInvArmour, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pInventory.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 160));

        getContentPane().add(pInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1150, 590));

        pStats.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pStats.setMaximumSize(new java.awt.Dimension(1150, 590));
        pStats.setMinimumSize(new java.awt.Dimension(1150, 590));
        pStats.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setText("  Strength:");
        pStats.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));

        jLabel55.setText("Will:");
        pStats.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, -1, -1));

        jLabel56.setText("Knwoledge:");
        pStats.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, -1, -1));

        jLabel57.setText(" Agility:");
        pStats.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, -1, -1));

        lblStatW.setText("10");
        pStats.add(lblStatW, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 20, -1));

        lblStatK.setText("10");
        pStats.add(lblStatK, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 20, -1));

        lblStatA.setText("10");
        pStats.add(lblStatA, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 20, -1));

        lblStatS.setText("10");
        pStats.add(lblStatS, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 20, -1));

        jLabel62.setText("Points Remaining:");
        pStats.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        lblStatsPoints.setText("0");
        pStats.add(lblStatsPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 43, -1));

        jLabel64.setText("Level:");
        pStats.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, -1));

        jLabel65.setText("Experience:");
        pStats.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        lblStatsLevel.setText("4");
        pStats.add(lblStatsLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 43, -1));

        lblStatsExp.setText("23 / 100");
        pStats.add(lblStatsExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));

        btnStatsBack.setText("Back");
        btnStatsBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatsBackActionPerformed(evt);
            }
        });
        pStats.add(btnStatsBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 532, -1, -1));

        btnStatS.setText("+");
        btnStatS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatSActionPerformed(evt);
            }
        });
        pStats.add(btnStatS, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, -1, -1));

        btnStatK.setText("+");
        btnStatK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatKActionPerformed(evt);
            }
        });
        pStats.add(btnStatK, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, -1, -1));

        btnStatA.setText("+");
        btnStatA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatAActionPerformed(evt);
            }
        });
        pStats.add(btnStatA, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, -1, -1));

        btnStatW.setText("+");
        btnStatW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatWActionPerformed(evt);
            }
        });
        pStats.add(btnStatW, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));
        pStats.add(lblStatsPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 362, 184, 184));

        getContentPane().add(pStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1150, 590));

        pVillage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pVillage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnVillageLeave.setText("Leave");
        btnVillageLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVillageLeaveActionPerformed(evt);
            }
        });

        btnVillageInv.setText("Inventory");
        btnVillageInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVillageInvActionPerformed(evt);
            }
        });

        btnVillageStats.setText("Stats");
        btnVillageStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVillageStatsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnVillageInv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnVillageStats, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(btnVillageLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(btnVillageLeave)
                .addGap(27, 27, 27)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVillageInv)
                    .addComponent(btnVillageStats))
                .addGap(30, 30, 30))
        );

        pVillage.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 440, -1, -1));

        lblVillageP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pVillage.add(lblVillageP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 150, 150));

        jButton8.setText("INN");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        pVillage.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 60, -1));

        jButton9.setText("SHOP");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        pVillage.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(802, 390, 70, -1));

        jPanel94.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblVillageName.setText("name");

        jLabel38.setText("Level :");

        jLabel39.setText("Experience :");

        jLabel40.setText("Gold :");

        jLabel44.setText("Health :");

        lblVillageLevel.setText("0");

        lblVillageExp.setText("0");

        lblVillageGold.setText("0");

        lblVillageHealth.setText("80/100");

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVillageName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel94Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVillageLevel))
                    .addGroup(jPanel94Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblVillageExp))
                    .addGroup(jPanel94Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVillageGold))
                    .addGroup(jPanel94Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVillageHealth)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblVillageName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(lblVillageLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(lblVillageExp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(lblVillageGold))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(lblVillageHealth))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pVillage.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 150, 130));
        pVillage.add(BackgroundVillage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 590));

        getContentPane().add(pVillage, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1150, 590));

        pInn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pInn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel40.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel40.setMaximumSize(new java.awt.Dimension(280, 120));
        jPanel40.setMinimumSize(new java.awt.Dimension(280, 120));
        jPanel40.setPreferredSize(new java.awt.Dimension(280, 120));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton12.setText("Spend Night");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel40.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        jButton10.setText("Leave");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel40.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 96, -1));

        jButton11.setText("Rest");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel40.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 96, -1));

        pInn.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, 260, 110));

        PlayerInn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pInn.add(PlayerInn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 150, 150));

        jPanel95.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblInnName.setText("name");

        jLabel45.setText("Level :");

        jLabel46.setText("Experience :");

        jLabel47.setText("Gold :");

        jLabel48.setText("Health :");

        lblInnLevel.setText("0");

        lblInnExp.setText("0");

        lblInnGold.setText("0");

        lblInnHealth.setText("80/100");

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInnName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInnLevel))
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInnExp))
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInnGold))
                    .addGroup(jPanel95Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInnHealth)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblInnName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(lblInnLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(lblInnExp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(lblInnGold))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(lblInnHealth))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pInn.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 150, 130));

        jLabel8.setText("Rest: 15 HP 5 Gold");

        jLabel12.setText("Night: full HP 30 gold");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(lblInnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(lblInnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pInn.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 170, 120));
        pInn.add(InnBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1150, 590));

        getContentPane().add(pInn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1150, 590));

        pShop.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel41.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnShopLeave.setText("Leave");
        btnShopLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShopLeaveActionPerformed(evt);
            }
        });

        jButton14.setText("Sell");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        btnShopBuy.setText("Buy");
        btnShopBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShopBuyActionPerformed(evt);
            }
        });

        jLabel87.setText("Gold:");

        lblShopGold.setText("12");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel87)
                        .addGap(18, 18, 18)
                        .addComponent(lblShopGold, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnShopLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnShopBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(lblShopGold))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnShopLeave)
                .addGap(18, 18, 18)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShopBuy)
                    .addComponent(jButton14))
                .addGap(46, 46, 46))
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        shop9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                shop9MousePressed(evt);
            }
        });
        jPanel42.add(shop9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 120, 120));

        shop5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                shop5MousePressed(evt);
            }
        });
        jPanel42.add(shop5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 120, 120));

        shop6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                shop6MousePressed(evt);
            }
        });
        jPanel42.add(shop6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 120, 120));

        shop7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                shop7MousePressed(evt);
            }
        });
        jPanel42.add(shop7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 120, 120));

        shop8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                shop8MousePressed(evt);
            }
        });
        jPanel42.add(shop8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 120, 120));

        shop0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                shop0MousePressed(evt);
            }
        });
        jPanel42.add(shop0, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 120, 120));

        shop1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                shop1MousePressed(evt);
            }
        });
        jPanel42.add(shop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 120, 120));

        shop2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                shop2MousePressed(evt);
            }
        });
        jPanel42.add(shop2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 120, 120));

        shop3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                shop3MousePressed(evt);
            }
        });
        jPanel42.add(shop3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 120, 120));

        shop4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                shop4MousePressed(evt);
            }
        });
        jPanel42.add(shop4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 120, 120));
        jPanel42.add(shopBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 570));

        jPanel43.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        shopinfoprice.setText("price");

        shopinforarity.setText("rarity");

        shopinfoname.setText("name");

        shopinfo1.setText("jLabel19");

        shopinfo2.setText("jLabel19");

        shopinfo3.setText("jLabel19");

        shopinfo5.setText("jLabel19");

        shopinfo4.setText("jLabel19");

        shopinfo6.setText("jLabel19");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shopinfoname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shopinfoprice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shopinforarity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shopinfo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shopinfo2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(shopinfo3, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(shopinfo5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(shopinfo4, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(shopinfo6, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(shopinfoname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shopinfoprice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shopinforarity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shopinfo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shopinfo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shopinfo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shopinfo4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shopinfo5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shopinfo6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pShopLayout = new javax.swing.GroupLayout(pShop);
        pShop.setLayout(pShopLayout);
        pShopLayout.setHorizontalGroup(
            pShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pShopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pShopLayout.setVerticalGroup(
            pShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pShopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pShopLayout.createSequentialGroup()
                        .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(pShop, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1150, 590));

        pSell.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel46.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        sell1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell1MousePressed(evt);
            }
        });

        sell2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell2MousePressed(evt);
            }
        });

        sell3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell3MousePressed(evt);
            }
        });

        sell4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell4MousePressed(evt);
            }
        });

        sell5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell5MousePressed(evt);
            }
        });

        sell6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell6MousePressed(evt);
            }
        });

        sell7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell7MousePressed(evt);
            }
        });

        sell8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell8MousePressed(evt);
            }
        });

        sell9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell9MousePressed(evt);
            }
        });

        sell10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell10MousePressed(evt);
            }
        });

        sell11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell11MousePressed(evt);
            }
        });

        sell12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell12MousePressed(evt);
            }
        });

        sell13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell13MousePressed(evt);
            }
        });

        sell14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell14MousePressed(evt);
            }
        });

        sell15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell15MousePressed(evt);
            }
        });

        sell16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell16MousePressed(evt);
            }
        });

        sell17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell17MousePressed(evt);
            }
        });

        sell18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell18MousePressed(evt);
            }
        });

        sell19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell19MousePressed(evt);
            }
        });

        sell20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell20MousePressed(evt);
            }
        });

        sell21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell21MousePressed(evt);
            }
        });

        sell22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell22MousePressed(evt);
            }
        });

        sell23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell23MousePressed(evt);
            }
        });

        sell24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell24MousePressed(evt);
            }
        });

        sell25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell25MousePressed(evt);
            }
        });

        sell26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell26MousePressed(evt);
            }
        });

        sell27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell27MousePressed(evt);
            }
        });

        sell28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell28MousePressed(evt);
            }
        });

        sell29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell29MousePressed(evt);
            }
        });

        sell30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell30MousePressed(evt);
            }
        });

        sell31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell31MousePressed(evt);
            }
        });

        sell32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sell32MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(sell25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sell26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sell27, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sell28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sell29, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sell30, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sell31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sell32, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel46Layout.createSequentialGroup()
                            .addComponent(sell17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel46Layout.createSequentialGroup()
                            .addComponent(sell9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel46Layout.createSequentialGroup()
                            .addComponent(sell1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sell8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sell8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sell16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sell24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sell32, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell30, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell27, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell29, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel87.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel87.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExitInv1.setText("Exit");
        btnExitInv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitInv1ActionPerformed(evt);
            }
        });
        jPanel87.add(btnExitInv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 505, 84, -1));

        btnSell.setText("Sell");
        btnSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSellActionPerformed(evt);
            }
        });
        jPanel87.add(btnSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 452, 84, -1));

        sellGold.setText("Gold : 14");
        jPanel87.add(sellGold, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 392, 68, -1));

        sellName.setText("jLabel8");
        jPanel87.add(sellName, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 21, 282, -1));

        sellRarity.setText("jLabel8");
        jPanel87.add(sellRarity, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 55, 282, -1));

        sellSell.setText("jLabel8");
        jPanel87.add(sellSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 89, 282, -1));

        sellinfo1.setText("jLabel8");
        jPanel87.add(sellinfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 123, 282, -1));

        sellinfo2.setText("jLabel8");
        jPanel87.add(sellinfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 157, 282, -1));

        sellinfo3.setText("jLabel8");
        jPanel87.add(sellinfo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 191, 282, -1));

        sellinfo4.setText("jLabel8");
        jPanel87.add(sellinfo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 225, 282, -1));

        sellinfo5.setText("jLabel8");
        jPanel87.add(sellinfo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 259, 282, -1));

        sellinfo6.setText("jLabel8");
        jPanel87.add(sellinfo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 293, 282, -1));

        javax.swing.GroupLayout pSellLayout = new javax.swing.GroupLayout(pSell);
        pSell.setLayout(pSellLayout);
        pSellLayout.setHorizontalGroup(
            pSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSellLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pSellLayout.setVerticalGroup(
            pSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSellLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel87, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(pSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1150, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        pLogin.setVisible(false);
        pRegister.setVisible(true);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnAddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAccountActionPerformed
        String RegisterName = txtfUsernameRegister.getText();
        String RegisterPass = pfPasswordRegister.getText();
        // check fields

        if (RegisterPass.isEmpty() || RegisterName.isEmpty()) {
            lblErrorRegister.setText("Please fill all fields");
        } else {
            addLogLine("Register", "try to register: " + RegisterName);
            // check if account exists 
            if (doesAccExist(RegisterName)) {
                // send message 
                lblErrorRegister.setText("An account with the same name already exists");
            } else {
                // add account
                lblErrorRegister.setText("Registered. Go back to the login screen");
                addAccount(RegisterName, RegisterPass, 0);
            }
        }
    }//GEN-LAST:event_btnAddAccountActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        lblErrorLogin.setText("");
        String Name = txtfUsername.getText();
        String Pass = txtfPassword.getText();
        if (Pass.isEmpty() || Name.isEmpty()) {
            lblErrorLogin.setText("Please fill all fields");
        } else {
            if (checkAccPass(Name, Pass)) {
                addLogLine("Login", "User Logged in " + Name);
                // correct
                txtfUsername.setText("");
                txtfPassword.setText("");
                AccountName = Name;
                // if no characters send to create
                // if else select
                // grab id from account table
                AccountID = grabAccID(Name);
                // grab items created
                AccountItems = getAccItemC(AccountID);
           
                // check if exists in own table
                pLogin.setVisible(false);
                if (doesAccHavePlayer(AccountID)) {
                    // has 
                    setCharacterSelect();
                    pCharacterSelect.setVisible(true);
                } else {
                    // doesn't have
                    //leave button disabled bcs no players
                    btncharacterCreateLeave.setEnabled(false);
                    // disable minus button because 10 is lowest
                    btnSminus.setEnabled(false);
                    btnWminus.setEnabled(false);
                    btnKminus.setEnabled(false);
                    btnAminus.setEnabled(false);
                    // set male
                    rbMale.setSelected(true);
                    rbMale.setEnabled(false);
                    // call function to set image for player
                    setPlayerImageCC();
                    // weapon
                    createDefaultWeaponsCC();
                    setWeaponImageCC();
                    btnBackWeapon.setEnabled(false);
                    // change screen
                    pCharacterCreate.setVisible(true);
                }
            } else {
                // incorrect
                lblErrorLogin.setText("Password incorrect");
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCharacterSelectExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCharacterSelectExitActionPerformed
        pLogin.setVisible(true);
        pCharacterSelect.setVisible(false);
    }//GEN-LAST:event_btnCharacterSelectExitActionPerformed

    private void btnCreateCharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCharacterActionPerformed
        pCharacterSelect.setVisible(false);
        btncharacterCreateLeave.setEnabled(false);
        AccountItems = getAccItemC(AccountID);

        currentPlayer.clear();
        InvPotion.clear();
        InvSPotion.clear();
        InvSScroll.clear();
        InvPScroll.clear();
        InvWeapon.clear();
        InvArmour.clear();

        // disable minus button because 10 is lowest
        btnSminus.setEnabled(false);
        btnWminus.setEnabled(false);
        btnKminus.setEnabled(false);
        btnAminus.setEnabled(false);
        // set male
        rbMale.setSelected(true);
        rbMale.setEnabled(false);
        // call function to set image for player
        setPlayerImageCC();
        // weapon
        createDefaultWeaponsCC();
        setWeaponImageCC();
        btnBackWeapon.setEnabled(false);
        CaracterSelect.clear();
        getPlayers(AccountID);
        if (CaracterSelect.size() > 0) {
            btncharacterCreateLeave.setEnabled(true);
        }
        // change screen
        pCharacterCreate.setVisible(true);


    }//GEN-LAST:event_btnCreateCharacterActionPerformed

    private void btncharacterCreateLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncharacterCreateLeaveActionPerformed
        pCharacterCreate.setVisible(false);
        SelectCharacter = 0;
        setCharacterSelect();

        // set default
        CCweaponSelector = 0;
        txtfCCPlayerName.setText("");
        rbFemale.setEnabled(true);
        rbFemale.setSelected(false);
        lblCCPointsRemaining.setText("10");
        lblCCS.setText("10");
        lblCCW.setText("10");
        lblCCK.setText("10");
        lblCCA.setText("10");
        btnNextWeapon.setEnabled(true);

        pCharacterSelect.setVisible(true);
    }//GEN-LAST:event_btncharacterCreateLeaveActionPerformed

    private void btnChooseCharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseCharacterActionPerformed
        pCharacterSelect.setVisible(false);
        currentPlayer.clear();
        currentPlayer.add(CaracterSelect.get(SelectCharacter));
        Player p = CaracterSelect.get(SelectCharacter);
        // grab weapon and armour id from player 
        String weaponID = getPlayerItem(p.getId(), "weapon");
        String armourID = getPlayerItem(p.getId(), "armour");
        // id weapon id armour go to weapon and item table grab info with id 
        createWeaponforPlayer(weaponID);
        createArmourforPlayer(armourID);
        // backpack: go to backpack get id of item, got to table grab name, if weapon/armour/potion go to table 
        CreateItemsforPlayer(p.getId());
        lastVisitedPanel = "forest";
        setForest();
        pForest.setVisible(true);
        AccountItems = getAccItemC(AccountID);

        addLogLine("character select", "choose character " + currentPlayer.getFirst().getName());
    }//GEN-LAST:event_btnChooseCharacterActionPerformed

    private void btnCharacterCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCharacterCreateActionPerformed
        lblCCerror.setText("");
        // AccountItems = getAccItemC(AccountID);
        //  check if corrent, grab data
        if (txtfCCPlayerName.getText().isBlank()) {
            lblCCerror.setText("Input a valid name");
            return;
        }
        if (Integer.parseInt(lblCCPointsRemaining.getText()) > 0) {
            lblCCerror.setText("Please use all your stat points");
            return;
        }
        // add item, add weapon, add armour, add player, add own 
        String name = txtfCCPlayerName.getText();
        String playerModel = "";
        if (rbMale.isSelected()) {
            playerModel = "src/Images/playerMan.jpg";
        } else {
            playerModel = "src/Images/playerWoman.jpg";
        }
        int str = Integer.parseInt(lblCCS.getText());
        int will = Integer.parseInt(lblCCW.getText());
        int knw = Integer.parseInt(lblCCK.getText());
        int agi = Integer.parseInt(lblCCA.getText());

        // CCdefaultWeapons.get(CCweaponSelector)
        // ccd default is array of defualt weapons // wep sel variable for selected item
        Weapon w = CCdefaultWeapons.get(CCweaponSelector);
        // add item (weapon)
        addItem(w.getId(), w.getName(), w.getSellPrice(), w.getBuyPrice(), w.getRarity(), w.getImage());
        // create armour

        AccountItems++;
       
        CCdefaultArmour.add(new Armour(30, 12, 0, 0, 0, 1, AccountID + "-" + AccountItems, "Cloth Armour", 3, 6, "common", "src/Images/clothArmour.jpg"));
        // add weapon (weapon)
        addWeapon(w.getId(), w.getWeaponDamage(), w.getMagicDamage(), w.getArmourPenetration(), w.getMagicPenetration());
        // add item (armour)
        Armour a = CCdefaultArmour.get(0);

        addItem(a.getId(), a.getName(), a.getSellPrice(), a.getBuyPrice(), a.getRarity(), a.getImage());
        // add armour (armour)
        addArmour(a.getId(), a.getPDR(), a.getMDR(), a.getStrength(), a.getWill(), a.getKnowledge(), a.getAgility());

        // create player 
        int CharacterCount = returnCharacterCountPlayer(AccountID);
        currentPlayer.add(new Player(AccountName + CharacterCount, name, playerModel, 1, 0, 20, 100, 100, 0, str, will, knw, agi, 0));
        currentPlayer.getFirst().addArmour(a);
        currentPlayer.getFirst().addWeapon(w);

        // add player
        Player p = currentPlayer.getFirst();

        addPlayer(p.getId(), p.getName(), p.getPlayerModel(), p.getLevel(), p.getExp(), p.getGold(), p.getMaxHP(), p.getCurrentHP(), p.getShield(), p.getStrength(), p.getWill(), p.getKnowledge(), p.getAgility(), p.getWeapon(), p.getArmour(), p.getDungeonsCleared(), "none");

        // add own 
        addOwner(AccountID, AccountName + CharacterCount);

        // add potions to player
        for (int i = 0; i < 3; i++) {
            AccountItems++;
    
            InvPotion.add(new Potion(20, "HP", AccountID + "-" + AccountItems, "Healing Potion", 2, 4, "Common", "src/Images/Hppotion.jpg"));
            // add to database
            Potion pot = InvPotion.getLast();
            addItem(pot.getId(), pot.getName(), pot.getSellPrice(), pot.getBuyPrice(), pot.getRarity(), pot.getImage());
            addPotion(pot.getId(), pot.getValue(), pot.getType());
            addItemTOInventory(AccountName + CharacterCount, pot.getId());
        }
        addItemCountToAcc(AccountID, AccountItems);

        pCharacterCreate.setVisible(false);
        // set images and such in forest
        lastVisitedPanel = "forest";
        setForest();
        pForest.setVisible(true);
        CCweaponSelector = 0;
        txtfCCPlayerName.setText("");
        rbFemale.setEnabled(true);
        rbFemale.setSelected(false);
        lblCCPointsRemaining.setText("10");
        lblCCS.setText("10");
        lblCCW.setText("10");
        lblCCK.setText("10");
        lblCCA.setText("10");
        btnNextWeapon.setEnabled(true);
        addLogLine("Create character", "created character " + p.getName());
    }//GEN-LAST:event_btnCharacterCreateActionPerformed

    private void btnForestStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForestStatsActionPerformed
        pForest.setVisible(false);
        lastVisitedPanel = "forest";
        // 
        addLogLine("forest", "entered stats");
        setStats();
        setStatButton();
        pStats.setVisible(true);
    }//GEN-LAST:event_btnForestStatsActionPerformed

    private void btnSaveAndExitForestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAndExitForestActionPerformed
        pForest.setVisible(false);
        addItemCountToAcc(AccountID, AccountItems);

        addLogLine("Forest", "Save and exit " + currentPlayer.getFirst().getName());
        // delete all items in backpack where player = id 
        // insert into item / potion / armour / weapon / scroll 
        deletePlayerInventory(currentPlayer.get(0).getId());
        // potion
        for (int i = 0; i < InvPotion.size(); i++) {
            Potion p = InvPotion.get(i);
            addItem(p.getId(), p.getName(), p.getSellPrice(), p.getBuyPrice(), p.getRarity(), p.getImage());
            addPotion(p.getId(), p.getValue(), p.getType());
            addItemTOInventory(currentPlayer.get(0).getId(), p.getId());
        }
        // spotion
        for (int i = 0; i < InvSPotion.size(); i++) {
            StatPotion sp = InvSPotion.get(i);
            addItem(sp.getId(), sp.getName(), sp.getSellPrice(), sp.getBuyPrice(), sp.getRarity(), sp.getImage());
            addSPotion(sp.getId(), sp.getStrength(), sp.getWill(), sp.getKnowledge(), sp.getAgility());
            addItemTOInventory(currentPlayer.get(0).getId(), sp.getId());
        }
        // weapon
        for (int i = 0; i < InvWeapon.size(); i++) {
            Weapon w = InvWeapon.get(i);
            addItem(w.getId(), w.getName(), w.getSellPrice(), w.getBuyPrice(), w.getRarity(), w.getImage());
            addWeapon(w.getId(), w.getWeaponDamage(), w.getMagicDamage(), w.getArmourPenetration(), w.getMagicPenetration());
            addItemTOInventory(currentPlayer.get(0).getId(), w.getId());
        }
        // armour
        for (int i = 0; i < InvArmour.size(); i++) {
            Armour a = InvArmour.get(i);
            addItem(a.getId(), a.getName(), a.getSellPrice(), a.getBuyPrice(), a.getRarity(), a.getImage());
            addArmour(a.getId(), a.getPDR(), a.getMDR(), a.getStrength(), a.getWill(), a.getKnowledge(), a.getAgility());
            addItemTOInventory(currentPlayer.get(0).getId(), a.getId());
        }
        // sscroll
        for (int i = 0; i < InvSScroll.size(); i++) {
            SScroll ss = InvSScroll.get(i);
            addItem(ss.getId(), ss.getName(), ss.getSellPrice(), ss.getBuyPrice(), ss.getRarity(), ss.getImage());
            addSScroll(ss.getId(), ss.getNeededKnowdelge(), ss.getStrength(), ss.getWill(), ss.getKnowledge(), ss.getAgility());
            addItemTOInventory(currentPlayer.get(0).getId(), ss.getId());
        }
        // pscroll
        for (int i = 0; i < InvPScroll.size(); i++) {
            PScroll ps = InvPScroll.get(i);
            addItem(ps.getId(), ps.getName(), ps.getSellPrice(), ps.getBuyPrice(), ps.getRarity(), ps.getImage());
            addPScroll(ps.getId(), ps.getNeededKnowdelge(), ps.getValue());
            addItemTOInventory(currentPlayer.get(0).getId(), ps.getId());
        }
        // update player 
        updatePlayer(currentPlayer.get(0), lastVisitedPanel);
        SelectCharacter = 0;
        InvPotion.clear();
        InvSPotion.clear();
        InvWeapon.clear();
        InvArmour.clear();
        InvSScroll.clear();
        InvPScroll.clear();
        addItemCountToAcc(AccountID, AccountItems);
      
        setCharacterSelect();
        pCharacterSelect.setVisible(true);
    }//GEN-LAST:event_btnSaveAndExitForestActionPerformed

    private void btnBattleRunAwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBattleRunAwayActionPerformed
      // 1 / 10 chance to fail and disable the run away button.
        pBattleForest.setVisible(false);
        currentMonster.clear();
        if (usedStatChange) {
            usedStatChange = false;
            currentPlayer.getFirst().setStrength(oldStrength);
            currentPlayer.getFirst().setWill(oldWill);
            currentPlayer.getFirst().setKnowledge(oldKnowledge);
            currentPlayer.getFirst().setAgility(oldAgility);
        }
        setForest();
        pForest.setVisible(true);
        
    }//GEN-LAST:event_btnBattleRunAwayActionPerformed

    private void btnForestInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForestInvActionPerformed
        pForest.setVisible(false);
        lastVisitedPanel = "forest";
        setInventory();
        addLogLine("Forest", "entered inventory");
        pInventory.setVisible(true);
    }//GEN-LAST:event_btnForestInvActionPerformed

    private void btnExitInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitInvActionPerformed
        pInventory.setVisible(false);
        switch (lastVisitedPanel) {
            case "forest":
                setForest();
                pForest.setVisible(true);
                break;
            case "battleForest":
                SetBattleForest();
                pBattleForest.setVisible(true);
                break;

            case "village":
                SetVillage();
                pVillage.setVisible(true);
                break;

        }
    }//GEN-LAST:event_btnExitInvActionPerformed

    private void btnBattleInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBattleInvActionPerformed
        pBattleForest.setVisible(false);
        lastVisitedPanel = "battleForest";
        setInventory();
        addLogLine("battle", "entered inventory");
        pInventory.setVisible(true);
    }//GEN-LAST:event_btnBattleInvActionPerformed

    private void btnStatsBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatsBackActionPerformed
        pStats.setVisible(false);
        switch (lastVisitedPanel) {
            case "forest":
                setForest();
                pForest.setVisible(true);
                break;
            case "village":
                pVillage.setVisible(true);
                break;

        }
    }//GEN-LAST:event_btnStatsBackActionPerformed

    private void btnVillageLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVillageLeaveActionPerformed
        pVillage.setVisible(false);
        ShopPotion.clear();
        ShopSPotion.clear();
        ShopSScroll.clear();
        ShopPScroll.clear();
        ShopWeapon.clear();
        ShopArmour.clear();
        setForest();
        pForest.setVisible(true);
    }//GEN-LAST:event_btnVillageLeaveActionPerformed

    private void btnVillageInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVillageInvActionPerformed
        pVillage.setVisible(false);
        lastVisitedPanel = "village";
        setInventory();
        pInventory.setVisible(true);
    }//GEN-LAST:event_btnVillageInvActionPerformed

    private void btnVillageStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVillageStatsActionPerformed
        pVillage.setVisible(false);
        setStats();
        setStatButton();
        lastVisitedPanel = "village";
        pStats.setVisible(true);
    }//GEN-LAST:event_btnVillageStatsActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        pVillage.setVisible(false);
        addLogLine("village", "entered shop");
        setShop();
        lastVisitedPanel = "village";
        pShop.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        pVillage.setVisible(false);
        lastVisitedPanel = "village";
        SetInn();
        addLogLine("village", "entered inn");
        pInn.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        pInn.setVisible(false);
        switch (lastVisitedPanel) {
            case "village":
                SetVillage();
                pVillage.setVisible(true);
                break;
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnShopLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShopLeaveActionPerformed
        pShop.setVisible(false);
        switch (lastVisitedPanel) {
            case "village":
                SetVillage();
                pVillage.setVisible(true);
                break;
        }
    }//GEN-LAST:event_btnShopLeaveActionPerformed

    private void btnExitInv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitInv1ActionPerformed
        pSell.setVisible(false);
        pShop.setVisible(true);
    }//GEN-LAST:event_btnExitInv1ActionPerformed

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSellActionPerformed
        //
        String ItemID = sellItemId.get(sellItemPos);
        ImageIcon icon = (ImageIcon) sell.get(sellItemPos).getIcon();
        String ItemType = icon.getDescription();
        switch (ItemType) {
            case "potion":
                for (int i = 0; i < InvPotion.size(); i++) {
                    if (InvPotion.get(i).getId().equals(ItemID)) {
                        currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() + InvPotion.get(i).getSellPrice());
                        InvPotion.remove(i);
                    }
                }
                break;
            case "spotion":
                for (int i = 0; i < InvSPotion.size(); i++) {
                    if (InvSPotion.get(i).getId().equals(ItemID)) {
                        currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() + InvSPotion.get(i).getSellPrice());
                        InvSPotion.remove(i);
                    }
                }
                break;
            case "pscroll":
                for (int i = 0; i < InvPScroll.size(); i++) {
                    if (InvPScroll.get(i).getId().equals(ItemID)) {
                        currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() + InvPScroll.get(i).getSellPrice());
                        InvPScroll.remove(i);
                    }
                }
                break;
            case "sscroll":
                for (int i = 0; i < InvSScroll.size(); i++) {
                    if (InvSScroll.get(i).getId().equals(ItemID)) {
                        currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() + InvSScroll.get(i).getSellPrice());
                        InvSScroll.remove(i);
                    }
                }
                break;
            case "weapon":
                for (int i = 0; i < InvWeapon.size(); i++) {
                    if (InvWeapon.get(i).getId().equals(ItemID)) {
                        currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() + InvWeapon.get(i).getSellPrice());
                        InvWeapon.remove(i);
                    }
                }
                break;
            case "armour":
                for (int i = 0; i < InvArmour.size(); i++) {
                    if (InvArmour.get(i).getId().equals(ItemID)) {
                        currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() + InvArmour.get(i).getSellPrice());
                        InvArmour.remove(i);
                    }
                }
                break;
        }
        addLogLine("shop/sell", "sold item");
        setSell();
    }//GEN-LAST:event_btnSellActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        pShop.setVisible(false);
        setSell();
        pSell.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void btnForestGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForestGoActionPerformed
        int random = (int) Math.floor(Math.random() * 10);
        if (random < 5) {
            // battle
            addLogLine("forest", "entered battle");
            pForest.setVisible(false);
            // generate monster in currentMonster
            GenerateMonster();
            // setForestBattle
            SetBattleForest();
            pBattleForest.setVisible(true);
        } else {
            // village
            pForest.setVisible(false);
            GenerateShop(10);
            addLogLine("forest", "generated shop items");
            SetVillage();
            pVillage.setVisible(true);
            addLogLine("forest", "entered village");
        }
    }//GEN-LAST:event_btnForestGoActionPerformed

    private void btnRegisterBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterBackActionPerformed
        lblErrorRegister.setText("");
        txtfUsernameRegister.setText("");
        pfPasswordRegister.setText("");
        pRegister.setVisible(false);
        pLogin.setVisible(true);
    }//GEN-LAST:event_btnRegisterBackActionPerformed

    private void btnSplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSplusActionPerformed
        // strength + btn
        int remain = Integer.parseInt(lblCCPointsRemaining.getText());
        if (remain > 0) {
            lblCCPointsRemaining.setText((remain - 1) + "");
            int Strength = Integer.parseInt(lblCCS.getText());
            lblCCS.setText((Strength + 1) + "");
            if (Strength == 10) {
                btnSminus.setEnabled(true);
            }
        }

    }//GEN-LAST:event_btnSplusActionPerformed

    private void btnWplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWplusActionPerformed
        // will +
        int remain = Integer.parseInt(lblCCPointsRemaining.getText());
        if (remain > 0) {
            lblCCPointsRemaining.setText((remain - 1) + "");
            int Will = Integer.parseInt(lblCCW.getText());
            lblCCW.setText((Will + 1) + "");
            if (Will == 10) {
                btnWminus.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnWplusActionPerformed

    private void btnKplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKplusActionPerformed
        // knowledge +
        int remain = Integer.parseInt(lblCCPointsRemaining.getText());
        if (remain > 0) {
            lblCCPointsRemaining.setText((remain - 1) + "");
            int Knowledge = Integer.parseInt(lblCCK.getText());
            lblCCK.setText((Knowledge + 1) + "");
            if (Knowledge == 10) {
                btnKminus.setEnabled(true);
            }
        }

    }//GEN-LAST:event_btnKplusActionPerformed

    private void btnAplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplusActionPerformed
        // agility +
        int remain = Integer.parseInt(lblCCPointsRemaining.getText());
        if (remain > 0) {
            lblCCPointsRemaining.setText((remain - 1) + "");
            int Agility = Integer.parseInt(lblCCA.getText());
            lblCCA.setText((Agility + 1) + "");
            if (Agility == 10) {
                btnAminus.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnAplusActionPerformed

    private void btnSminusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSminusActionPerformed
        // Str -
        int str = Integer.parseInt(lblCCS.getText());
        if (str > 10) {
            lblCCS.setText((str - 1) + "");
            int remain = Integer.parseInt(lblCCPointsRemaining.getText());
            lblCCPointsRemaining.setText((remain + 1) + "");
            if (str == 11) {
                btnSminus.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnSminusActionPerformed

    private void btnWminusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWminusActionPerformed
        // will -
        int will = Integer.parseInt(lblCCW.getText());
        if (will > 10) {
            lblCCW.setText((will - 1) + "");
            int remain = Integer.parseInt(lblCCPointsRemaining.getText());
            lblCCPointsRemaining.setText((remain + 1) + "");
            if (will == 11) {
                btnWminus.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnWminusActionPerformed

    private void btnKminusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKminusActionPerformed
        // knwo -
        int knw = Integer.parseInt(lblCCK.getText());
        if (knw > 10) {
            lblCCK.setText((knw - 1) + "");
            int remain = Integer.parseInt(lblCCPointsRemaining.getText());
            lblCCPointsRemaining.setText((remain + 1) + "");
            if (knw == 11) {
                btnKminus.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnKminusActionPerformed

    private void btnAminusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAminusActionPerformed
        // agi -
        int agi = Integer.parseInt(lblCCA.getText());
        if (agi > 10) {
            lblCCA.setText((agi - 1) + "");
            int remain = Integer.parseInt(lblCCPointsRemaining.getText());
            lblCCPointsRemaining.setText((remain + 1) + "");
            if (agi == 11) {
                btnAminus.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnAminusActionPerformed

    private void rbMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMaleActionPerformed
        if (rbMale.isSelected()) {
            rbFemale.setEnabled(true);
            rbMale.setEnabled(false);
            rbFemale.setSelected(false);
        }
        setPlayerImageCC();
    }//GEN-LAST:event_rbMaleActionPerformed

    private void rbFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemaleActionPerformed
        if (rbFemale.isSelected()) {
            rbFemale.setEnabled(false);
            rbMale.setEnabled(true);
            rbMale.setSelected(false);
        }
        setPlayerImageCC();
    }//GEN-LAST:event_rbFemaleActionPerformed

    private void btnNextWeaponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextWeaponActionPerformed
        if (CCweaponSelector + 1 < CCdefaultWeapons.size()) {
            CCweaponSelector++;
            btnBackWeapon.setEnabled(true);
            if (CCweaponSelector == 2) {
                btnNextWeapon.setEnabled(false);
            }
        }
        setWeaponImageCC();
    }//GEN-LAST:event_btnNextWeaponActionPerformed

    private void btnBackWeaponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackWeaponActionPerformed
        if (CCweaponSelector - 1 >= 0) {
            CCweaponSelector--;
            btnNextWeapon.setEnabled(true);
            if (CCweaponSelector == 0) {
                btnBackWeapon.setEnabled(false);
            }
        }

        setWeaponImageCC();
    }//GEN-LAST:event_btnBackWeaponActionPerformed

    private void btnCharacterNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCharacterNextActionPerformed
        btnCharacterReturn.setEnabled(true);
        setCharacterSelect("+");
        if (SelectCharacter == CaracterSelect.size() - 1) {
            btnCharacterNext.setEnabled(false);
        }
    }//GEN-LAST:event_btnCharacterNextActionPerformed

    private void btnCharacterReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCharacterReturnActionPerformed
        btnCharacterNext.setEnabled(true);
        setCharacterSelect("-");
        if (SelectCharacter == 0) {
            btnCharacterReturn.setEnabled(false);
        }
    }//GEN-LAST:event_btnCharacterReturnActionPerformed

    private void btnStatSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatSActionPerformed
        // str +
        currentPlayer.getFirst().setStrength(currentPlayer.getFirst().getStrength() + 1);
        setStats();
        setStatButton();
        addLogLine("stats", " + strength");
    }//GEN-LAST:event_btnStatSActionPerformed

    private void btnStatWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatWActionPerformed
        // will +
        currentPlayer.getFirst().setWill(currentPlayer.getFirst().getWill() + 1);
        setStats();
        setStatButton();
        addLogLine("stats", " + will");
    }//GEN-LAST:event_btnStatWActionPerformed

    private void btnStatKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatKActionPerformed
        // knw +
        currentPlayer.getFirst().setKnowledge(currentPlayer.getFirst().getKnowledge() + 1);
        setStats();
        setStatButton();
        addLogLine("stats", " + knowledge");
    }//GEN-LAST:event_btnStatKActionPerformed

    private void btnStatAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatAActionPerformed
        // agi +
        currentPlayer.getFirst().setAgility(currentPlayer.getFirst().getAgility() + 1);
        setStats();
        setStatButton();
        addLogLine("stats", " + agility");
    }//GEN-LAST:event_btnStatAActionPerformed

    private void lblInvArmourMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInvArmourMousePressed
        // armour
        selectedEquipped = "armour";
        clearInvInfo();
        if (lblInvArmour.getIcon() == null) {
            return;
        }
        if (lastVisitedPanel.equals("forest")) {
            btnInvRemove.setEnabled(true);
        }

        lblInvName.setText(currentPlayer.getFirst().getArmourA().getName());
        lblInvRarity.setText("Rarity: " + currentPlayer.getFirst().getArmourA().getRarity());
        lblInvSell.setText("Price: " + currentPlayer.getFirst().getArmourA().getSellPrice() + "");
        lblInvinfo1.setText("PDR: " + currentPlayer.getFirst().getArmourA().getPDR() + "");
        lblInvinfo2.setText("MDR " + currentPlayer.getFirst().getArmourA().getMDR() + "");
        lblInvinfo3.setText("Strength: " + currentPlayer.getFirst().getArmourA().getStrength() + "");
        lblInvinfo4.setText("Will: " + currentPlayer.getFirst().getArmourA().getWill() + "");
        lblInvinfo5.setText("Knowledge: " + currentPlayer.getFirst().getArmourA().getKnowledge() + "");
        lblInvinfo6.setText("Agility: " + currentPlayer.getFirst().getArmourA().getAgility() + "");
    }//GEN-LAST:event_lblInvArmourMousePressed

    private void lblInvWeaponMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInvWeaponMousePressed
        // weapon
        selectedEquipped = "weapon";
        clearInvInfo();
        if (lblInvWeapon.getIcon() == null) {
            return;
        }
        if (lastVisitedPanel.equals("forest")) {
            btnInvRemove.setEnabled(true);
        }

        lblInvName.setText(currentPlayer.getFirst().getWeaponA().getName());
        lblInvRarity.setText("Rarity: " + currentPlayer.getFirst().getWeaponA().getRarity());
        lblInvSell.setText("Price: " + currentPlayer.getFirst().getWeaponA().getSellPrice() + "");
        lblInvinfo1.setText("Weapon Damage: " + currentPlayer.getFirst().getWeaponA().getWeaponDamage() + "");
        lblInvinfo2.setText("Magic Damage: " + currentPlayer.getFirst().getWeaponA().getMagicDamage() + "");
        lblInvinfo3.setText("Armour Penetration: " + currentPlayer.getFirst().getWeaponA().getArmourPenetration() + "");
        lblInvinfo4.setText("Magic Penetration: " + currentPlayer.getFirst().getWeaponA().getMagicPenetration() + "");
    }//GEN-LAST:event_lblInvWeaponMousePressed

    private void lblInv1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv1MousePressed
        // position 1 inventory = image icon   InvItemId = id item
        InvItemClick(0);
    }//GEN-LAST:event_lblInv1MousePressed

    private void lblInv2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv2MousePressed
        // TODO add your handling code here:
        InvItemClick(1);
    }//GEN-LAST:event_lblInv2MousePressed

    private void lblInv3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv3MousePressed
        // TODO add your handling code here:
        InvItemClick(2);
    }//GEN-LAST:event_lblInv3MousePressed

    private void lblInv4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv4MousePressed
        // TODO add your handling code here:
        InvItemClick(3);
    }//GEN-LAST:event_lblInv4MousePressed

    private void lblInv5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv5MousePressed
        // TODO add your handling code here:
        InvItemClick(4);
    }//GEN-LAST:event_lblInv5MousePressed

    private void lblInv6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv6MousePressed
        // TODO add your handling code here:
        InvItemClick(5);
    }//GEN-LAST:event_lblInv6MousePressed

    private void lblInv7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv7MousePressed
        // TODO add your handling code here:
        InvItemClick(6);
    }//GEN-LAST:event_lblInv7MousePressed

    private void lblInv8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv8MousePressed
        // TODO add your handling code here:
        InvItemClick(7);
    }//GEN-LAST:event_lblInv8MousePressed

    private void lblInv9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv9MousePressed
        // TODO add your handling code here:
        InvItemClick(8);
    }//GEN-LAST:event_lblInv9MousePressed

    private void lblInv10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv10MousePressed
        // TODO add your handling code here:
        InvItemClick(9);
    }//GEN-LAST:event_lblInv10MousePressed

    private void lblInv11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv11MousePressed
        // TODO add your handling code here:
        InvItemClick(10);
    }//GEN-LAST:event_lblInv11MousePressed

    private void lblInv12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv12MousePressed
        // TODO add your handling code here:
        InvItemClick(11);
    }//GEN-LAST:event_lblInv12MousePressed

    private void lblInv13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv13MousePressed
        // TODO add your handling code here:
        InvItemClick(12);
    }//GEN-LAST:event_lblInv13MousePressed

    private void lblInv14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv14MousePressed
        // TODO add your handling code here:
        InvItemClick(13);
    }//GEN-LAST:event_lblInv14MousePressed

    private void lblInv15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv15MousePressed
        // TODO add your handling code here:
        InvItemClick(14);
    }//GEN-LAST:event_lblInv15MousePressed

    private void lblInv16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv16MousePressed
        // TODO add your handling code here:
        InvItemClick(15);
    }//GEN-LAST:event_lblInv16MousePressed

    private void lblInv17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv17MousePressed
        // TODO add your handling code here:
        InvItemClick(16);
    }//GEN-LAST:event_lblInv17MousePressed

    private void lblInv18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv18MousePressed
        // TODO add your handling code here:
        InvItemClick(17);
    }//GEN-LAST:event_lblInv18MousePressed

    private void lblInv19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv19MousePressed
        // TODO add your handling code here:
        InvItemClick(18);
    }//GEN-LAST:event_lblInv19MousePressed

    private void lblInv20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv20MousePressed
        // TODO add your handling code here:
        InvItemClick(19);
    }//GEN-LAST:event_lblInv20MousePressed

    private void lblInv21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv21MousePressed
        // TODO add your handling code here:
        InvItemClick(20);
    }//GEN-LAST:event_lblInv21MousePressed

    private void lblInv22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv22MousePressed
        // TODO add your handling code here:
        InvItemClick(21);
    }//GEN-LAST:event_lblInv22MousePressed

    private void lblInv23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv23MousePressed
        // TODO add your handling code here:
        InvItemClick(22);
    }//GEN-LAST:event_lblInv23MousePressed

    private void lblInv24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv24MousePressed
        // TODO add your handling code here:
        InvItemClick(23);
    }//GEN-LAST:event_lblInv24MousePressed

    private void lblInv25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv25MousePressed
        // TODO add your handling code here:
        InvItemClick(24);
    }//GEN-LAST:event_lblInv25MousePressed

    private void lblInv26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv26MousePressed
        // TODO add your handling code here:
        InvItemClick(25);
    }//GEN-LAST:event_lblInv26MousePressed

    private void lblInv27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv27MousePressed
        // TODO add your handling code here:
        InvItemClick(26);
    }//GEN-LAST:event_lblInv27MousePressed

    private void lblInv28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv28MousePressed
        // TODO add your handling code here:
        InvItemClick(27);
    }//GEN-LAST:event_lblInv28MousePressed

    private void lblInv29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv29MousePressed
        // TODO add your handling code here:
        InvItemClick(28);
    }//GEN-LAST:event_lblInv29MousePressed

    private void lblInv30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv30MousePressed
        // TODO add your handling code here:
        InvItemClick(29);
    }//GEN-LAST:event_lblInv30MousePressed

    private void lblInv31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv31MousePressed
        // TODO add your handling code here:
        InvItemClick(30);
    }//GEN-LAST:event_lblInv31MousePressed

    private void lblInv32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInv32MousePressed
        // TODO add your handling code here:
        InvItemClick(31);
    }//GEN-LAST:event_lblInv32MousePressed

    private void btnInvUseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvUseActionPerformed
        // USE item potion / scroll
        int AddedKnw = 0;
        if (currentPlayer.getFirst().returnArmourArry().isEmpty()) {
        } else {
            AddedKnw = currentPlayer.getFirst().getArmourA().getKnowledge();
        }
        String ItemID = InvItemId.get(InvItemPos);
        ImageIcon icon = (ImageIcon) inventory.get(InvItemPos).getIcon();
        String ItemType = icon.getDescription();
        switch (ItemType) {
            case "potion":
                if (InvPotion.get(InvPotionInt(ItemID)).getType().equals("HP")) {
                    int oldHP = currentPlayer.getFirst().getCurrentHP();
                    int addHP = InvPotion.get(InvPotionInt(ItemID)).getValue();
                    if (oldHP + addHP > currentPlayer.getFirst().getMaxHP()) {
                        currentPlayer.getFirst().setCurrentHP(currentPlayer.getFirst().getMaxHP());
                        lvlInvNotice.setText("Healed " + addHP + " hp");

                    } else {
                        currentPlayer.getFirst().setCurrentHP(oldHP + addHP);
                        lvlInvNotice.setText("Healed fully");

                    }
                } else {
                    currentPlayer.getFirst().setShield(currentPlayer.getFirst().getShield() + InvPotion.get(InvPotionInt(ItemID)).getValue());
                }
                InvPotion.remove(InvPotionInt(ItemID));
                addLogLine("inventory", "used potion");
                break;
            case "spotion":
                int str = InvSPotion.get(InvPotionInt(ItemID)).getStrength();
                int will = InvSPotion.get(InvPotionInt(ItemID)).getWill();
                int knw = InvSPotion.get(InvPotionInt(ItemID)).getKnowledge();
                int agi = InvSPotion.get(InvPotionInt(ItemID)).getAgility();

                if (!usedStatChange) {
                    oldStrength = currentPlayer.getFirst().getStrength();
                    oldWill = currentPlayer.getFirst().getWill();
                    oldKnowledge = currentPlayer.getFirst().getKnowledge();
                    oldAgility = currentPlayer.getFirst().getAgility();
                    usedStatChange = true;
                }
                currentPlayer.getFirst().setStrength(currentPlayer.getFirst().getStrength() + str);
                currentPlayer.getFirst().setWill(currentPlayer.getFirst().getWill() + will);
                currentPlayer.getFirst().setKnowledge(currentPlayer.getFirst().getKnowledge() + knw);
                currentPlayer.getFirst().setAgility(currentPlayer.getFirst().getAgility() + agi);
                InvSPotion.remove(InvSPotionInt(ItemID));
                addLogLine("inventory", "used stat potion");
                break;

            case "pscroll":
                if (currentPlayer.getFirst().getKnowledge() + AddedKnw >= InvPScroll.get(InvPScrollInt(ItemID)).getNeededKnowdelge()) {
                    currentPlayer.getFirst().setShield(InvPScroll.get(InvPScrollInt(ItemID)).getValue());
                    InvPScroll.remove(InvPScrollInt(ItemID));
                    addLogLine("inventory", "used protection scroll");
                } else {
                    lvlInvNotice.setText("You need more knowledge");
                }
                break;
            case "sscroll":
                if (currentPlayer.getFirst().getKnowledge() + AddedKnw >= InvSScroll.get(InvSScrollInt(ItemID)).getNeededKnowdelge()) {
                    str = InvSScroll.get(InvSScrollInt(ItemID)).getStrength();
                    will = InvSScroll.get(InvSScrollInt(ItemID)).getWill();
                    knw = InvSScroll.get(InvSScrollInt(ItemID)).getKnowledge();
                    agi = InvSScroll.get(InvSScrollInt(ItemID)).getAgility();
                    
                    if (!usedStatChange) {
                        oldStrength = currentPlayer.getFirst().getStrength();
                        oldWill = currentPlayer.getFirst().getWill();
                        oldKnowledge = currentPlayer.getFirst().getKnowledge();
                        oldAgility = currentPlayer.getFirst().getAgility();
                        usedStatChange = true;
                    }
                    currentPlayer.getFirst().setStrength(currentPlayer.getFirst().getStrength() + str);
                    currentPlayer.getFirst().setWill(currentPlayer.getFirst().getWill() + will);
                    currentPlayer.getFirst().setKnowledge(currentPlayer.getFirst().getKnowledge() + knw);
                    currentPlayer.getFirst().setAgility(currentPlayer.getFirst().getAgility() + agi);
                    InvSScroll.remove(InvSScrollInt(ItemID));
                    
                    addLogLine("inventory", "used stat scroll");
                } else {
                    lvlInvNotice.setText("You need more knowledge");
                }
                break;
        }
        setInventory();

    }//GEN-LAST:event_btnInvUseActionPerformed

    private void btnInvDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvDropActionPerformed
        // DELETE ITEM InvItemPos
        String ItemID = InvItemId.get(InvItemPos);
        ImageIcon icon = (ImageIcon) inventory.get(InvItemPos).getIcon();
        String ItemType = icon.getDescription();
        addLogLine("inventory", "dropped item " + ItemType);
        switch (ItemType) {
            case "potion":
                InvPotion.remove(InvPotionInt(ItemID));
                break;
            case "spotion":
                InvSPotion.remove(InvSPotionInt(ItemID));
                break;
            case "pscroll":
                InvPScroll.remove(InvPScrollInt(ItemID));
                break;
            case "sscroll":
                InvSScroll.remove(InvSScrollInt(ItemID));
                break;
            case "weapon":
                InvWeapon.remove(InvWeaponInt(ItemID));
                break;
            case "armour":
                InvArmour.remove(InvArmourInt(ItemID));
                break;
        }

        setInventory();
    }//GEN-LAST:event_btnInvDropActionPerformed

    private void btnInvRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvRemoveActionPerformed
        // REMOVE armour / weapon

        if (selectedEquipped.equals("weapon")) {
            // weapon
            InvWeapon.add(currentPlayer.getFirst().getWeaponA());
            currentPlayer.getFirst().delWeapon();
            lblInvArmour.setIcon(null);
            addLogLine("inventory", "unequipped weapon");
        } else {
            // armour
            InvArmour.add(currentPlayer.getFirst().getArmourA());
            currentPlayer.getFirst().delArmour();
            lblInvWeapon.setIcon(null);
            addLogLine("inventory", "unequipped armour");
        }
        setInventory();
    }//GEN-LAST:event_btnInvRemoveActionPerformed

    private void btnInvEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvEquipActionPerformed
        // EQUIP armour / weapon
        String ItemID = InvItemId.get(InvItemPos);
        ImageIcon icon = (ImageIcon) inventory.get(InvItemPos).getIcon();
        String ItemType = icon.getDescription();
        switch (ItemType) {
            case "weapon":
                addLogLine("inventory", "equipped weapon");
                if (currentPlayer.getFirst().returnWeaponArry().isEmpty()) {
                    currentPlayer.getFirst().addWeapon(InvWeapon.get(InvWeaponInt(ItemID)));
                    InvWeapon.remove(InvWeaponInt(ItemID));
                } else {
                    InvWeapon.add(currentPlayer.getFirst().getWeaponA());
                    currentPlayer.getFirst().returnWeaponArry().clear();
                    currentPlayer.getFirst().addWeapon(InvWeapon.get(InvWeaponInt(ItemID)));
                    InvWeapon.remove(InvWeaponInt(ItemID));
                }

                break;
            case "armour":
                addLogLine("inventory", "equipped armour");
                if (currentPlayer.getFirst().returnArmourArry().isEmpty()) {
                    currentPlayer.getFirst().addArmour(InvArmour.get(InvArmourInt(ItemID)));
                    InvArmour.remove(InvArmourInt(ItemID));
                } else {
                    InvArmour.add(currentPlayer.getFirst().getArmourA());
                    currentPlayer.getFirst().returnArmourArry().clear();
                    currentPlayer.getFirst().addArmour(InvArmour.get(InvArmourInt(ItemID)));
                    InvArmour.remove(InvArmourInt(ItemID));
                }

                break;
        }
        setInventory();
    }//GEN-LAST:event_btnInvEquipActionPerformed

    private void btnAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttackActionPerformed
        // Attack monster Forest
        // player: str, will, weapon damage, magic damage, a/m pen. -> hp, pdr, mdr 
        // 
        MonsterDamageF.setText("");
        PlayerDamageF.setText("");
        lblminShield.setText("");
        int PlayerdamagePhy = 0;
        int PlayerdamageMag = 0;
        int WeaponDamage = currentPlayer.getFirst().getWeaponA().getWeaponDamage();
        int WeaponMagicD = currentPlayer.getFirst().getWeaponA().getMagicDamage();
        int WepPen = currentPlayer.getFirst().getWeaponA().getArmourPenetration();
        int WepMPen = currentPlayer.getFirst().getWeaponA().getMagicPenetration();
        int str = currentPlayer.getFirst().getStrength() + currentPlayer.getFirst().getArmourA().getStrength();
        int will = currentPlayer.getFirst().getWill() + currentPlayer.getFirst().getArmourA().getWill();
        int PlayerPDR = currentPlayer.getFirst().getArmourA().getPDR();
        int PlayerMDR = currentPlayer.getFirst().getArmourA().getMDR() + will;
        int randomModP = (int) Math.floor(Math.random() * 5);

        int MonsterDamagePhy = currentMonster.getFirst().getDamage();
        int MonsterDamageMag = currentMonster.getFirst().getMagic();
        int MonsterPDR = currentMonster.getFirst().getPdr();
        int MonsterMDR = currentMonster.getFirst().getMdr();
        int randomModM = (int) Math.floor(Math.random() * 5);

        String weaponType = currentPlayer.getFirst().getWeaponA().getName();

        // (wep + (stat / 2)) - ((monster armor / 2) - (pen / 2))
        switch (weaponType) {
            case "Sword":
                PlayerdamagePhy = (WeaponDamage + (str / 2)) - ((MonsterPDR / 2) - (WepPen / 2));
                break;
            case "Crystal Sword":
                PlayerdamagePhy = (WeaponDamage + (str / 2)) - ((MonsterPDR / 2) - (WepPen / 2));
                PlayerdamageMag = (WeaponMagicD + (will / 2)) - ((MonsterMDR / 2) - (WepMPen / 2));
                break;
            case "SpellBook":
                PlayerdamageMag = (WeaponMagicD + (will / 2)) - ((MonsterMDR / 2) - (WepMPen / 2));
                break;
        }

        if (currentMonster.getFirst().getHP() - (PlayerdamagePhy + PlayerdamageMag + randomModP) < 0) {
            currentMonster.getFirst().setHP(0);
        } else {
            currentMonster.getFirst().setHP(currentMonster.getFirst().getHP() - (PlayerdamagePhy + PlayerdamageMag + randomModP));
        }
        PlayerDamageF.setText("- " + (PlayerdamagePhy + PlayerdamageMag + randomModP));
        MHealthBat.setText("HP: " + currentMonster.getFirst().getHP());

        if (currentMonster.getFirst().getHP() <= 0) {
            btnBattleRunAway.setEnabled(false);
            btnAttack.setEnabled(false);
            btnBattleInv.setEnabled(false);
            pnlFBat.setVisible(true);
            lblFbatInfo.setText("You Slay the " + currentMonster.getFirst().getName());
            lblFBGold.setText("Gold : " + currentMonster.getFirst().getGold());
            lblFBXP.setText("XP : " + currentMonster.getFirst().getExp());
            btnFBatbut.setText("Continue");

            currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() + currentMonster.getFirst().getGold());

            if (currentPlayer.getFirst().getExp() + currentMonster.getFirst().getExp() >= 100) {
                currentPlayer.getFirst().setLevel(currentPlayer.getFirst().getLevel() + 1);
                currentPlayer.getFirst().setExp((currentPlayer.getFirst().getExp() + currentMonster.getFirst().getExp()) - 100);
            } else {
                currentPlayer.getFirst().setExp(currentPlayer.getFirst().getExp() + currentMonster.getFirst().getExp());
            }
            currentMonster.clear();
            return;
        }

        addLogLine("battle", "player attacked, did " + (PlayerdamagePhy + PlayerdamageMag + randomModP));

        // monster -------------------------------------------------------------------------------------------------------------------------
        int dodge = (int) Math.floor(Math.random() * 150);
        if (dodge > currentPlayer.getFirst().getAgility() + currentPlayer.getFirst().getArmourA().getAgility()) {
            if (currentMonster.getFirst().getMagic() == 0) {
                MonsterDamagePhy = currentMonster.getFirst().getDamage() - (PlayerPDR / 2);
                if (MonsterDamagePhy < 5) {
                    MonsterDamagePhy = 10;
                }
            } else {
                MonsterDamagePhy = currentMonster.getFirst().getDamage() - (PlayerPDR / 2);
                MonsterDamageMag = currentMonster.getFirst().getMagic() - (PlayerMDR / 2);
                if (MonsterDamagePhy < 5) {
                    MonsterDamagePhy = 10;
                }
                if (MonsterDamageMag < 5) {
                    MonsterDamageMag = 10;
                }
            }

            if (currentPlayer.getFirst().getShield() > 0) {
                // lblFBshield lblminShield
                if (currentPlayer.getFirst().getShield() - (MonsterDamagePhy + MonsterDamageMag + randomModM) < 0) {
                    int totalMonster = (MonsterDamagePhy + MonsterDamageMag + randomModM) - currentPlayer.getFirst().getShield();
                    lblminShield.setText("- " + currentPlayer.getFirst().getShield());
                    currentPlayer.getFirst().setShield(0);
                    lblFBshield.setText(currentPlayer.getFirst().getShield() + "");
                    if (currentPlayer.getFirst().getCurrentHP() - totalMonster < 0) {
                        currentPlayer.getFirst().setCurrentHP(0);
                    } else {
                        currentPlayer.getFirst().setCurrentHP(currentPlayer.getFirst().getCurrentHP() - totalMonster);
                    }
                    MonsterDamageF.setText("- " + totalMonster);
                    lblbattleForestPlayerHP.setText(currentPlayer.getFirst().getCurrentHP() + " / " + currentPlayer.getFirst().getMaxHP());
                    PlayerDeadForest();
                } else {
                    currentPlayer.getFirst().setShield(currentPlayer.getFirst().getShield() - (MonsterDamagePhy + MonsterDamageMag + randomModM));
                    lblminShield.setText("- " + (MonsterDamagePhy + MonsterDamageMag + randomModM));
                    lblFBshield.setText(currentPlayer.getFirst().getShield() + "");
                }

            } else {
                if (currentPlayer.getFirst().getCurrentHP() - (MonsterDamagePhy + MonsterDamageMag + randomModM) < 0) {
                    currentPlayer.getFirst().setCurrentHP(0);
                } else {
                    currentPlayer.getFirst().setCurrentHP(currentPlayer.getFirst().getCurrentHP() - (MonsterDamagePhy + MonsterDamageMag + randomModM));
                }
                MonsterDamageF.setText("- " + (MonsterDamagePhy + MonsterDamageMag + randomModM));
                lblbattleForestPlayerHP.setText(currentPlayer.getFirst().getCurrentHP() + " / " + currentPlayer.getFirst().getMaxHP());

                PlayerDeadForest();
            }
        } else {
            MonsterDamageF.setText("- 0");
        }
    }//GEN-LAST:event_btnAttackActionPerformed

    private void btnFBatbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFBatbutActionPerformed
        // win / lose battle forest
        if (currentPlayer.getFirst().getCurrentHP() == 0) {
            addLogLine("battle", "player died");
            deletePlayerInventory(currentPlayer.getFirst().getId());
            deletePlayer(currentPlayer.getFirst().getId());
            currentPlayer.clear();
            // if 0 characters cc 
            if (doesAccHavePlayer(AccountID)) {
                // has
                pBattleForest.setVisible(false);
                setCharacterSelect();
                pCharacterSelect.setVisible(true);
            } else {
                // has not
                pBattleForest.setVisible(false);
                btncharacterCreateLeave.setEnabled(false);
                // disable minus button because 10 is lowest
                btnSminus.setEnabled(false);
                btnWminus.setEnabled(false);
                btnKminus.setEnabled(false);
                btnAminus.setEnabled(false);
                // set male
                rbMale.setSelected(true);
                rbMale.setEnabled(false);
                // call function to set image for player
                setPlayerImageCC();
                // weapon
                createDefaultWeaponsCC();
                setWeaponImageCC();
                btnBackWeapon.setEnabled(false);
                // change screen
                pCharacterCreate.setVisible(true);
            }
        } else {
            addLogLine("battle", "player won");
            if (usedStatChange) {
                usedStatChange = false;
                currentPlayer.getFirst().setStrength(oldStrength);
                currentPlayer.getFirst().setWill(oldWill);
                currentPlayer.getFirst().setKnowledge(oldKnowledge);
                currentPlayer.getFirst().setAgility(oldAgility);
            }
            pBattleForest.setVisible(false);
            currentMonster.clear();
            setForest();
            pForest.setVisible(true);
        }
    }//GEN-LAST:event_btnFBatbutActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // rest
        lblInnInfo.setText("");
        if (currentPlayer.getFirst().getGold() >= 5) {
            addLogLine("inn", "rested");
            currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() - 5);
            if (currentPlayer.getFirst().getCurrentHP() + 15 >= currentPlayer.getFirst().getMaxHP()) {
                currentPlayer.getFirst().setCurrentHP(currentPlayer.getFirst().getMaxHP());
            } else {
                currentPlayer.getFirst().setCurrentHP(currentPlayer.getFirst().getCurrentHP() + 15);
            }
        } else {
            lblInnInfo.setText("Insufficient gold");
        }
        SetInn();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // night
        lblInnInfo.setText("");
        if (currentPlayer.getFirst().getGold() >= 30) {
            addLogLine("inn", "spent night");
            currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() - 30);
            currentPlayer.getFirst().setCurrentHP(currentPlayer.getFirst().getMaxHP());
        } else {
            lblInnInfo.setText("Insufficient gold");
        }
        SetInn();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void shop0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shop0MousePressed
        // TODO add your handling code here:
        shopitemClick(0);
    }//GEN-LAST:event_shop0MousePressed

    private void shop1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shop1MousePressed
        // TODO add your handling code here:
        shopitemClick(1);
    }//GEN-LAST:event_shop1MousePressed

    private void shop2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shop2MousePressed
        // TODO add your handling code here:
        shopitemClick(2);
    }//GEN-LAST:event_shop2MousePressed

    private void shop3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shop3MousePressed
        // TODO add your handling code here:
        shopitemClick(3);
    }//GEN-LAST:event_shop3MousePressed

    private void shop4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shop4MousePressed
        // TODO add your handling code here:
        shopitemClick(4);
    }//GEN-LAST:event_shop4MousePressed

    private void shop5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shop5MousePressed
        // TODO add your handling code here:
        shopitemClick(5);
    }//GEN-LAST:event_shop5MousePressed

    private void shop6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shop6MousePressed
        // TODO add your handling code here:
        shopitemClick(6);
    }//GEN-LAST:event_shop6MousePressed

    private void shop7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shop7MousePressed
        // TODO add your handling code here:
        shopitemClick(7);
    }//GEN-LAST:event_shop7MousePressed

    private void shop8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shop8MousePressed
        // TODO add your handling code here:
        shopitemClick(8);
    }//GEN-LAST:event_shop8MousePressed

    private void shop9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shop9MousePressed
        // TODO add your handling code here:
        shopitemClick(9);
    }//GEN-LAST:event_shop9MousePressed

    private void btnShopBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShopBuyActionPerformed
        // buy  ShopItemPos 
        // addItemCountToAcc(AccountID, AccountItems);
        String ItemID = shopItemID.get(ShopItemPos);
        ImageIcon icon = (ImageIcon) shop.get(ShopItemPos).getIcon();
        String ItemType = icon.getDescription();
        switch (ItemType) {
            case "potion":
                for (int i = 0; i < ShopPotion.size(); i++) {
                    if (ShopPotion.get(i).getId().equals(ItemID) && ShopPotion.get(i).getBuyPrice() < currentPlayer.getFirst().getGold()) {
                        InvPotion.add(ShopPotion.get(i));
                        currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() - ShopPotion.get(i).getBuyPrice());
                        ShopPotion.remove(i);
                    }
                }
                break;
            case "spotion":
                for (int i = 0; i < ShopSPotion.size(); i++) {
                    if (ShopSPotion.get(i).getId().equals(ItemID) && ShopSPotion.get(i).getBuyPrice() < currentPlayer.getFirst().getGold()) {
                        InvSPotion.add(ShopSPotion.get(i));
                        currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() - ShopSPotion.get(i).getBuyPrice());
                        ShopSPotion.remove(i);
                    }
                }
                break;
            case "pscroll":
                for (int i = 0; i < ShopPScroll.size(); i++) {
                    if (ShopPScroll.get(i).getId().equals(ItemID) && ShopPScroll.get(i).getBuyPrice() < currentPlayer.getFirst().getGold()) {
                        InvPScroll.add(ShopPScroll.get(i));
                        currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() - ShopPScroll.get(i).getBuyPrice());
                        ShopPScroll.remove(i);
                    }
                }
                break;
            case "sscroll":
                for (int i = 0; i < ShopSScroll.size(); i++) {
                    if (ShopSScroll.get(i).getId().equals(ItemID) && ShopSScroll.get(i).getBuyPrice() < currentPlayer.getFirst().getGold()) {
                        InvSScroll.add(ShopSScroll.get(i));
                        currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() - ShopSScroll.get(i).getBuyPrice());
                        ShopSScroll.remove(i);
                    }
                }
                break;
            case "weapon":
                for (int i = 0; i < ShopWeapon.size(); i++) {
                    if (ShopWeapon.get(i).getId().equals(ItemID) && ShopWeapon.get(i).getBuyPrice() < currentPlayer.getFirst().getGold()) {
                        InvWeapon.add(ShopWeapon.get(i));
                        currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() - ShopWeapon.get(i).getBuyPrice());
                        ShopWeapon.remove(i);
                    }
                }
                break;
            case "armour":
                for (int i = 0; i < ShopArmour.size(); i++) {
                    if (ShopArmour.get(i).getId().equals(ItemID) && ShopArmour.get(i).getBuyPrice() < currentPlayer.getFirst().getGold()) {
                        InvArmour.add(ShopArmour.get(i));
                        currentPlayer.getFirst().setGold(currentPlayer.getFirst().getGold() - ShopArmour.get(i).getBuyPrice());
                        ShopArmour.remove(i);
                    }
                }
                break;
        }
        addLogLine("shop", "bougth item");
        setShop();
    }//GEN-LAST:event_btnShopBuyActionPerformed

    private void sell1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell1MousePressed
        // TODO add your handling code here:
        sellitemClick(0);
    }//GEN-LAST:event_sell1MousePressed

    private void sell2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell2MousePressed
        // TODO add your handling code here:
        sellitemClick(1);
    }//GEN-LAST:event_sell2MousePressed

    private void sell3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell3MousePressed
        // TODO add your handling code here:
        sellitemClick(2);
    }//GEN-LAST:event_sell3MousePressed

    private void sell4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell4MousePressed
        // TODO add your handling code here:
        sellitemClick(3);
    }//GEN-LAST:event_sell4MousePressed

    private void sell5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell5MousePressed
        // TODO add your handling code here:
        sellitemClick(4);
    }//GEN-LAST:event_sell5MousePressed

    private void sell6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell6MousePressed
        // TODO add your handling code here:
        sellitemClick(5);
    }//GEN-LAST:event_sell6MousePressed

    private void sell7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell7MousePressed
        // TODO add your handling code here:
        sellitemClick(6);
    }//GEN-LAST:event_sell7MousePressed

    private void sell8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell8MousePressed
        // TODO add your handling code here:
        sellitemClick(7);
    }//GEN-LAST:event_sell8MousePressed

    private void sell9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell9MousePressed
        // TODO add your handling code here:
        sellitemClick(8);
    }//GEN-LAST:event_sell9MousePressed

    private void sell10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell10MousePressed
        // TODO add your handling code here:
        sellitemClick(9);
    }//GEN-LAST:event_sell10MousePressed

    private void sell11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell11MousePressed
        // TODO add your handling code here:
        sellitemClick(10);
    }//GEN-LAST:event_sell11MousePressed

    private void sell12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell12MousePressed
        // TODO add your handling code here:
        sellitemClick(11);
    }//GEN-LAST:event_sell12MousePressed

    private void sell13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell13MousePressed
        // TODO add your handling code here:
        sellitemClick(12);
    }//GEN-LAST:event_sell13MousePressed

    private void sell14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell14MousePressed
        // TODO add your handling code here:
        sellitemClick(13);
    }//GEN-LAST:event_sell14MousePressed

    private void sell15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell15MousePressed
        // TODO add your handling code here:
        sellitemClick(14);
    }//GEN-LAST:event_sell15MousePressed

    private void sell16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell16MousePressed
        // TODO add your handling code here:
        sellitemClick(15);
    }//GEN-LAST:event_sell16MousePressed

    private void sell17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell17MousePressed
        // TODO add your handling code here:
        sellitemClick(16);
    }//GEN-LAST:event_sell17MousePressed

    private void sell18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell18MousePressed
        // TODO add your handling code here:
        sellitemClick(17);
    }//GEN-LAST:event_sell18MousePressed

    private void sell19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell19MousePressed
        // TODO add your handling code here:
        sellitemClick(18);
    }//GEN-LAST:event_sell19MousePressed

    private void sell20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell20MousePressed
        // TODO add your handling code here:
        sellitemClick(19);
    }//GEN-LAST:event_sell20MousePressed

    private void sell21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell21MousePressed
        // TODO add your handling code here:
        sellitemClick(20);
    }//GEN-LAST:event_sell21MousePressed

    private void sell22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell22MousePressed
        // TODO add your handling code here:
        sellitemClick(21);
    }//GEN-LAST:event_sell22MousePressed

    private void sell23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell23MousePressed
        // TODO add your handling code here:
        sellitemClick(22);
    }//GEN-LAST:event_sell23MousePressed

    private void sell24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell24MousePressed
        // TODO add your handling code here:
        sellitemClick(23);
    }//GEN-LAST:event_sell24MousePressed

    private void sell25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell25MousePressed
        // TODO add your handling code here:
        sellitemClick(24);
    }//GEN-LAST:event_sell25MousePressed

    private void sell26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell26MousePressed
        // TODO add your handling code here:
        sellitemClick(25);
    }//GEN-LAST:event_sell26MousePressed

    private void sell27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell27MousePressed
        // TODO add your handling code here:
        sellitemClick(26);
    }//GEN-LAST:event_sell27MousePressed

    private void sell28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell28MousePressed
        // TODO add your handling code here:
        sellitemClick(27);
    }//GEN-LAST:event_sell28MousePressed

    private void sell29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell29MousePressed
        // TODO add your handling code here:
        sellitemClick(28);
    }//GEN-LAST:event_sell29MousePressed

    private void sell30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell30MousePressed
        // TODO add your handling code here:
        sellitemClick(29);
    }//GEN-LAST:event_sell30MousePressed

    private void sell31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell31MousePressed
        // TODO add your handling code here:
        sellitemClick(30);

    }//GEN-LAST:event_sell31MousePressed

    private void sell32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell32MousePressed
        // TODO add your handling code here:
        sellitemClick(31);
    }//GEN-LAST:event_sell32MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new frmScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundVillage;
    private javax.swing.JLabel CCimagePlayer;
    private javax.swing.JLabel CCweaponImage;
    private javax.swing.JLabel CSImage;
    private javax.swing.JLabel InnBackground;
    private javax.swing.JLabel MHealthBat;
    private javax.swing.JLabel MNameBat;
    private javax.swing.JLabel MlevelBat;
    private javax.swing.JLabel MonsterDamageF;
    private javax.swing.JLabel PlayerDamageF;
    private javax.swing.JLabel PlayerInn;
    private javax.swing.JButton btnAddAccount;
    private javax.swing.JButton btnAminus;
    private javax.swing.JButton btnAplus;
    private javax.swing.JButton btnAttack;
    private javax.swing.JButton btnBackWeapon;
    private javax.swing.JButton btnBattleInv;
    private javax.swing.JButton btnBattleRunAway;
    private javax.swing.JButton btnCharacterCreate;
    private javax.swing.JButton btnCharacterNext;
    private javax.swing.JButton btnCharacterReturn;
    private javax.swing.JButton btnCharacterSelectExit;
    private javax.swing.JButton btnChooseCharacter;
    private javax.swing.JButton btnCreateCharacter;
    private javax.swing.JButton btnExitInv;
    private javax.swing.JButton btnExitInv1;
    private javax.swing.JButton btnFBatbut;
    private javax.swing.JButton btnForestGo;
    private javax.swing.JButton btnForestInv;
    private javax.swing.JButton btnForestStats;
    private javax.swing.JButton btnInvDrop;
    private javax.swing.JButton btnInvEquip;
    private javax.swing.JButton btnInvRemove;
    private javax.swing.JButton btnInvUse;
    private javax.swing.JButton btnKminus;
    private javax.swing.JButton btnKplus;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnNextWeapon;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRegisterBack;
    private javax.swing.JButton btnSaveAndExitForest;
    private javax.swing.JButton btnSell;
    private javax.swing.JButton btnShopBuy;
    private javax.swing.JButton btnShopLeave;
    private javax.swing.JButton btnSminus;
    private javax.swing.JButton btnSplus;
    private javax.swing.JButton btnStatA;
    private javax.swing.JButton btnStatK;
    private javax.swing.JButton btnStatS;
    private javax.swing.JButton btnStatW;
    private javax.swing.JButton btnStatsBack;
    private javax.swing.JButton btnVillageInv;
    private javax.swing.JButton btnVillageLeave;
    private javax.swing.JButton btnVillageStats;
    private javax.swing.JButton btnWminus;
    private javax.swing.JButton btnWplus;
    private javax.swing.JButton btncharacterCreateLeave;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JLabel lblBackgroundForest;
    private javax.swing.JLabel lblCCA;
    private javax.swing.JLabel lblCCAP;
    private javax.swing.JLabel lblCCK;
    private javax.swing.JLabel lblCCMD;
    private javax.swing.JLabel lblCCMP;
    private javax.swing.JLabel lblCCPointsRemaining;
    private javax.swing.JLabel lblCCS;
    private javax.swing.JLabel lblCCW;
    private javax.swing.JLabel lblCCWD;
    private javax.swing.JLabel lblCCerror;
    private javax.swing.JLabel lblCCweaponName;
    private javax.swing.JLabel lblCSLevel;
    private javax.swing.JLabel lblCSname;
    private javax.swing.JLabel lblErrorLogin;
    private javax.swing.JLabel lblErrorRegister;
    private javax.swing.JLabel lblFBGold;
    private javax.swing.JLabel lblFBXP;
    private javax.swing.JLabel lblFBshield;
    private javax.swing.JLabel lblFbatInfo;
    private javax.swing.JLabel lblForestBackgroundBattle;
    private javax.swing.JLabel lblForestBattleMonster;
    private javax.swing.JLabel lblForestBattlePlayer;
    private javax.swing.JLabel lblForestExp;
    private javax.swing.JLabel lblForestGold;
    private javax.swing.JLabel lblForestHealth;
    private javax.swing.JLabel lblForestLevel;
    private javax.swing.JLabel lblForestName;
    private javax.swing.JLabel lblForestPlayerImage;
    private javax.swing.JLabel lblInnExp;
    private javax.swing.JLabel lblInnGold;
    private javax.swing.JLabel lblInnHealth;
    private javax.swing.JLabel lblInnInfo;
    private javax.swing.JLabel lblInnLevel;
    private javax.swing.JLabel lblInnName;
    private javax.swing.JLabel lblInv1;
    private javax.swing.JLabel lblInv10;
    private javax.swing.JLabel lblInv11;
    private javax.swing.JLabel lblInv12;
    private javax.swing.JLabel lblInv13;
    private javax.swing.JLabel lblInv14;
    private javax.swing.JLabel lblInv15;
    private javax.swing.JLabel lblInv16;
    private javax.swing.JLabel lblInv17;
    private javax.swing.JLabel lblInv18;
    private javax.swing.JLabel lblInv19;
    private javax.swing.JLabel lblInv2;
    private javax.swing.JLabel lblInv20;
    private javax.swing.JLabel lblInv21;
    private javax.swing.JLabel lblInv22;
    private javax.swing.JLabel lblInv23;
    private javax.swing.JLabel lblInv24;
    private javax.swing.JLabel lblInv25;
    private javax.swing.JLabel lblInv26;
    private javax.swing.JLabel lblInv27;
    private javax.swing.JLabel lblInv28;
    private javax.swing.JLabel lblInv29;
    private javax.swing.JLabel lblInv3;
    private javax.swing.JLabel lblInv30;
    private javax.swing.JLabel lblInv31;
    private javax.swing.JLabel lblInv32;
    private javax.swing.JLabel lblInv4;
    private javax.swing.JLabel lblInv5;
    private javax.swing.JLabel lblInv6;
    private javax.swing.JLabel lblInv7;
    private javax.swing.JLabel lblInv8;
    private javax.swing.JLabel lblInv9;
    private javax.swing.JLabel lblInvArmour;
    private javax.swing.JLabel lblInvName;
    private javax.swing.JLabel lblInvRarity;
    private javax.swing.JLabel lblInvSell;
    private javax.swing.JLabel lblInvWeapon;
    private javax.swing.JLabel lblInvinfo1;
    private javax.swing.JLabel lblInvinfo2;
    private javax.swing.JLabel lblInvinfo3;
    private javax.swing.JLabel lblInvinfo4;
    private javax.swing.JLabel lblInvinfo5;
    private javax.swing.JLabel lblInvinfo6;
    private javax.swing.JLabel lblShopGold;
    private javax.swing.JLabel lblStatA;
    private javax.swing.JLabel lblStatK;
    private javax.swing.JLabel lblStatS;
    private javax.swing.JLabel lblStatW;
    private javax.swing.JLabel lblStatsExp;
    private javax.swing.JLabel lblStatsLevel;
    private javax.swing.JLabel lblStatsPlayer;
    private javax.swing.JLabel lblStatsPoints;
    private javax.swing.JLabel lblVillageExp;
    private javax.swing.JLabel lblVillageGold;
    private javax.swing.JLabel lblVillageHealth;
    private javax.swing.JLabel lblVillageLevel;
    private javax.swing.JLabel lblVillageName;
    private javax.swing.JLabel lblVillageP;
    private javax.swing.JLabel lblbattleForestPlayerHP;
    private javax.swing.JLabel lblminShield;
    private javax.swing.JLabel lvlInvNotice;
    private javax.swing.JPanel pBattleForest;
    private javax.swing.JPanel pCharacterCreate;
    private javax.swing.JPanel pCharacterSelect;
    private javax.swing.JPanel pForest;
    private javax.swing.JPanel pInn;
    private javax.swing.JPanel pInventory;
    private javax.swing.JPanel pLogin;
    private javax.swing.JPanel pRegister;
    private javax.swing.JPanel pSell;
    private javax.swing.JPanel pShop;
    private javax.swing.JPanel pStats;
    private javax.swing.JPanel pVillage;
    private javax.swing.JPanel pcontrolBatF;
    private javax.swing.JPasswordField pfPasswordRegister;
    private javax.swing.JPanel pnlFBat;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JLabel sell1;
    private javax.swing.JLabel sell10;
    private javax.swing.JLabel sell11;
    private javax.swing.JLabel sell12;
    private javax.swing.JLabel sell13;
    private javax.swing.JLabel sell14;
    private javax.swing.JLabel sell15;
    private javax.swing.JLabel sell16;
    private javax.swing.JLabel sell17;
    private javax.swing.JLabel sell18;
    private javax.swing.JLabel sell19;
    private javax.swing.JLabel sell2;
    private javax.swing.JLabel sell20;
    private javax.swing.JLabel sell21;
    private javax.swing.JLabel sell22;
    private javax.swing.JLabel sell23;
    private javax.swing.JLabel sell24;
    private javax.swing.JLabel sell25;
    private javax.swing.JLabel sell26;
    private javax.swing.JLabel sell27;
    private javax.swing.JLabel sell28;
    private javax.swing.JLabel sell29;
    private javax.swing.JLabel sell3;
    private javax.swing.JLabel sell30;
    private javax.swing.JLabel sell31;
    private javax.swing.JLabel sell32;
    private javax.swing.JLabel sell4;
    private javax.swing.JLabel sell5;
    private javax.swing.JLabel sell6;
    private javax.swing.JLabel sell7;
    private javax.swing.JLabel sell8;
    private javax.swing.JLabel sell9;
    private javax.swing.JLabel sellGold;
    private javax.swing.JLabel sellName;
    private javax.swing.JLabel sellRarity;
    private javax.swing.JLabel sellSell;
    private javax.swing.JLabel sellinfo1;
    private javax.swing.JLabel sellinfo2;
    private javax.swing.JLabel sellinfo3;
    private javax.swing.JLabel sellinfo4;
    private javax.swing.JLabel sellinfo5;
    private javax.swing.JLabel sellinfo6;
    private javax.swing.JLabel shop0;
    private javax.swing.JLabel shop1;
    private javax.swing.JLabel shop2;
    private javax.swing.JLabel shop3;
    private javax.swing.JLabel shop4;
    private javax.swing.JLabel shop5;
    private javax.swing.JLabel shop6;
    private javax.swing.JLabel shop7;
    private javax.swing.JLabel shop8;
    private javax.swing.JLabel shop9;
    private javax.swing.JLabel shopBack;
    private javax.swing.JLabel shopinfo1;
    private javax.swing.JLabel shopinfo2;
    private javax.swing.JLabel shopinfo3;
    private javax.swing.JLabel shopinfo4;
    private javax.swing.JLabel shopinfo5;
    private javax.swing.JLabel shopinfo6;
    private javax.swing.JLabel shopinfoname;
    private javax.swing.JLabel shopinfoprice;
    private javax.swing.JLabel shopinforarity;
    private javax.swing.JTextField txtfCCPlayerName;
    private javax.swing.JPasswordField txtfPassword;
    private javax.swing.JTextField txtfUsername;
    private javax.swing.JTextField txtfUsernameRegister;
    // End of variables declaration//GEN-END:variables
}
