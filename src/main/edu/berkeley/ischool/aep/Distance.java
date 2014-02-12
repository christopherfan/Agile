package edu.berkeley.ischool.aep;

/**
 * Created by chrisfan on 2/8/14.
 */
public class Distance extends Quantity{

    private Distance(int unit, String unitType, int baseUnit, String baseUnitType){
        super(unit,unitType, baseUnit, baseUnitType);
    }

    public static Distance createFeet(int value){
        Distance newDistance = new Distance(value,"feet", value, "feet");
        return newDistance;
    }

    public static Distance createYards(int value){
        return new Distance (value, "yard", 3*value, "feet") ;
    }

    public static Distance createMiles(int value){
        return new Distance (value, "mile", 3*1760*value, "feet");
    }

    public int showDistanceInFeet(){
        return showBaseValue();
    }

    public double showDistanceInYards(){
        return showBaseValue() /3.0;
    }

    public double showDistanceInMiles(){
        return showBaseValue() / 5280.0;

    }
}
