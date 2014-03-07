package edu.berkeley.ischool.aep;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by chrisfan on 2/8/14.
 */
public class QuantityTest {


    @Test
    public void unitQuantitiesShouldBeEqual(){
        Assert.assertEquals(new ArithmeticQuantity(Unit.YARDS, 1.0), new ArithmeticQuantity(Unit.FEET, 3.0));
        Assert.assertEquals(new ArithmeticQuantity(Unit.YARDS, 1760), new ArithmeticQuantity(Unit.MILES,1));
        Assert.assertEquals(new ArithmeticQuantity(Unit.CUP, 1), new ArithmeticQuantity(Unit.TEASPOON, 48));
        Assert.assertEquals(new ArithmeticQuantity(Unit.OUNCE, 1), new ArithmeticQuantity(Unit.TEASPOON, 6));

    }
    @Test
    public void shouldBe2AddUnits(){
//        System.out.println(ArithmeticQuantity.add(new ArithmeticQuantity(Unit.FEET,2),new ArithmeticQuantity(Unit.FEET,2) ));
        Assert.assertEquals(new ArithmeticQuantity(Unit.FEET, 4), ArithmeticQuantity.add(new ArithmeticQuantity(Unit.FEET, 2), new ArithmeticQuantity(Unit.FEET, 2)));
    }
    @Test
    public void shouldBe10TSP2TBS2TSP(){
        ArithmeticQuantity sum;
        sum = ArithmeticQuantity.add(new ArithmeticQuantity(Unit.TABLESPOON, 2), new ArithmeticQuantity(Unit.TEASPOON, 2));
        Assert.assertEquals(new ArithmeticQuantity(Unit.TEASPOON, 8), sum);
    }

    @Test
    public void shouldBe1Mile1750YardsAdd10Feet(){
        ArithmeticQuantity sum;
        sum = ArithmeticQuantity.add(new ArithmeticQuantity(Unit.YARDS, 1750), new ArithmeticQuantity(Unit.FEET, 30));
        Assert.assertEquals(new ArithmeticQuantity(Unit.MILES, 1), sum);
    }

    @Test
    public void shouldBeFalseSameTypeVolumeAndDistance(){
    ArithmeticQuantity volume = new ArithmeticQuantity(Unit.OUNCE,1);
    ArithmeticQuantity distance = new ArithmeticQuantity(Unit.FEET,1);
    ArithmeticQuantity volume2 = new ArithmeticQuantity(Unit.CUP,1);
    Assert.assertFalse(volume.checkSameUnitType(distance));
    Assert.assertTrue(volume.checkSameUnitType(volume2));

    }

    //checked exception vs. runtime exception
    @Test (expected = RuntimeException.class)
    public void twoOZPlus1FoodThrowsExcpetion(){
        ArithmeticQuantity sum;
        sum = ArithmeticQuantity.add(new ArithmeticQuantity(Unit.OUNCE, 2), new ArithmeticQuantity(Unit.FEET, 1));
        Assert.assertEquals(new ArithmeticQuantity(Unit.MILES, 1), sum);
    }

    @Test
    public void shouldBeEqual212Fand100C(){
        ScalarQuantity temp1 = new ScalarQuantity(Unit.FAHRENHEIT, 212);
        ScalarQuantity temp2 = new ScalarQuantity(Unit.CELSIUS, 100);
        Assert.assertEquals(temp1, temp2);
    }

    @Test
    public void shouldBeEqual30Celsiusand86Fahrenheit(){
        Assert.assertEquals(new ScalarQuantity(Unit.CELSIUS, 30), new ScalarQuantity(Unit.FAHRENHEIT, 86));
        Assert.assertEquals( new ScalarQuantity(Unit.FAHRENHEIT, 86),new ScalarQuantity(Unit.CELSIUS, 30));
    }

    @Test
    public void shouldBeEqualSameTemperatures(){
        Assert.assertEquals(new ScalarQuantity(Unit.CELSIUS, 30), new ScalarQuantity(Unit.CELSIUS, 30));
        Assert.assertEquals(new ScalarQuantity(Unit.FAHRENHEIT, 30), new ScalarQuantity(Unit.FAHRENHEIT, 30));
    }

