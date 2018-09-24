/**
 * Author: Leah Kuperman and Jillian Baggett
 * Course: CMPS 1600
 * Lab Section: Tuesday at 5pm (2)
 * Assignment: Lab 3
 * Date Created: 9/18/18
 * This class creates a savings account, adding onto the bank account class.
 * This class stores an account name, interest rate, and balance.
 * The account can be modified through withdrawals, deposits, and transfers.
 * The class also includes a toString, addInterest, getName, and getBalance method.
 */

public class SavingsAccount extends BankAccount {
    double interest;    //stores interest rate as a percent
    public SavingsAccount(String name, double balance, double interest)
    {
        super(name, balance);       //calls constructor with given parameters
        this.interest = interest;
    }
    public void addInterest()
    {
        this.deposit((balance * (interest/100)));
        //adds the interest of the account depending on the balance
    }

}
