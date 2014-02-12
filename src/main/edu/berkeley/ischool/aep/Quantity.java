package edu.berkeley.ischool.aep;

/**
 * Created by chrisfan on 2/8/14.
 */
public class Quantity {

    private final int value;
    private final String unit_type;
    private final int baseUnitValue;
    private final String baseUnitType;

    public Quantity(int value,String unit_name,int baseUnitValue, String baseUnitType ){
        this.value = value;
        this.unit_type = unit_name;
        this.baseUnitValue = baseUnitValue;
        this.baseUnitType = baseUnitType;
    }

    public int showValue(){
        int returnValue = this.value;
        return returnValue;
    }

    public String showUnitType(){
        String returnUnit = this.unit_type;
        return returnUnit;
    }

    public int showBaseValue(){
        int returnValue = this.baseUnitValue;
        return returnValue;
    }

    public String showBaseUnittype(){
        String returnValue = this.baseUnitType;
        return returnValue;

    }

    @Override
    public boolean equals(Object other) {
        if(this == other) return true;
        if(!(other instanceof Quantity)) return false;
        if(this.showBaseUnittype()==((Quantity)other).showBaseUnittype()
                && this.showBaseValue() == ((Quantity)other).showBaseValue())
            return true;
        else
            return false;
    }

    @Override
    public int hashCode(){
        final int prime = 19;
        int result =1;
        result = prime * result + baseUnitValue;
        result = prime * result + ((baseUnitType == null) ? 0 : baseUnitType.hashCode());
        return result;
    }


}