    @Test  (expected = RuntimeException.class)
    public void shouldThrowTypeExceptionVolumeBetterThanDistance(){
    ArithmeticQuantity q1 = new ArithmeticQuantity(Unit.FEET,1);
    ArithmeticQuantity q2 = new ArithmeticQuantity(Unit.OUNCE,1);
    Assert.assertEquals(0, q1.better(q2));
    }

    @Test  (expected = RuntimeException.class)
    public void shouldThrowTypeExceptionTemperatureBetterThanDistance(){
        ArithmeticQuantity q1 = new ArithmeticQuantity(Unit.FEET,1);
        ScalarQuantity q2 = new ScalarQuantity(Unit.FAHRENHEIT, 1);
        Assert.assertEquals(0, q1.better(q2));
    }

    @Test
    public void shouldBeZeroSameUnitTypeAndSize(){
        ArithmeticQuantity q1 = new ArithmeticQuantity(Unit.FEET, 1);
        Assert.assertEquals(0, q1.better(q1));
        Assert.assertEquals(0, (new ScalarQuantity(Unit.CELSIUS,1)).better(new ScalarQuantity(Unit.CELSIUS,1)));
    }

    @Test
    public void shouldBeMinusOne1FootBetterThan1Yard(){
        ArithmeticQuantity q1 = new ArithmeticQuantity(Unit.FEET,1);
        ArithmeticQuantity q2 = new ArithmeticQuantity(Unit.YARDS,1);
        Assert.assertEquals(-1,q1.better(q2));
        Assert.assertEquals(1,q2.better(q1));
        Assert.assertFalse( -1 == q2.better(q1));
    }

    @Test (expected = RuntimeException.class)
    public void shouldThrowTypeExceptionBestListMismatchtype(){
        ArithmeticQuantity q1 = new ArithmeticQuantity(Unit.FEET,1);
        ArithmeticQuantity q2 = new ArithmeticQuantity(Unit.YARDS,1);
        ScalarQuantity q3 = new ScalarQuantity(Unit.FAHRENHEIT,1);

        Assert.assertEquals(q3, ArithmeticQuantity.best(q1,q2,q3));
    }

    @Test
    public void shouldbe1MileBestIn1Mile1Yard1Foot(){
        ArithmeticQuantity q1 = new ArithmeticQuantity(Unit.FEET,1);
        ArithmeticQuantity q2 = new ArithmeticQuantity(Unit.YARDS,1);
        ArithmeticQuantity q3 = new ArithmeticQuantity(Unit.MILES,1);
        ArithmeticQuantity q4 = new ArithmeticQuantity(Unit.MILES, 10);
        Assert.assertEquals(q3, ArithmeticQuantity.best(q1,q2,q3));
        Assert.assertEquals(q4, ArithmeticQuantity.best(q1,q4,q2,q3));
    }

    @Test
    public void shouldbe1CupBest1Tbs1Oz1Tsp(){
        ArithmeticQuantity q1 = new ArithmeticQuantity(Unit.CUP,1);
        ArithmeticQuantity q2 = new ArithmeticQuantity(Unit.OUNCE,1);
        ArithmeticQuantity q3 = new ArithmeticQuantity(Unit.TABLESPOON,1);
        ArithmeticQuantity q4 = new ArithmeticQuantity(Unit.TEASPOON, 10);
        Assert.assertEquals(q1, ArithmeticQuantity.best(q1,q4,q2,q3));
        Assert.assertEquals(q1, ArithmeticQuantity.best(q4,q3,q2,q1));
    }

    @Test
    public void shouldbe100DegreesCBest(){
        ScalarQuantity q1 = new ScalarQuantity(Unit.FAHRENHEIT,100);
        ScalarQuantity q2 = new ScalarQuantity(Unit.CELSIUS, 100);
        ScalarQuantity q3 = new ScalarQuantity(Unit.CELSIUS, -10);
        ScalarQuantity q4 = new ScalarQuantity(Unit.FAHRENHEIT,32);
        ArithmeticQuantity q5 = new ArithmeticQuantity(Unit.FEET,1);
        Assert.assertEquals(q2, ScalarQuantity.best(q4,q2,q1,q3));
        Assert.assertEquals(q2, ArithmeticQuantity.best(q4, q2, q1, q3));
        Assert.assertEquals(q2, ArithmeticQuantity.best(q1, q3, q2, q4));

    }
}
