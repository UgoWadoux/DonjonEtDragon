package fr.campus.dd.equipment.offenseweapons;

import fr.campus.dd.equipment.EquipementOffensif;

public class Arme extends EquipementOffensif {
    public Arme(){
        setType(this.getClass().getSimpleName());
        setName("Epéé qui tue");
        setOffensePoint(1);
    }
}
