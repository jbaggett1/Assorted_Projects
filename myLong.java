/*
    Names: Jillian Baggett and Leah Kuperman
    Project: Lab 1
    Date: 9/16/18
 */
import java.util.*;
public class myLong {
    int[] firstTen = new int[10];
    int[] secondTen = new int[10];
    int[] thirdTen = new int[10];
    int[] fourthTen = new int[10];
    int[] fifthTen = new int[10];
    int[] sixthTen = new int[10];
    int[] seventhTen = new int[10];
    int[] eigthTen = new int[10];
    int[] ninthTen = new int[10];
    int[] tenthTen = new int[10];
    int [][] wholeArray = {firstTen, secondTen, thirdTen, fourthTen, fifthTen, sixthTen, seventhTen, eigthTen, ninthTen, tenthTen};
    boolean isNeg;
    boolean swap;

    //constructor

    public myLong(String num)
    {
        swap = false;
        setLong(num);
    }
    //our print method
    public void print()
    {   if (this.isNeg == true)
    { System.out.print("-");

    }
        for (int v = 0; v < wholeArray[0].length; v ++)
        {
            for (int x = 0; x < 10; x++)
            {
                System.out.print(wholeArray[v][x]);
            }
        }
    }

    //sets long using the string newNum, which is called in the constructor.

    public void setLong(String newNum)
    {
        String value1 = newNum;

        int diff = 0;
        int stringLength = value1.length();
        int num = 0;
        String value = value1;
        if (value1.charAt(0) == ('-'))
        {
            System.out.println("Is negative");
            isNeg = true;
            value = value1.substring(1, stringLength);
        }
        else
        {
            isNeg = false;
        }

        stringLength = value.length();

        diff = 99 - stringLength;
        int diff2 = 9 - (stringLength% 10);
        for (int i = stringLength; i > 0; i--)
        {
            wholeArray[(i + diff )/ 10][(i + diff2) %10] = Character.getNumericValue(value.charAt(i-1));
            //(this was used for testing purpose) System.out.println( i + "  " + (i + diff)/10 +  " " + i%10 + " " +
            //value.charAt(i-1);

        }


    }

    public void getLong()
    {
        //also used for testing purpose
        for (int v = 0; v < wholeArray[0].length; v++) {
            for (int x = 0; x < 10; x++) {
                System.out.print(wholeArray[v][x]);
            }
        }
        System.out.println();
    }

    /**
     * Add takes one myLong parameter and adds every component of that to the object
     * being referenced. A string is returned
     *
     * @param is the long that you want added to the long you are referencing
     * @return a string that can be turned into a long object, or not
     */
    public String add(myLong other)
    {
        String newLong = "";
        int carry = 0;  //digit that will store what is carried over to the next column in addition
        for (int j = 9; j >= 0; j--) //iterates through whole array for different "10s" of numbers
        {
            for (int i = 9; i >= 0; i--) //iterates through the arrays of 10s for specific numbers
            {
                int result = this.wholeArray[j][i] + other.wholeArray[j][i] + carry;
                //adds both items in the column, along with a carry if it exists
                if (result >= 10)
                {
                    carry = result / 10; //carry is stored for the next column
                    result = result % 10; //result is what gets written below the line
                }
                else {
                    carry = 0; //if the result is a single digit, there is no carry
                }
                newLong = "" + result + newLong; //adds the numbers in order into a string
            }
        }
        return newLong; //returns the string of numbers

    }


    /**
     * Add takes one myLong parameter and multiplies every component of that to the object
     * being referenced. An object containing the result of the multiplication is returned
     *
     * @param is the myLong that you want multiplied by the myLong being referenced
     * @return a myLong object representing the result of the multiplication
     */
    public myLong multiply(myLong other)
    {
        String newNum = "";
        String progress = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        //this string holds the additions of each row of multiplication, since they can only be added
        //two at a time. Starts as all zeroes
        int carry = 0; //digit that will store what is carried over to the next column when multiplying
        for (int j = 9; j >= 0; j--) //represents the array of 10s we are working in
        {
            for (int i = 9; i >= 0; i--) //represents the digit in the 10s we are working in
            {
                String offset = ""; //offset keeps track of how many zeroes go before a row of multiplication
                for (int w = 9-i; w>0; w--)
                {
                    offset+="0";
                }
                newNum = offset; //before each row, newNum starts off as how much it is shifted over
                for (int k=9; k>=0; k--) //represents the digit of the number we are multiplying
                {
                    int result = this.wholeArray[j][i] * other.wholeArray[j][k] + carry;
                    //multiplies the two items, and then adds a carry if it exists
                    if (result >= 10)
                    {
                        carry = result / 10; //carry is stored for the next column
                        result = result % 10; //result is what gets written below the line
                    }
                    else {
                        carry = 0; //if the result is a single digit, there is no carry
                    }
                    newNum = "" + result + newNum; //the multiplied number is added to the string
                }
                myLong num = new myLong(newNum);
                //after each number of the second object gets multiplied by a single number in the
                //first, a new object is created with the string of numbers
                myLong prog = new myLong(progress);
                progress = prog.add(num); //progress becomes the addition of the two numbers
            }
        }
        myLong prog = new myLong(progress);
        //returns a long object of the result once all the for loops are finished
        return prog;
    }
    //returns length of number

