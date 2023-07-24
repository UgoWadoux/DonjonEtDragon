package fr.campus.dd.character.types;

import fr.campus.dd.character.Personnage;
import fr.campus.dd.equipment.EquipementDefensif;
import fr.campus.dd.equipment.EquipementOffensif;
import fr.campus.dd.equipment.defenseweapons.Bouclier;
import fr.campus.dd.equipment.offenseweapons.Arme;

public class Guerriers extends Personnage {
    EquipementOffensif equipementOffensif;
    EquipementDefensif equipementDefensif;
    public Guerriers( String name) {
        super(name);
        setHealthPoint(100);
        setAttackStrength(1);
        this.equipementOffensif = new Arme();
        equipementOffensif.setName("Epée du débutant");
        equipementOffensif.setOffensePoint(1);
        this.equipementDefensif =new Bouclier();
        equipementDefensif.setName("Bouclier du débutant");
        equipementDefensif.setDefensePoint(2);
        setDefensiveEquipment(equipementDefensif);
        setOffensiveEquipment(equipementOffensif);
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
