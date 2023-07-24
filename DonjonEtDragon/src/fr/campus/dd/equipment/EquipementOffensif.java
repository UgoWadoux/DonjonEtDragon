package fr.campus.dd.equipment;

import fr.campus.dd.character.Personnage;

public class EquipementOffensif {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    private int offensePoint;
    private String type;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOffensePoint() {
        return offensePoint;
    }

    public void setOffensePoint(int offensePoint) {
        this.offensePoint = offensePoint;
    }

    @Override
    public String toString() {
        return "EquipementOffensif{" +
                "name='" + name + '\'' +
                ", offensePoint=" + offensePoint +
                '}';
    }
}