    public int getLength()
    {
        int length = 0;
        int num = 0;
        int counter = 0;
        for (int i = 0; i < 10; i++)
        {
            for (int k = 0; k < 10; k++)
            {
                if (wholeArray[i][k] != 0)
                {
                    length = 100 - (i * 10 + k);
                    break;
                }
                if (length != 0)
                { break;}
            }
            if (length != 0)

            {break;}

        }
        return length;

    }
    //isEqual aids subtract method in determining if the numbers are equal.

    public boolean isEqual(myLong b)
    {
        for (int j=9; j>=0; j--)
        {
            for (int i=9; i>0; i--)
            {
                if (this.wholeArray[j][i] != b.wholeArray[j][i])
                    return false;
            }
        }
        return true;
    }
    // isBigger is used to aid subtract in determining the number with the largest absolute value.

    public boolean isBigger(myLong d) //if true, it means that this is bigger than d

    {   boolean truth = false;
        if (this.getLength() < d.getLength())
            truth = false;
        else if(this.getLength() > d.getLength())
            truth = true;
        else
        {
            for (int i =  99; i >=(99-this.getLength()); i-- )
            {   if (this.wholeArray[i/10][i%10] > d.wholeArray[i/10][i%10])
                truth = true;
            else if (this.wholeArray[i/10][i%10] < d.wholeArray[i/10][i%10])
            {
                truth = false;
            }
            }
        }
        return truth;
    }

    /**
     * subtract takes one myLong parameter and subtracts every component of that to the object
     * being referenced. A string is returned
     *
     * @param is the long that you want subtracted to the long you are referencing
     * @return a string that can be turned into a long object if needed
     */

    public String subtract(myLong b)
    {
        String new_num = "";
        int tempDig1 = -1;
        int tempDig2 = -1;
        int digit = 0;
        int lengthOfLarger = 0;

        //this is used for the case where the subtraction is something like (60 - 4000), because the subtraction will have to be done as if it is (4000 - 60), and
        //then the negative will be added at the end

        if (this.isEqual(b))
        {
            return "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        }
        if (this.isBigger(b)== false)
        {
            if (this.isNeg==false && b.isNeg==false || this.isNeg==true && b.isNeg==false) //checks cases in which numeric subtract should be used
            {

                this.swap = true; //updates if order was switched
                b.swap = true;
                return("-" + b.subtract(this));

            }
            else
            {
                this.swap = true;
                b.swap = true;
                return(b.subtract(this));

            }
        }
        //now, "this" is bigger

        if (this.isNeg == true && b.isNeg == true || this.isNeg == false && b.isNeg == false)
        {
            for (int i = 99; i > (99 - this.getLength()); i--) //sorts through loop and updates temp digit to digits being subtracted

            {   tempDig1 = this.wholeArray[i/10][i%10];

                tempDig2 = b.wholeArray[i/10][i%10];

                digit = tempDig1 - tempDig2;

                if (digit > -1) //case if first digit larger than second
                {
                    new_num = digit + new_num;
                }
                else //case if answer is negative & borrowing is necessary

                {

                    if (i%10 == 0) //checks for end of one array, changes variables accordingly
                    {

                        int temp = i;
                        int index = 9;
                        while (this.wholeArray[(temp/10) - 1][index]==0)
                        {
                            if (index==0)
                            {
                                index = 9;
                                temp--;
                            }
                            else
                            {
                                index--;
                                temp--;
                            }
                        }
                        if (index==0)
                        {
                            this.wholeArray[(temp/10)-1][9] -= 1;
                        }
                        else
                        {
                            this.wholeArray[(temp/10)][index-1] -= 1;
                        }
                        while (temp<=i)
                        {
                            if (index==9)
                            {
                                this.wholeArray[(temp/10)][index] = 9;
                                temp++;
                                index=0;
                            }
                            else
                            {
                                this.wholeArray[(temp/10)][index] = 9;
                                index++;
                                temp++;
                            }
                        }

                        tempDig1 += 10;
                        digit = tempDig1 - tempDig2;
                        new_num = digit + new_num;

                    }
                    else //handles other case using similar methods
                    {
                        int temp = i;
                        int index = i%10;
                        while (this.wholeArray[(temp/10)][index-1]==0)
                        {
                            if (index==0)
                            {
                                index = 9;
                                temp--;
                            }
                            else
                            {
                                index--;
                                temp--;
                            }
                        }
                        if (index==0)
                        {
                            this.wholeArray[(temp/10)-1][9] -= 1;
                        }
                        else
                        {
                            this.wholeArray[(temp/10)][index-1] -= 1;
                        }
                        while (temp<=i)
                        {
                            if (index==9)
                            {
                                this.wholeArray[(temp/10)][index] = 9;
                                temp++;
                                index=0;

                            }
                            else
                            {
                                this.wholeArray[(temp/10)][index] = 9;
                                index++;
                                temp++;
                            }
                        }

                        tempDig1 += 10;
                        digit = tempDig1 - tempDig2;
                        new_num = digit + new_num;
                    }
                }
            }
            if (this.isNeg == true && b.isNeg == true && swap == false) //checks for addition cases, when numbers signs can be switched and return same result
            {
                return("-" + new_num);
            }
            else
            {
                return(new_num);
            }

        }
        else if (this.isNeg == true && b.isNeg == false && swap==false)
        {
            return("-" + this.add(b));
        }
        else //(this.isNeg == false && b.isNeg == true)
        {
            return(this.add(b));
        }
    }
}