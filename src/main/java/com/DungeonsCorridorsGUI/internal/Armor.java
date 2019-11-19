package com.DungeonsCorridorsGUI.internal;

import java.util.Objects;

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
        return Objects.equals(name, armor.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result;
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
