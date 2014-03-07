package edu.berkeley.ischool.aep;

/**
 * Created by chrisfan on 2/21/14.
 */
public class ScalarQuantity {
    private Unit unit;
    private double size;

    public ScalarQuantity(Unit unit, double size){
        this.unit = unit;
        this.size = size;
    }

    // To preserve encapsulation you have to ask the "other object" to change itself to something I want rather than "ask it to tell me" what I want
    @Override
    public boolean equals(Object other) {
        if(this == other) return true;
        if(!(other instanceof ScalarQuantity)) return false;
        ScalarQuantity otherQuantity = (ScalarQuantity) other;
        double returnBaseQuantity = otherQuantity.convertTo(this);
        return Math.abs(size -returnBaseQuantity) < 0.0001;
    }

    @Override
    public int hashCode(){
        final int prime = 19;
        int result =1;
        long longBits=Double.doubleToLongBits(size);
        int size_hash = (int) (longBits ^ (longBits >>> 32));
        result = prime * result + size_hash;
        result = prime * result + ((unit == null) ? 0 : unit.hashCode());
        return result;
    }

    @Override
    public String toString(){
        return size + " " + unit;

    }

    protected double convertTo(ScalarQuantity otherUnit){
        if(this.checkSameUnitType(otherUnit)){
            return unit.converTo(size, otherUnit.unit());
        }else{
            throw new RuntimeException("Mismatched Unit Type: " + this + " and "+ otherUnit);
        }
    }

    protected Unit unit(){
        return this.unit;
    }

    protected double size(){
        return this.size;
    }
    public boolean  checkSameUnitType(ScalarQuantity otherQuantity){
        return this.unit.sameUnitType(otherQuantity.unit());
    }

    public int better(ScalarQuantity otherQuantity){
        if (this.equals(otherQuantity))
            return 0;
        if (this.size < otherQuantity.convertTo(this)){
            return -1;
        }
        return 1;
    }

    public static ScalarQuantity best(ScalarQuantity... args){
        ScalarQuantity baseType = args[0];
        for (ScalarQuantity q : args){
            //System.out.println(q);
            if(!q.checkSameUnitType(baseType)){
                throw new RuntimeException("Mismatched Unit Type: " + q + " and "+ baseType);
            }
        }
        ScalarQuantity bestQuantity = args[0];
        for (ScalarQuantity q: args){
            if (1 == q.better(bestQuantity))
                bestQuantity = q;
        }
        return bestQuantity;
    }
}
