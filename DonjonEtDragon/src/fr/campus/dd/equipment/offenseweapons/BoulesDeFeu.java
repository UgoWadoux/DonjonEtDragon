package fr.campus.dd.equipment.offenseweapons;

import fr.campus.dd.equipment.EquipementOffensif;

import java.util.Random;

public class BoulesDeFeu extends Sort {
    public BoulesDeFeu(){
        Random r = new Random();
        int low = 6;
        int high = 19;
        int n = r.nextInt(high-low)+low;
        setType(this.getClass().getSimpleName());
        setName("Boules de feu magistrales");
        setOffensePoint(n);
    }
}
