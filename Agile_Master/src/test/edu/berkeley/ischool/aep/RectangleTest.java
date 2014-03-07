package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by chrisfan on 1/24/14.
 */
public class RectangleTest {

    @Test
    public void shouldReturnAreaofTenforTwobyFiveRectangle(){
        Rectangle rect = new Rectangle(5,2);
        assertEquals(10, rect.area());
    }

    @Test
    public void shouldReturnAreaofSixforThreebyTwoRectangle(){

    }
    @Test
    public void shouldReturnAreaOf9Rectangle(){


    }

}
