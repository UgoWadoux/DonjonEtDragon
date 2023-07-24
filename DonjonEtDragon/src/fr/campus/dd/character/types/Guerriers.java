package fr.campus.dd.character.types;

import fr.campus.dd.character.Personnage;
import fr.campus.dd.equipment.EquipementDefensif;
import fr.campus.dd.equipment.EquipementOffensif;
import fr.campus.dd.equipment.defenseweapons.Bouclier;
import fr.campus.dd.equipment.offenseweapons.Arme;

public class Guerriers extends Personnage {
    public Guerriers( String name) {
        super(name);
        setHealthPoint(10);
        setAttackStrength(10);
        setDefensiveEquipment(new Bouclier());
        setOffensiveEquipment(new Arme());
    }

    public Guerriers(String name, int HP, int ATK, EquipementDefensif equipementDefensif, EquipementOffensif equipementOffensif){
        super(name);
        setHealthPoint(HP);
        setAttackStrength(ATK);
        setOffensiveEquipment(equipementOffensif);
        setDefensiveEquipment(equipementDefensif);
    }
    @Override
    public String toString() {
        return "Guerriers{"
                + super.toString()+"}";
    }
}
