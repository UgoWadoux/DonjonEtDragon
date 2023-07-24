package fr.campus.dd.character.types;

import fr.campus.dd.character.Personnage;
import fr.campus.dd.equipment.EquipementDefensif;
import fr.campus.dd.equipment.EquipementOffensif;
import fr.campus.dd.equipment.defenseweapons.Philtre;
import fr.campus.dd.equipment.offenseweapons.Sort;

public class Magiciens extends Personnage {
    EquipementOffensif equipementOffensif;
    EquipementDefensif equipementDefensif;
    public Magiciens( String name) {
        super(name);
        setAttackStrength(1);
        setHealthPoint(6);
        this.equipementOffensif= new Sort();
        equipementOffensif.setName("Sort du débutant");
        equipementOffensif.setOffensePoint(2);
        this.equipementDefensif = new Philtre();
        equipementDefensif.setName("Philtre du débutant");
        equipementDefensif.setDefensePoint(1);
        setOffensiveEquipment(equipementOffensif);
        setDefensiveEquipment(equipementDefensif);
    }
    public Magiciens(String name, int HP, int ATK, EquipementDefensif equipementDefensif, EquipementOffensif equipementOffensif){
        super(name);
        setHealthPoint(HP);
        setAttackStrength(ATK);
        setOffensiveEquipment(equipementOffensif);
        setDefensiveEquipment(equipementDefensif);
    }


    @Override
    public String toString() {
        return "Magiciens{"
                + super.toString()+"}";
    }
}
