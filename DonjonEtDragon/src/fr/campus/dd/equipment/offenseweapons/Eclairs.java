package fr.campus.dd.equipment.offenseweapons;

import fr.campus.dd.equipment.EquipementOffensif;

import java.util.Random;

public class Eclairs extends Sort {
    public Eclairs() {
        Random r = new Random();
        int low = 8;
        int high = 16;
        int n = r.nextInt(high-low)+low;
        setType(this.getClass().getSimpleName());
        setName("Eclair foudroyant");
        setOffensePoint(n);

    }
}
