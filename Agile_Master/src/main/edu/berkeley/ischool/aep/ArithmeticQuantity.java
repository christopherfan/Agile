package edu.berkeley.ischool.aep;

/**
    Understands Unit Equivalence and Addition
 */
public class ArithmeticQuantity extends ScalarQuantity {

    ArithmeticQuantity(Unit unit, double size){
        super(unit, size);

    }

    public static ArithmeticQuantity add(ArithmeticQuantity q1, ArithmeticQuantity q2){
        //throw new RuntimeException(("BLAAH"));
        if(q1.checkSameUnitType(q2)){
            return new ArithmeticQuantity(q1.unit(), q1.size() + q2.convertTo(q1));
        }else{
            throw new RuntimeException("Mismatched Unit Type: " + q1 + " and "+ q2);
        }
    }

//    public static ScalarQuantity best(ArithmeticQuantity... args){
//        return ScalarQuantity.best(args);
//    }
}
