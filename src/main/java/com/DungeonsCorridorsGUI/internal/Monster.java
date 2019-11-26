package com.DungeonsCorridorsGUI.internal;

public class Monster {
    private int HP;
    private Dice dmgDice;
    private int dmgModifier;
    private String name;
    private int armorClass;
    private int melee;

    public Monster(int HP, Dice dmgDice, int dmgModifier, String name, int armorClass, int melee) {
        this.HP = HP;
        this.dmgDice = dmgDice;
        this.dmgModifier = dmgModifier;
        this.name = name;
        this.armorClass = armorClass;
        this.melee = melee;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public Dice getDmgDice() {
        return dmgDice;
    }

    public int getDmgModifier() {
        return dmgModifier;
    }

    public String getName() {
        return name;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getMelee() {
        return melee;
    }
}
