package com.DungeonsCorridorsGUI.internal;

public class Weapon {
    private String name;
    private Dice damageDice;
    private int dmgModifier;

    public Weapon(String name, Dice damageDice, int dmgModifier) {
        this.name = name;
        this.damageDice = damageDice;
        this.dmgModifier = dmgModifier;
    }

    public Dice getDamageDice() {
        return damageDice;
    }

    public int getDmgModifier() {
        return dmgModifier;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        Weapon weapon = (Weapon) o;
        if ( ((Weapon) o).getName().equals(this.name)
                && ((Weapon) o).getDamageDice().getNoOfSides() == this.damageDice.getNoOfSides()
        && ((Weapon) o).getDmgModifier() == this.dmgModifier) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = name.hashCode() + dmgModifier + damageDice.getNoOfSides();
        return result;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", damageDice=" + damageDice +
                ", dmgModifier=" + dmgModifier +
                '}';
    }
}
