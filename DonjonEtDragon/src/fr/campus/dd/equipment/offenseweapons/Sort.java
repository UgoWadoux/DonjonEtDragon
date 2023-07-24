package fr.campus.dd.equipment.offenseweapons;

import fr.campus.dd.equipment.EquipementOffensif;

public class Sort extends EquipementOffensif {
    public Sort() {
        setType(this.getClass().getSimpleName());
        setName("Baton de sagesse ultime");
        setOffensePoint(2);
    }
}
