package fr.campus.dd.equipment.offenseweapons;

import fr.campus.dd.equipment.EquipementOffensif;

import java.util.Random;

public class Epee extends Arme {
    public Epee(){
        Random r = new Random();
        int low = 7;
        int high = 10;
        int n = r.nextInt(high-low)+low;
        setType(this.getClass().getSimpleName());
        setName("Epee trancheuse de Goblin");
        setOffensePoint(n);
    }
}
