public class Square extends Rectangle {

    public Square(int sideLength)
    {
        super(sideLength, sideLength); //calls super constructor using side length twice
    }
    /* @override the to String method in java to return phrase including side length */
    public String toString()
    {
        return ("This is a square with side length: " + getHeight());
    }

    public double getSide()
    {
        return this.getHeight(); //returns side height
    }
/* @override the equals class in java to compare two shape objects
   public boolean equals(Object shape) */
   {
       if ((shape instanceof Square) && this instanceof Square) //checks that both are square objects

           {   Square shape1 = (Square)shape; //casts as square if needed
               if (shape1.getSide() == this.getSide()) //compares side length
                   return(true);
               else
               return (false);}


       else
           return(false);
   }

}

