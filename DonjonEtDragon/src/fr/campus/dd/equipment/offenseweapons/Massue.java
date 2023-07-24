package fr.campus.dd.equipment.offenseweapons;

import fr.campus.dd.equipment.EquipementOffensif;

import java.util.Random;

public class Massue extends Arme {
    public Massue(){
        Random r = new Random();
        int low = 6;
        int high = 12;
        int n = r.nextInt(high-low)+low;
        setType(this.getClass().getSimpleName());
        setName("Massue de l'antéchrist");
        setOffensePoint(n);
    }
}
