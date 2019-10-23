public class Hero {
    AttributeSet stats;
    Weapon equippedWeapon;
    Armor equippedArmor;
    EquipmentSet equipmentSet = new EquipmentSet();

    //Temporary Constructor
    public Hero(AttributeSet stats) {
        this.stats = stats;
        equippedWeapon = new Weapon("Fist", new Dice(4), 0);
        equippedArmor = new Armor("No armor",0);
        equipmentSet.addArmor(new Armor("Plate Armor", 10));
        equipmentSet.addArmor(new Armor("Leather Armor", 5));
        equipmentSet.addArmor(new Armor("Deadric Armor", 20));

        equipmentSet.addWeapon(new Weapon("Dagger", new Dice(6), 0 ));
        equipmentSet.addWeapon(new Weapon("Sword", new Dice(8), 1 ));
        equipmentSet.addWeapon(new Weapon("Axe", new Dice(12), 3 ));
    }

    public AttributeSet getStats() {
        return stats;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public EquipmentSet getEquipmentSet() {
        return equipmentSet;
    }
}
