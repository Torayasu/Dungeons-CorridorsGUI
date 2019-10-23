public class Armor {
    String name;
    int armorClass;

    public Armor(String name, int armorClass) {
        this.name = name;
        this.armorClass = armorClass;
    }

    public String getName() {
        return name;
    }

    public int getArmorClass() {
        return armorClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Armor armor = (Armor) o;

        if (armorClass != armor.armorClass) return false;
        return name != null ? name.equals(armor.name) : armor.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + armorClass;
        return result;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + name + '\'' +
                ", armorClass=" + armorClass +
                '}';
    }
}
