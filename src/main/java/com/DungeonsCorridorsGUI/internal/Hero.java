package com.DungeonsCorridorsGUI.internal;

public class Hero {
    AttributeSet stats;
    Weapon equippedWeapon;
    Armor equippedArmor;
    EquipmentSet equipmentSet = new EquipmentSet();
    private int exp = 0;
    private int level = 1;
    private int HP;
    private int armorClass;

    //Temporary Constructor
    public Hero(AttributeSet stats) {
        this.stats = stats;
        HP = 50;
        equippedWeapon = new Weapon("Fist", new Dice(4), 0);
        equippedArmor = new Armor("No armor",2);
        equipmentSet.addArmor(new Armor("None", 0));

        equipmentSet.addWeapon(new Weapon("Dagger", new Dice(6), 0 ));
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

    public void setStats(AttributeSet stats) {
        this.stats = stats;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }

    public int getArmorClass(){
        return equippedArmor.armorClass + getStats().getDexterity().getModifier() + 10;
    }
}
