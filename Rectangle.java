//Jillian Baggett and Leah Kuperman
//9/5/2018
//Rectangle for Lab 1 Part 3
//Section Tue 8am

public class Rectangle {
    //Creates fields for the rectangle class
    private double length;
    private double width;
    private static int count = -1;
    private int rectangleID;
    //Initializes rectangle objects
    public Rectangle(double l, double w)
    {   count += 1;
        length = l;
        width = w;
        rectangleID = count;
    }
    //Getters and setters for length and width fields
    public double getLength() {
        return length;
    }
    public double getHeight(){
        return width;
    }
    public void setLength(double length1)
    {
        length = length1;
    }
    public void setHeight(double width1)
    {
        width = width1;
    }
    public int getCount()
    {
        return count;
    }
    public int getRectangleID()
    {
        return rectangleID;
    }
    //Method returns the perimeter of the rectangle
    public double perimeter()
    {
        return (length * 2 +  width * 2);

    }
    //Returns the area of the rectangle
    public double getArea()
    {
        return (length * width);
    }
    public String toString()
    {return ("This rectangle is " + length + " feet long and " + width + " feet wide");}

}
