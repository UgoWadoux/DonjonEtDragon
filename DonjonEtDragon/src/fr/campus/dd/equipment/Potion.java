package fr.campus.dd.equipment;

import fr.campus.dd.character.Personnage;

public class Potion {
    private int addHealthPoint =5;

    public int getAddHealthPoint() {
        return addHealthPoint;
    }

    public void setAddHealthPoint(Personnage character) {
//        int hp =character.getHealthPoint();
//        character.setHealthPoint(hp+addHealthPoint);
        character.updateHp(addHealthPoint);
    }

    @Override
    public String toString() {
        return "Potion{" +
                "addHealthPoint=" + addHealthPoint +
                '}';
    }
}
