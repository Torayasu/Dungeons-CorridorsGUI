package com.DungeonsCorridorsGUI.internal;

public class Hero {
    private AttributeSet stats;
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private EquipmentSet equipmentSet = new EquipmentSet();
    private int exp = 0;
    private int level = 1;
    private int HP;
    private int armorClass;

    public Hero(AttributeSet stats) {
        this.stats = stats;
        HP = 50;
        equippedWeapon = new Weapon("Fist", new Dice(4), 0);
        equippedArmor = new Armor("None",0);
        equipmentSet.addArmor(new Armor("None", 0));
        equipmentSet.addArmor(new Armor("Plate Armor", 10));
        equipmentSet.addWeapon(new Weapon("Dagger", new Dice(6), 0 ));
        equipmentSet.addWeapon(new Weapon("Sword", new Dice(10), 2));

    }

    public void levelUp(){
        int tmpStrength, tmpDexterity, tmpConstitution;
        Dice HPDice = new Dice(10);

        HP = HP + HPDice.cast() + stats.getConstitution().getModifier();

        tmpStrength = stats.getStrength().getAttribute();
        stats.getStrength().setAttribute(++tmpStrength);

        tmpDexterity = stats.getDexterity().getAttribute();
        stats.getDexterity().setAttribute(++tmpDexterity);

        tmpConstitution = stats.getConstitution().getAttribute();
        stats.getConstitution().setAttribute(++tmpConstitution);


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
        if (exp / (level*1000) >= 1) {
            levelUp();
            level++;
        }
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getArmorClass(){
        return equippedArmor.armorClass + getStats().getDexterity().getModifier() + 10;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }
}
