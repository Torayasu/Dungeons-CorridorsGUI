import com.DungeonsCorridorsGUI.internal.Armor;
import com.DungeonsCorridorsGUI.internal.Dice;
import com.DungeonsCorridorsGUI.internal.EquipmentSet;
import com.DungeonsCorridorsGUI.internal.Weapon;
import org.junit.Assert;
import org.junit.Test;

public class EquipmentSetTestSuite {
    @Test
    public void testAddWeapon(){
        EquipmentSet stuff = new EquipmentSet();


        stuff.addWeapon(new Weapon("Dagger", new Dice(6), 3));
        stuff.addWeapon(new Weapon("Dagger", new Dice(6), 3));
        stuff.addWeapon(new Weapon("Dagger", new Dice(6), 2));
        stuff.addWeapon(new Weapon("Dagger", new Dice(6), 2));

        Assert.assertEquals(1,stuff.getWeapons().size());

    }

    @Test
    public void testAddArmor(){
        EquipmentSet stuff = new EquipmentSet();

        stuff.addArmor(new Armor("Plate Armor", 10));
        stuff.addArmor(new Armor("Plate Armor", 10));
        stuff.addArmor(new Armor("Plate Armor", 12));
        stuff.addArmor(new Armor("Plate Armor", 12));
        stuff.addArmor(new Armor("Plate Armor", 12));


        Assert.assertEquals(1,stuff.getArmors().size());
    }

    @Test
    public void testStringHashCode(){
        String string1 = "Torayasu";
        String string2 = "Torayasu";
        Assert.assertEquals(string1.hashCode(), string2.hashCode());
    }
}
