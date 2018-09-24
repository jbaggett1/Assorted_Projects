/**
 * Author: Leah Kuperman and Jillian Baggett
 * Course: CMPS 1600
 * Lab Section: Tuesday at 5pm (2)
 * Assignment: Lab 3
 * Date Created: 9/18/18
 * This class creates a checking account, adding onto the bank account class.
 * This class stores an account name and balance.
 * The account can be modified through withdrawals, deposits, and transfers.
 * The class also includes a toString, deductFees, getName, and getBalance method.
 * This class also keeps track of the number of transactions made, and stores the fees associated.
 */

public class CheckingAccount extends BankAccount
{
    int transactionCount = 0;
    public static final double TRANSACTION_FEE = 3.00;
    public CheckingAccount(String name, double balance)
    {
        super(name, balance);       //calls constructor with given parameters

    }

    //@Override
    public void deposit(double amount)
    {
        super.deposit(amount);      //calls super's deposit method and adds to transaction count
        transactionCount++;
    }

    //@Override
    public void withdraw(double amount)
    {
        super.withdraw(amount);     //calls super's withdraw method and adds to transaction count
        transactionCount++;
    }

    public void deductFees()
    {
        //subtracts the total fee of transactions from balance and resets the count of transactions
        this.balance = this.balance - TRANSACTION_FEE * transactionCount;
        transactionCount = 0;
    }
}
