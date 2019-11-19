package com.DungeonsCorridorsGUI.internal;

public class ValueSet {
    private int attribute;
    private int modifier;

    public ValueSet(int attribute) {
        this.attribute = attribute;
        modifier = (attribute-10) / 2;
        if (attribute <= 0){
            modifier = -4;
        }
    }

    public int getAttribute() {
        return attribute;
    }

    public int getModifier() {
        return modifier;
    }

    public void setAttribute(int newAttribute){
        attribute = newAttribute;
        modifier = (attribute-10) / 2;
        if (attribute <= 0){
            modifier = -4;
        }
    }

    @Override
    public String toString() {
        return attribute +
                " / " + modifier;
    }
}
