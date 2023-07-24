package fr.campus.dd.database;

import com.google.gson.Gson;
import fr.campus.dd.character.Personnage;
import fr.campus.dd.character.types.Guerriers;
import fr.campus.dd.character.types.Magiciens;
import fr.campus.dd.equipment.EquipementDefensif;
import fr.campus.dd.equipment.EquipementOffensif;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.Objects;

public class HeroesDb {
    DbManager database;
    Connection connection;

    Personnage character;
    public void getHeroes() {
        this.database = new DbManager();
        this.connection = database.getCon();
        String requete = "SELECT * FROM Hero";
        ResultSet resultats = null;


        try {
            Statement stmt = connection.createStatement();
            resultats = stmt.executeQuery(requete);
//            System.out.println(resultats);
            ResultSetMetaData rsmd = resultats.getMetaData();
            int nbCols = rsmd.getColumnCount();
//            System.out.println(rsmd);
            while (resultats.next()) {
                for (int i = 1; i <= nbCols; i++)
                    System.out.print(resultats.getString(i) + " ");
                System.out.println();
            }
            resultats.close();

        } catch (SQLException e) {
            //traitement de l'exception
            System.out.println("Mauvaise manip");
        }
    }

    public void createHero(Personnage hero) {
        this.database = new DbManager();
        this.connection = database.getCon();
        String requete = "INSERT INTO Hero ( Type, Name, HealthPoint, AttackPoint, OffensivWeapon, DefensivWeapon) VALUES(?,?,?,?,?,?)";
        int hp = hero.getHealthPoint();
        int attak = hero.getAttackStrength();
        EquipementOffensif offensivWeapon = hero.getOffensiveEquipment();
        String name = hero.getName();
        Gson gson = new Gson();
        String jsonOffWeapon = gson.toJson(offensivWeapon);
        EquipementDefensif defensivWeapon = hero.getDefensiveEquipment();
        String jsonOfArmor =gson.toJson(defensivWeapon);

        String type = hero.getClass().getSimpleName();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
//            Statement stmt = connection.createStatement();
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, hp);
            preparedStatement.setInt(4, attak);
            preparedStatement.setString(5, jsonOffWeapon);
            preparedStatement.setString(6, jsonOfArmor);

            int resultats = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //traitement de l'exception
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editHero(Personnage hero, String oldPerso) {
        this.database = new DbManager();
        this.connection = database.getCon();
        String requete = "UPDATE Hero SET Type=?, Name = ?, HealthPoint=?, AttackPoint=?, OffensivWeapon=?,DefensivWeapon=? WHERE Name =?";
        int hp = hero.getHealthPoint();
        int attak = hero.getAttackStrength();
        String name = hero.getName();
        Gson gson = new Gson();
        EquipementOffensif offensivWeapon = hero.getOffensiveEquipment();
        EquipementDefensif defensivWeapon = hero.getDefensiveEquipment();
        String jsonOffWeapon =gson.toJson(offensivWeapon);
        String jsonDefWeapon = gson.toJson(defensivWeapon);
        String type = hero.getClass().getSimpleName();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
//            Statement stmt = connection.createStatement();
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, hp);
            preparedStatement.setInt(4, attak);
            preparedStatement.setString(5, jsonOffWeapon);
            preparedStatement.setString(6, jsonDefWeapon);
            preparedStatement.setString(7, oldPerso);

            int resultats = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //traitement de l'exception
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeLifePoint(Personnage hero, int newHp) {
        this.database = new DbManager();
        this.connection = database.getCon();
        String requete = "UPDATE Hero SET HealthPoint=? WHERE Name =?";
        String name = hero.getName();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
//            Statement stmt = connection.createStatement();

            preparedStatement.setString(2, name);
            preparedStatement.setInt(1, newHp);
            int resultats = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //traitement de l'exception
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePerso(String name) {
        this.database = new DbManager();
        this.connection = database.getCon();
        String requete = "DELETE FROM Hero WHERE Name=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setString(1, name);
            int resultats = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //traitement de l'exception
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int nullCheck() {
        this.database = new DbManager();
        this.connection = database.getCon();
        String requete = "SELECT * FROM Hero";
        int count = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
            ResultSet resultats = preparedStatement.executeQuery();
            while (resultats.next()) {
                count++;
            }
        } catch (SQLException e) {
            //traitement de l'exception
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public void getOneHeroe(String name) {
        this.database = new DbManager();
        this.connection = database.getCon();
        String requete = "SELECT * FROM Hero WHERE Name=?";
        ResultSet resultats = null;
        String type = null;
        int HP = 0;
        int ATK =0;
        String offWeapon = null;
        String defWeapon = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setString(1, name);
             resultats = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = resultats.getMetaData();
            int nbCols = rsmd.getColumnCount();
            while (resultats.next()) {
                for (int i = 1; i <= nbCols; i++)
                 type = resultats.getString("Type");
                HP = resultats.getInt("HealthPoint");
                ATK = resultats.getInt("AttackPoint");
                defWeapon = resultats.getString("DefensivWeapon");
                offWeapon = resultats.getString("OffensivWeapon");
                System.out.println();
            }
            System.out.println(type);
            System.out.println(HP);
            System.out.println(ATK);
            System.out.println(name);
            System.out.println(defWeapon);
            System.out.println(offWeapon);
            Gson gson =new Gson();
            EquipementOffensif equipementOffensif = gson.fromJson(offWeapon, EquipementOffensif.class);
            EquipementDefensif equipementDefensif =gson.fromJson(defWeapon, EquipementDefensif.class);
            System.out.println(equipementOffensif);
            System.out.println(equipementDefensif);
            assert type != null;
            if (type.equals("Guerriers")){
                this.character = new Guerriers(name,HP,ATK,equipementDefensif,equipementOffensif);
            }
            if (type.equals("Magiciens")){
                this.character = new Magiciens(name,HP,ATK,equipementDefensif,equipementOffensif);
            }

            resultats.close();

        } catch (SQLException e) {
            //traitement de l'exception
            System.out.println("Mauvaise manip");
        }
    }

    public Personnage getCharacter() {
        return character;
    }
}
