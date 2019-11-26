package com.DungeonsCorridorsGUI.internal;

import java.util.HashSet;

public class EquipmentSet {
    private HashSet<Weapon> weapons = new HashSet<>();
    private HashSet<Armor> armors = new HashSet<>();

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

}
