package edu.berkeley.ischool.aep;

/**
 * Created by galahad on 1/31/14.
 */
import org.junit.Test;
import static junit.framework.Assert.*;
public class ChanceTest {

    @Test
    public void shouldReturnChanceOfNotGettingAHead(){
        Chance c = new Chance(0.5);
        Chance c1 = new Chance(0.5);
        Chance dieThrow = new Chance(1/6);
        // assertEquals(c1.getProbability(), c.not().getProbability());
        //assertEquals(new Chance(0.5), c);
        assertEquals(new Chance(1-1/6), dieThrow.not());
    }


    @Test
    public void shouldReturnProductOfTwoChances() {
        Chance a = new Chance(1.0/10.0);
        Chance b = new Chance(5.0/10.0);
        Chance c = new Chance(4.0/10.0);
        assertEquals(new Chance(5.0/100.0), a.and(b));
//        assertEquals(new Chance(5.0/100.0), a.and(c));
        assertFalse(new Chance(5.0/100.0).equals(a.and(c)));
        assertTrue(new Chance(5.0/100.0).equals(a.and(b)));
        assertTrue(new Chance(5.0/100.0).equals(Chance.and(a,b)));
    }
}
