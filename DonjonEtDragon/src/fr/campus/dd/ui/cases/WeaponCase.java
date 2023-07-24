package fr.campus.dd.ui.cases;

import fr.campus.dd.equipment.EquipementOffensif;
import fr.campus.dd.equipment.offenseweapons.Arme;
import fr.campus.dd.equipment.offenseweapons.Sort;

import java.util.Random;

public class WeaponCase implements Case{
    EquipementOffensif offensifWeapong;

    public EquipementOffensif getOffensifWeapong() {
        return offensifWeapong;
    }

    public WeaponCase(){
        display();
    }
    @Override
    public void display() {
        Random r = new Random();
        int n = r.nextInt(2);
        System.out.println(n);
        if (n==0){
            this.offensifWeapong = new Arme();
            offensifWeapong.setOffensePoint(11);
        }
        if (n==1){
            this.offensifWeapong = new Sort();
            offensifWeapong.setOffensePoint(5);
        }
    }

    @Override
    public String toString() {
        return "WeaponCase{" +
                "arme=" + offensifWeapong +
                '}';
    }
}
