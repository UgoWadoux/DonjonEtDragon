package fr.campus.dd.character;

import fr.campus.dd.equipment.EquipementDefensif;
import fr.campus.dd.equipment.EquipementOffensif;

public class Personnage {

    private String name;

    public String getName() {
        return name;
    }

    private int healthPoint;

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    private int attackStrength;

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }


    private EquipementDefensif defensiveEquipment;

    public EquipementDefensif getDefensiveEquipment() {
        return defensiveEquipment;
    }

    public void setDefensiveEquipment(EquipementDefensif defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    private EquipementOffensif offensiveEquipment;

    public EquipementOffensif getOffensiveEquipment() {
        return offensiveEquipment;
    }

    public void setOffensiveEquipment(EquipementOffensif offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }

    public Personnage(String name) {
        this.name = name;
    }

    public void updateHp(int modfi) {
        this.healthPoint += modfi;
    }

    @Override
    public String toString() {
        return
                " name='" + name + '\'' +
                        ", healthPoint=" + healthPoint +
                        ", attackStrength=" + attackStrength +
                        ", defensiveEquipment=" + defensiveEquipment +
                        ", offensiveEquipment=" + offensiveEquipment +
                        '}';
    }
}
