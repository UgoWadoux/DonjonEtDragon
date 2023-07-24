package fr.campus.dd.equipment.defenseweapons;

import fr.campus.dd.equipment.EquipementDefensif;

public class Philtre extends EquipementDefensif {
    public Philtre() {
        setType(this.getClass().getSimpleName());
        setName("Serum de defense maximal");
        setDefensePoint(10);
    }
}
