package fr.campus.dd.ui.cases;

import fr.campus.dd.character.Personnage;
import fr.campus.dd.database.HeroesDb;
import fr.campus.dd.equipment.Potion;

public class PotionCase implements Case{
    Potion potion;

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    public PotionCase(){
        display();

    }
    @Override
    public void display() {
        this.potion = new Potion();

    }

    public void addPotion(Personnage personnage){
        HeroesDb heroesDb =new HeroesDb();
        heroesDb.changeLifePoint(personnage, personnage.getHealthPoint()+potion.getAddHealthPoint());
        potion.setAddHealthPoint(personnage);
        System.out.println(personnage);
        heroesDb.getHeroes();
    }
    @Override
    public String toString() {
        return "PotionCase{" +
                "potion=" + potion +
                '}';
    }
}
