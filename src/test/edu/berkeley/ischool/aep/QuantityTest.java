package edu.berkeley.ischool.aep;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by chrisfan on 2/8/14.
 */
public class QuantityTest {

    @Test
    public void ShouldBeEqualQuantity12BaseUnitTo1New(){
        Quantity unit1 = new Quantity(10,"a", 10, "a");
        Quantity unit2 = new Quantity(1, "b", 10, "a");
        Assert.assertEquals(10,unit1.showValue());
        Assert.assertEquals("a", unit1.showUnitType());
        Assert.assertEquals("a", unit2.showBaseUnittype());
        Assert.assertEquals(10, unit2.showBaseValue());
    }

    @Test
    public void ShouldBeEqualBecauseBaseUnitsSame(){
        Quantity unit1 = new Quantity(1, "b", 10, "d");
        Quantity unit2 = new Quantity(1,"b", 10,"d");

        Assert.assertEquals(unit1, unit1);
        Assert.assertEquals(unit1, new Quantity(1, "q", 10, "d"));
        Assert.assertEquals(unit1, unit2);
    }

    @Test
    public void ShouldEvaluateTrueTestEquals(){
        Quantity unit1 = new Quantity(1, "b", 100, "d");
        Quantity unit2 = new Quantity(1,"c", 100,"d");
        Quantity unit3 = new Quantity(5,"i", 1000, "de");

        System.out.println("Unit 1 hashcode: " + String.valueOf(unit1.hashCode()));
        System.out.println("Unit 2 hashcode: " + String.valueOf(unit2.hashCode()));
        System.out.println("Unit 3 hashcode: " + String.valueOf(unit3.hashCode()));
        Assert.assertEquals(unit1.hashCode(),unit2.hashCode());
        Assert.assertEquals(unit1.hashCode(), (new Quantity(1,"e", 100, "d")).hashCode());
        Assert.assertTrue(unit1 == unit1);
        Assert.assertEquals(unit1, unit2);
        Assert.assertTrue(unit1 ==unit2);

    }
}
