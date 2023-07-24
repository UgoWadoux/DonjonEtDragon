package fr.campus.dd.character.types;

import fr.campus.dd.character.Personnage;
import fr.campus.dd.equipment.EquipementDefensif;
import fr.campus.dd.equipment.EquipementOffensif;
import fr.campus.dd.equipment.defenseweapons.Philtre;
import fr.campus.dd.equipment.offenseweapons.Sort;

public class Magiciens extends Personnage {
    public Magiciens( String name) {
        super(name);
        setAttackStrength(15);
        setHealthPoint(6);
        setOffensiveEquipment(new Sort());
        setDefensiveEquipment(new Philtre());
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
