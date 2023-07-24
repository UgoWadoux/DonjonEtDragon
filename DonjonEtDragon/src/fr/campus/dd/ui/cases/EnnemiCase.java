package fr.campus.dd.ui.cases;

import fr.campus.dd.character.Personnage;
import fr.campus.dd.character.ennemi.Dragon;
import fr.campus.dd.character.ennemi.Gobelin;
import fr.campus.dd.character.ennemi.Sorcier;

import java.util.Random;

public class EnnemiCase implements Case {
    Personnage ennemi;

    public Personnage getEnnemi() {
        return ennemi;
    }

    public EnnemiCase(){
        display();
    }
    @Override
    public void display() {
        Random r = new Random();
        int n = r.nextInt(3);
        System.out.println(n);
        if (n==0){
            this.ennemi =new Gobelin("Jack");
        }
        if (n==1){
            this.ennemi = new Dragon("drake");
        }
        if (n==2){
            this.ennemi = new Sorcier("Zak");
        }
    }


    @Override
    public String toString() {
        return "EnnemiCase{" +
                "ennemi=" + ennemi +
                '}';
    }
}
