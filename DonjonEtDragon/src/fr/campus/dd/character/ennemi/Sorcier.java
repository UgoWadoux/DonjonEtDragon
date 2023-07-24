package fr.campus.dd.character.ennemi;

import fr.campus.dd.character.Personnage;

public class Sorcier extends Personnage {
    public Sorcier(String name) {
        super(name);
        setAttackStrength(2);
        setHealthPoint(9);
    }

    @Override
    public String toString() {
        return "Sorcier{} " + super.toString();
    }
}
