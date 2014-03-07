package edu.berkeley.ischool.aep;

/**
  Understands how to convert between different types of quantity

    State: Either or
    Ordinal: Comparable but not scaled
    Scaled: Tempterature, Year of Birth
    Arithmetic: Ratio and Add/Subtract
 */
public class Unit {
    //Match unit types

    private static enum UNIT_TYPE {VOLUME,DISTANCE,TEMPERATURE};



    // Preserve Encapsulation
    public static Unit FEET = new Unit(1, "FEET", UNIT_TYPE.DISTANCE);
    public static Unit YARDS = new Unit(3, "YARDS", UNIT_TYPE.DISTANCE);
    public static Unit MILES = new Unit(3*1760, "MILES", UNIT_TYPE.DISTANCE);
    public static Unit TEASPOON = new Unit(1, "TEASPOON", UNIT_TYPE.VOLUME);
    public static Unit TABLESPOON = new Unit(3, "TABLESPOON",UNIT_TYPE.VOLUME);
    public static Unit OUNCE = new Unit(3*2, "OUNCE",UNIT_TYPE.VOLUME);
    public static Unit CUP = new Unit(3*2*8, "CUP",UNIT_TYPE.VOLUME);
    public static Unit FAHRENHEIT = new Unit(1, "FAHRENHEIT", UNIT_TYPE.TEMPERATURE);
    public static Unit CELSIUS = new Unit(1, "CELSIUS", UNIT_TYPE.TEMPERATURE);

    private final int conversionFactor;
    private final String name;
    private final UNIT_TYPE type;
    public Unit(int conversionFactor, String name,UNIT_TYPE type ){
        this.conversionFactor = conversionFactor;
        this.name = name;
        this.type = type;
    }


    public int conversionFactor(){
        return this.conversionFactor;
    }

    @Override
    public String toString(){
        return name;
    }

    public String convertDifferentTempteratures(String temperature){

        if (name.equals("FAHRENHEIT") && temperature.equals("CELSIUS")){
            return new String ("CELSIUS_TO_FAHRENHEIT");
        }else if (name.equals("CELSIUS") && temperature.equals("FAHRENHEIT")){
            return new String ("FAHRENHEIT_TO_CELSIUS");
        }
        return new String("SAME_TEMPERATURE");
    }

    public double converTo(double size, Unit otherUnit  ){
        //if (otherUnit.type == UNIT_TYPE.DISTANCE.TEMPERATURE && !this.name.equals(otherUnit.name)){
            if ((otherUnit.convertDifferentTempteratures(this.name)).equals("CELSIUS_TO_FAHRENHEIT")){
                return (size * 9 / 5) + 32;
            }else if ((otherUnit.convertDifferentTempteratures(this.name)).equals("FAHRENHEIT_TO_CELSIUS")){
                return (size - 32) * 5/9;
            }
        //}
        return size * this.conversionFactor / otherUnit.conversionFactor();
    }
    public boolean sameUnitType(Unit otherUnit){
//        if( type==UNIT_TYPE.TEMPERATURE || otherUnit.type==UNIT_TYPE.TEMPERATURE)
//            return false;
//        else
            return type == otherUnit.type;
    }


}
