package fr.campus.dd.equipment.defenseweapons;

import fr.campus.dd.equipment.EquipementDefensif;

public class Bouclier extends EquipementDefensif {

    public Bouclier() {
        setType(this.getClass().getSimpleName());
        setName("Bouclier de la mort");
        setDefensePoint(10);
    }
}
