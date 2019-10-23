import org.junit.Assert;
import org.junit.Test;

public class AttributeSetTestSuite {

    @Test
    public void testAttributeSetConstructor(){
        AttributeSet stats = new AttributeSet(18,16,14,1,0,-2);


        Assert.assertEquals(4, stats.getStrength().getModifier());
        Assert.assertEquals(3, stats.getDexterity().getModifier());
        Assert.assertEquals(2, stats.getConstitution().getModifier());
        Assert.assertEquals(-4, stats.getWisdom().getModifier());
        Assert.assertEquals(-4, stats.getIntelligence().getModifier());
        Assert.assertEquals(-4, stats.getCharisma().getModifier());
    }
}
