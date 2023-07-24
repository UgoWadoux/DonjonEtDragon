package fr.campus.dd.character.ennemi;

import fr.campus.dd.character.Personnage;

public class Dragon extends Personnage {
    public Dragon(String name) {
        super(name);
        setAttackStrength(4);
        setHealthPoint(15);

    }

    @Override
    public String toString() {
        return "Dragon{} " + super.toString();
    }
}
