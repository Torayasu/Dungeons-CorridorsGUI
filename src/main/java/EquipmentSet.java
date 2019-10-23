import java.util.HashSet;
import java.util.Set;

public class EquipmentSet {
    private HashSet<Weapon> weapons = new HashSet<>();
    private HashSet<Armor> armors = new HashSet<>();
    private Set<Item> items;
    private int amountOfGold;

    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
    }

    public void addArmor(Armor armor){
        armors.add(armor);
    }

    public HashSet<Weapon> getWeapons() {
        return weapons;
    }

    public HashSet<Armor> getArmors() {
        return armors;
    }

    public Set<Item> getItems() {
        return items;
    }

    public int getAmountOfGold() {
        return amountOfGold;
    }
}
