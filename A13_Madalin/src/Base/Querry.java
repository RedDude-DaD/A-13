package Base;

import static Base.Connexio.conn;
import static Controller.A13_Madalin.*;
import Model.*;
import java.sql.*;

/**
 * does inserts, updates, selects from the database
 * @author radum
 */
public class Querry {

    /**
     * check if name repeats as account
     *
     * @param NameP check name repeats
     * @return true if exist acc with name
     */
    public static boolean doesAccExist(String NameP) {
        boolean exists = false;

        String sql = "SELECT * FROM account where name = '" + NameP + "'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }

    /**
     * adds account to database
     *
     * @param NameP
     * @param PassP
     * @param items
     */
    public static void addAccount(String NameP, String PassP, int items) {
        String sql = "INSERT INTO account (name, password, itemsCreated) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, NameP);
            ps.setString(2, PassP);
            ps.setInt(3, items);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * grab how many items generated the acc for id creation
     *
     * @param idAcc
     * @return returns count of items
     */
    public static int getAccItemC(int idAcc) {
        int count = 0;
        String sql = "SELECT itemsCreated FROM account where id = " + idAcc + "";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt("itemsCreated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * grabs account password
     *
     * @param NameP account
     * @param PassP password
     * @return true if password is correct
     */
    public static boolean checkAccPass(String NameP, String PassP) {
        String sql = "SELECT password FROM account where name = '" + NameP + "'";
        boolean correct = false;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String basePass = rs.getString("password");
                if (basePass.equals(PassP)) {
                    correct = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return correct;
    }

    /**
     * returns id of account
     *
     * @param NameP name
     * @return id
     */
    public static int grabAccID(String NameP) {
        int id = 0;
        String sql = "SELECT id FROM account where name = '" + NameP + "'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                id = rs.getInt("id");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * does account have characters
     *
     * @param idAcc id
     * @return true if has more then 0
     */
    public static boolean doesAccHavePlayer(int idAcc) {
        boolean has = false;
        String sql = "SELECT * FROM own where id_account = " + idAcc + "";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                has = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return has;
    }

    /**
     * adds item to item table in data base
     *
     * @param id
     * @param name
     * @param sell
     * @param buy
     * @param rarity
     * @param image
     */
    public static void addItem(String id, String name, int sell, int buy, String rarity, String image) {
        String sql = "INSERT INTO item (id, name, sellPrice, buyPrice, rarity, image) VALUES (?,?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, sell);
            ps.setInt(4, buy);
            ps.setString(5, rarity);
            ps.setString(6, image);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * adds item to data base
     *
     * @param id
     * @param wd
     * @param md
     * @param ap
     * @param mp
     */
    public static void addWeapon(String id, int wd, int md, int ap, int mp) {
        String sql = "INSERT INTO weapon (id,weaponDamage, magicDamage, armourPenetration, magicPenetration) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2, wd);
            ps.setInt(3, md);
            ps.setInt(4, ap);
            ps.setInt(5, mp);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * adds armour to data base
     *
     * @param id
     * @param pdr
     * @param mdr
     * @param str
     * @param will
     * @param knw
     * @param agi
     */
    public static void addArmour(String id, int pdr, int mdr, int str, int will, int knw, int agi) {
        String sql = "INSERT INTO armour (id, PDR, MDR, strength, will, knowledge, agility) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2, pdr);
            ps.setInt(3, mdr);
            ps.setInt(4, str);
            ps.setInt(5, will);
            ps.setInt(6, knw);
            ps.setInt(7, agi);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * adds potion to database
     *
     * @param id
     * @param value
     * @param type
     */
    public static void addPotion(String id, int value, String type) {
        String sql = "INSERT INTO potion (id, value, type) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2, value);
            ps.setString(3, type);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * add stat potion to database
     *
     * @param id
     * @param str
     * @param will
     * @param knw
     * @param agi
     */
    public static void addSPotion(String id, int str, int will, int knw, int agi) {
        String sql = "INSERT INTO statPotion (id, strength, will, knowledge, agility) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2, str);
            ps.setInt(3, will);
            ps.setInt(4, knw);
            ps.setInt(5, agi);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * add stat scroll to data base
     *
     * @param id
     * @param needed
     * @param str
     * @param will
     * @param knw
     * @param agi
     */
    public static void addSScroll(String id, int needed, int str, int will, int knw, int agi) {
        String sql = "INSERT INTO statScroll(id, neededKnowledge, strength, will, knowledge, agility) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2, needed);
            ps.setInt(3, str);
            ps.setInt(4, will);
            ps.setInt(5, knw);
            ps.setInt(6, agi);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * add protection scroll to data base
     *
     * @param id
     * @param needed
     * @param value
     */
    public static void addPScroll(String id, int needed, int value) {
        String sql = "INSERT INTO statScroll(id, neededKnowledge, value) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2, needed);
            ps.setInt(3, value);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * how many players has account
     *
     * @param idAcc
     * @return
     */
    public static int returnCharacterCountPlayer(int idAcc) {
        int count = 0;

        String sql = "SELECT * FROM own where id_account = " + idAcc + "";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    /**
     * add player to database
     *
     * @param id
     * @param name
     * @param pm
     * @param lvl
     * @param exp
     * @param gold
     * @param maxHP
     * @param curHP
     * @param shield
     * @param str
     * @param will
     * @param knw
     * @param agi
     * @param weapon
     * @param armour
     * @param dc
     * @param lastExplored
     */
    public static void addPlayer(String id, String name, String pm, int lvl, int exp, int gold, int maxHP, int curHP, int shield, int str, int will, int knw, int agi, String weapon, String armour, int dc, String lastExplored) {
        String sql = "INSERT INTO player (id, name, playerModel, level, exp, gold, maxHP, currentHP, shield, strength, will, knowledge, agility, weapon, armour, dungeonsCleared, lastExplored) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, pm);
            ps.setInt(4, lvl);
            ps.setInt(5, exp);
            ps.setInt(6, gold);
            ps.setInt(7, maxHP);
            ps.setInt(8, curHP);
            ps.setInt(9, shield);
            ps.setInt(10, str);
            ps.setInt(11, will);
            ps.setInt(12, knw);
            ps.setInt(13, agi);
            ps.setString(14, weapon);
            ps.setString(15, armour);
            ps.setInt(16, dc);
            ps.setString(17, lastExplored);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * updates player info
     *
     * @param p
     * @param last
     */
    public static void updatePlayer(Player p, String last) {
        String sql = "UPDATE player set level = ?, exp = ?, gold = ?, maxHP = ?, currentHP = ?, shield = ?, strength = ?, will = ?, knowledge = ?, agility = ?, weapon = ?, armour = ?, dungeonsCleared = ?, lastExplored = ? where id = '" + p.getId() + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getLevel());
            ps.setInt(2, p.getExp());
            ps.setInt(3, p.getGold());
            ps.setInt(4, p.getMaxHP());
            ps.setInt(5, p.getCurrentHP());
            ps.setInt(6, p.getShield());
            ps.setInt(7, p.getStrength());
            ps.setInt(8, p.getWill());
            ps.setInt(9, p.getKnowledge());
            ps.setInt(10, p.getAgility());
            ps.setString(11, p.getWeapon());
            ps.setString(12, p.getArmour());
            ps.setInt(13, p.getDungeonsCleared());
            ps.setString(14, last);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * connects account with player
     *
     * @param acc
     * @param player
     */
    public static void addOwner(int acc, String player) {
        String sql = "INSERT INTO own (id_account, id_player) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, player);
            ps.setInt(1, acc);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * creates player into array from account
     *
     * @param idAcc
     */
    public static void getPlayers(int idAcc) {
        String sql = "SELECT * FROM player where id in (select id_player from own where id_account = " + idAcc + ")";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            CaracterSelect.clear();
            while (rs.next()) {
                CaracterSelect.add(new Player(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("playerModel"),
                        rs.getInt("level"),
                        rs.getInt("exp"),
                        rs.getInt("gold"),
                        rs.getInt("maxHP"),
                        rs.getInt("currentHP"),
                        rs.getInt("shield"),
                        rs.getInt("strength"),
                        rs.getInt("will"),
                        rs.getInt("knowledge"),
                        rs.getInt("agility"),
                        rs.getInt("dungeonsCleared")
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * adds item count to account
     *
     * @param idAcc
     * @param items
     */
    public static void addItemCountToAcc(int idAcc, int items) {
        String sql = "Update account set itemsCreated = " + items + " where id = " + idAcc + "";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * connects player with item in backpack
     *
     * @param player
     * @param item
     */
    public static void addItemTOInventory(String player, String item) {
        String sql = "INSERT INTO backpack (player,item) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, player);
            ps.setString(2, item);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * gets player armour or weapon
     *
     * @param id
     * @param item
     * @return
     */
    public static String getPlayerItem(String id, String item) {
        String sql = "SELECT * FROM player where id = '" + id + "'";
        String output = "";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                if (item.equals("weapon")) {
                    output = rs.getString("weapon");
                } else {
                    output = rs.getString("armour");
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    /**
     * creates a weapon in an array based on an id
     *
     * @param id
     */
    public static void createWeaponforPlayer(String id) {
        String sql = "SELECT * FROM item where id = '" + id + "'";
        String ID = "";
        String name = "";
        int sell = 0;
        int buy = 0;
        String rarity = "";
        String image = "";
        int wd = 0;
        int md = 0;
        int ap = 0;
        int mp = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                ID = rs.getString("id");
                name = rs.getString("name");
                sell = rs.getInt("sellPrice");
                buy = rs.getInt("buyPrice");
                rarity = rs.getString("rarity");
                image = rs.getString("image");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "SELECT * FROM weapon where id = '" + id + "'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                wd = rs.getInt("weaponDamage");
                md = rs.getInt("magicDamage");
                ap = rs.getInt("armourPenetration");
                mp = rs.getInt("magicPenetration");
            }

            currentPlayer.getFirst().addWeapon(new Weapon(wd, md, ap, mp, ID, name, sell, buy, rarity, image));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * adds armour in array from specified id
     *
     * @param id
     */
    public static void createArmourforPlayer(String id) {
        String sql = "SELECT * FROM item where id = '" + id + "'";
        String ID = "";
        String name = "";
        int sell = 0;
        int buy = 0;
        String rarity = "";
        String image = "";
        int PDR = 0;
        int MDR = 0;
        int str = 0;
        int will = 0;
        int knw = 0;
        int agi = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                ID = rs.getString("id");
                name = rs.getString("name");
                sell = rs.getInt("sellPrice");
                buy = rs.getInt("buyPrice");
                rarity = rs.getString("rarity");
                image = rs.getString("image");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "SELECT * FROM armour where id = '" + id + "'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PDR = rs.getInt("PDR");
                MDR = rs.getInt("MDR");
                str = rs.getInt("strength");
                will = rs.getInt("will");
                knw = rs.getInt("knowledge");
                agi = rs.getInt("agility");
            }
            currentPlayer.getFirst().addArmour(new Armour(PDR, MDR, str, will, knw, agi, ID, name, sell, buy, rarity, image));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * creates items from database, selected player
     *
     * @param id
     */
    public static void CreateItemsforPlayer(String id) {
        String sql = "SELECT * FROM item where id in (select item from backpack where player = '" + id + "')";
        String ID = "";
        String name = "";
        int sell = 0;
        int buy = 0;
        String rarity = "";
        String image = "";
        String sqlD = "";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ID = rs.getString("id");
                name = rs.getString("name");
                sell = rs.getInt("sellPrice");
                buy = rs.getInt("buyPrice");
                rarity = rs.getString("rarity");
                image = rs.getString("image");

                switch (name) {
                    case "Sword":
                        sqlD = "select * from weapon where id = '" + ID + "'";
                        break;
                    case "Healing Potion":
                        sqlD = "select * from potion where id = '" + ID + "'";
                        break;
                    case "SpellBook":
                        sqlD = "select * from weapon where id = '" + ID + "'";
                        break;
                    case "Cloth Armour":
                        sqlD = "select * from armour where id = '" + ID + "'";
                        break;
                    case "Crystal Sword":
                        sqlD = "select * from weapon where id = '" + ID + "'";
                        break;
                    case "Leather Armour":
                        sqlD = "select * from armour where id = '" + ID + "'";
                        break;
                    case "Metal Armour":
                        sqlD = "select * from armour where id = '" + ID + "'";
                        break;
                    case "Potion of Protection":
                        sqlD = "select * from potion where id = '" + ID + "'";
                        break;
                    case "Stat Potion":
                        sqlD = "select * from statPotion where id = '" + ID + "'";
                        break;
                    case "Scroll of Protection":
                        sqlD = "select * from protectionScroll where id = '" + ID + "'";
                        break;
                    case "Stat Scroll":
                        sqlD = "select * from statScroll where id = '" + ID + "'";
                        break;
                }

                try {
                    Statement stmtD = conn.createStatement();
                    ResultSet rsD = stmtD.executeQuery(sqlD);
                    while (rsD.next()) {
                        switch (name) {
                            case "Sword":
                                InvWeapon.add(new Weapon(rsD.getInt("weaponDamage"), rsD.getInt("magicDamage"), rsD.getInt("armourPenetration"), rsD.getInt("magicPenetration"), ID, name, sell, buy, rarity, image));
                                break;
                            case "Healing Potion":
                                InvPotion.add(new Potion(rsD.getInt("value"), rsD.getString("type"), ID, name, sell, buy, rarity, image));
                                break;
                            case "SpellBook":
                                InvWeapon.add(new Weapon(rsD.getInt("weaponDamage"), rsD.getInt("magicDamage"), rsD.getInt("armourPenetration"), rsD.getInt("magicPenetration"), ID, name, sell, buy, rarity, image));
                                break;
                            case "Cloth Armour":
                                InvArmour.add(new Armour(rsD.getInt("PDR"), rsD.getInt("MDR"), rsD.getInt("strength"), rsD.getInt("will"), rsD.getInt("knowledge"), rsD.getInt("agility"), ID, name, sell, buy, rarity, image));
                                break;
                            case "Crystal Sword":
                                InvWeapon.add(new Weapon(rsD.getInt("weaponDamage"), rsD.getInt("magicDamage"), rsD.getInt("armourPenetration"), rsD.getInt("magicPenetration"), ID, name, sell, buy, rarity, image));
                                break;
                            case "Leather Armour":
                                InvArmour.add(new Armour(rsD.getInt("PDR"), rsD.getInt("MDR"), rsD.getInt("strength"), rsD.getInt("will"), rsD.getInt("knowledge"), rsD.getInt("agility"), ID, name, sell, buy, rarity, image));
                                break;
                            case "Metal Armour":
                                InvArmour.add(new Armour(rsD.getInt("PDR"), rsD.getInt("MDR"), rsD.getInt("strength"), rsD.getInt("will"), rsD.getInt("knowledge"), rsD.getInt("agility"), ID, name, sell, buy, rarity, image));
                                break;
                            case "Potion of Protection":
                                InvPotion.add(new Potion(rsD.getInt("value"), rsD.getString("type"), ID, name, sell, buy, rarity, image));
                                break;
                            case "Stat Potion":
                                InvSPotion.add(new StatPotion(rsD.getInt("strength"), rsD.getInt("will"), rsD.getInt("knowledge"), rsD.getInt("agility"), ID, name, sell, buy, rarity, image));
                                break;
                            case "Scroll of Protection":
                                InvPScroll.add(new PScroll(rsD.getInt("neededKnowledge"), rsD.getInt("value"), ID, name, sell, buy, rarity, image));
                                break;
                            case "Stat Scroll":
                                InvSScroll.add(new SScroll(rsD.getInt("neededKnowledge"), rsD.getInt("strength"), rsD.getInt("will"), rsD.getInt("knowledge"), rsD.getInt("agility"), ID, name, sell, buy, rarity, image));
                                break;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * deletes all player items backpack
     *
     * @param idPly
     */
    public static void deletePlayerInventory(String idPly) {
        String sql = "Delete from item where id in (select item from backpack where player = '" + idPly + "')";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    /**
     * deletes player when dies
     * @param id
     */
    public static void deletePlayer(String id) {
        String sql = "Delete from player where id = '" + id + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}
