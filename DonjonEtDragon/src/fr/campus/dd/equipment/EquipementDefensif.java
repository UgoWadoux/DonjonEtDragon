package fr.campus.dd.equipment;

public class EquipementDefensif {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    private int defensePoint;
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

    public int getDefensePoint() {
        return defensePoint;
    }

    public void setDefensePoint(int defensePoint) {
        this.defensePoint = defensePoint;
    }

    @Override
    public String toString() {
        return "EquipementDefensif{" +
                " name='" + name + '\'' +
                ", defensePoint=" + defensePoint +
                '}';
    }
}
