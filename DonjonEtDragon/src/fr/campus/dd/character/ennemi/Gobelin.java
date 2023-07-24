package fr.campus.dd.character.ennemi;

import fr.campus.dd.character.Personnage;

public class Gobelin extends Personnage {
    public Gobelin(String name) {
        super(name);
        setAttackStrength(1);
        setHealthPoint(6);
    }

    @Override
    public String toString() {
        return "Gobelin{ " + super.toString()+"}";
    }
}
