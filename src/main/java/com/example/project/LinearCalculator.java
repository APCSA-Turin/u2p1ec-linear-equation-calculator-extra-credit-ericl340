package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;



    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String c1, String c2){ // <--add 2 string parameters to this constructor
        x1 = Integer.parseInt(c1.split(",")[0].substring(1));//splits the coords by the comma into an array and takes the 0th index, and removes the first char (
        y1 = Integer.parseInt(c1.substring(0, c1.length() - 1).split(",")[1]);//removes the last char ) and then splits array at the comma, then gets index 1
        x2 = Integer.parseInt(c2.split(",")[0].substring(1));//does the same thing as the prev for the second set of coords
        y2 = Integer.parseInt(c2.substring(0, c2.length() - 1).split(",")[1]);
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int i){x1 = i;}
    public void setY1(int i){y1 = i;}
    public void setX2(int i){x2 = i;}
    public void setY2(int i){y2 = i;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));//uses a^2 + b^2 = c^2
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        return x1 == x2 ? -999.99 : roundedToHundredth(y1 - slope() * x1);
        //if the x vars are equal, the slope would be undefined, meaning no yint
        //if the x vars unequal, returns the yint using b = y - mx rounded
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        return x1 == x2 ? -999.99 : roundedToHundredth((double)(y2 - y1) / (x2 - x1));
        //if the x vars are equal, the slope would be undefined
        //if the y vars are unequal, returns delta y / delta x rounded
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        return slope() == -999.99 ? "undefined" : "y=" + (slope() == 0 ? "" : slope() + "x") + (slope() == 0 || yInt() <= 0 ? "" : "+") + (yInt() == 0 ? "" : yInt());
        //returns undefined if the slope is undefined
        //returns y=mx+b otherwise
        //if x is 0, mx is removed
        //if b is 0, its removed
        //the + in between is removed when b is 0 or negative
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return Math.round(x * 100) / 100.0;
        //multiplies by 100, rounds, then devides by 100 to round to the nearest hundredth
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n"+findSymmetry();
        str += "\n"+Midpoint();
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        return yInt() == 0 ? "Symmetric about the origin" : x1 == x2 ? "Symmetric about the x-axis" : y1 == y2 ? "Symmetric about the y-axis" : "No symmetry";
        //if the y int is 0, its symmetric about the origin,
        //if its a verticle or horizontal line it returns symmetric about the x or y axis respectively
        //otherwise returns no symmetry
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        return "The midpoint of this line is: (" + (x1 + x2) / 2.0 + "," + (y1 + y2) / 2.0 + ")";
        //midpt formula ((x1+x2)/2,(y1+y2)/2)
    }

}



