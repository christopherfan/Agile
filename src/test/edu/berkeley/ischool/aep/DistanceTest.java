package edu.berkeley.ischool.aep;

import junit.framework.Assert;
import org.junit.Test;
import sun.security.x509.DistributionPointName;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by chrisfan on 2/8/14.
 */
public class DistanceTest {

    @Test
    public void ShouldOutputDistanceValueAndUnit(){
        Distance testFeet = Distance.createFeet(5);
        Distance testYard = Distance.createYards(1);
        assertEquals(5, testFeet.showValue());
        assertEquals("feet", testFeet.showUnitType());
        assertEquals("feet", testFeet.showBaseUnittype());
        assertEquals(5, testFeet.showBaseValue());
        assertEquals(1, testYard.showValue());
        assertEquals("yard", testYard.showUnitType());
        assertEquals("feet", testYard.showBaseUnittype());
        assertEquals(3, testYard.showBaseValue());
    }

    @Test
    public void ShouldBe1Yardto3FeetBaseUnit(){
        Distance test1Yard = Distance.createYards(1);
        Distance test2Yards = Distance.createYards(2);
        assertFalse(2 == test1Yard.showBaseValue());
        assertTrue(3 == test1Yard.showBaseValue());
        assertTrue("feet" == test1Yard.showBaseUnittype());
        assertFalse(1 == test2Yards.showBaseValue());
        assertTrue(6 == test2Yards.showBaseValue());

    }

    @Test
    public void ShouldBe1MileTo5280Feet(){
        Distance test1Mile = Distance.createMiles(1);
        assertTrue(1 == test1Mile.showValue());
        assertTrue("mile"== test1Mile.showUnitType());
        assertTrue("feet" == test1Mile.showBaseUnittype());
        assertTrue(5280 ==test1Mile.showBaseValue());
    }

    @Test
    public void ShouldBeEqualFeetandYards(){
        Distance test3Feet = Distance.createFeet(3);
        Distance test4Feet = Distance.createFeet(4);
        Distance test1Yards = Distance.createYards(1);
        Distance temp = Distance.createYards(2);
        assertEquals(Distance.createYards(1), Distance.createYards(1));
        assertEquals(Distance.createFeet(6), Distance.createYards(2));
    }
    @Test
    public void ShouldBeEqualFeetAndMileAndYard(){
        Distance test1Mile = Distance.createMiles(1);
        assertEquals(test1Mile, Distance.createMiles(1));
        assertEquals(test1Mile, Distance.createFeet(5280));
        assertEquals(test1Mile,Distance.createYards(1760));
        assertEquals(5280, test1Mile.showDistanceInFeet());
        assertTrue(Math.abs(1760 - test1Mile.showDistanceInYards()) < .000001);

    }

}
