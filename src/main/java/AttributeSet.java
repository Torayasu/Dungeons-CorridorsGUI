public class AttributeSet {
    ValueSet[] attributeSet = new ValueSet[6];

    public AttributeSet(int Strength, int Dexterity, int Constitution, int Wisdom, int Intelligence, int Charisma) {
        attributeSet[0] = new ValueSet(Strength);
        attributeSet[1] = new ValueSet(Dexterity);
        attributeSet[2] = new ValueSet(Constitution);
        attributeSet[3] = new ValueSet(Wisdom);
        attributeSet[4] = new ValueSet(Intelligence);
        attributeSet[5] = new ValueSet(Charisma);
    }

    public ValueSet getStrength(){
        return attributeSet[0];
    }

    public ValueSet getDexterity(){
        return attributeSet[1];
    }

    public ValueSet getConstitution(){
        return attributeSet[2];
    }

    public ValueSet getWisdom(){
        return attributeSet[3];
    }

    public ValueSet getIntelligence(){
        return attributeSet[4];
    }

    public ValueSet getCharisma(){
        return attributeSet[5];
    }

}
