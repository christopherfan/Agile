package edu.berkeley.ischool.aep;

/**
 * Understands a shape with 4 connected sides with internal angles 90 degrees.
 */
public class Rectangle {
    private final int firstside;   // 'final' keyword means it is not immutable after assignment
    private final int secondside;  //private keep your internal state for encapsulation

    /* Factory Methods clearly expresses intent and separates the ambiguity from Constructors */
    public static Rectangle createSquare(int side) {
      return new Rectangle(side, side);
    }


    public Rectangle(int side1, int side2){
        firstside= side1;
        secondside = side2;
    }

    public int area(){
        return firstside * secondside;
    }

    public static void main(String[] args){

        System.out.println("Test Code");
        Rectangle square = new Rectangle(2,2);
        System.out.println(square.area());
    }

}
