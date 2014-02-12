package edu.berkeley.ischool.aep;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by chrisfan on 2/7/14.
 */
public class SquareTest {

    @Test
    public void shouldReturnArea9forSquareSide3(){
        Rectangle sq = Rectangle.createSquare(3);
        Assert.assertFalse(10 == sq.area());
        Assert.assertEquals(9, sq);

    }
}
