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
}
