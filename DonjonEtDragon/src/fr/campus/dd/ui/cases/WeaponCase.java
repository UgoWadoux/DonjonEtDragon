package fr.campus.dd.ui.cases;

import fr.campus.dd.equipment.EquipementOffensif;
import fr.campus.dd.equipment.offenseweapons.*;

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
        int n = r.nextInt(6);
//        System.out.println(n);
        if (n==0){
            this.offensifWeapong = new Arme();
        }
        if (n==1){
            this.offensifWeapong = new Sort();
        }
        if (n==2){
            this.offensifWeapong = new BoulesDeFeu();
        }
        if (n==3){
            this.offensifWeapong = new Eclairs();
        }
        if (n==4){
            this.offensifWeapong = new Massue();
        }
        if (n==5){
            this.offensifWeapong = new Epee();
        }
    }

    @Override
    public String toString() {
        return "WeaponCase{" +
                "arme=" + offensifWeapong +
                '}';
    }
}
