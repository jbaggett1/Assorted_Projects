/**
 * Author: Leah Kuperman and Jillian Baggett
 * Course: CMPS 1600
 * Lab Section: Tuesday at 5pm (2)
 * Assignment: Lab 3
 * Date Created: 9/18/18
 * This class creates a bank account storing an account name and balance.
 * The account can be modified through withdrawals, deposits, and transfers.
 * The class also includes a toString, getName, and getBalance method.
 */

public class BankAccount {
    String name;        //stores name of account
    double balance;     //stores balance of account

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {       //returns name outside of class
        return name;
    }

    public double getBalance() {        //returns balance outside of class
        return balance;
    }

    public void withdraw(double amount) {       //subtracts given amount from balance
        balance -= amount;
    }

    public void deposit(double amount) {        //adds given amount from balance
        balance += amount;
    }

    public void transfer(BankAccount b, double amount) {
        this.withdraw(amount);      //takes amount from current object and deposits in the next
        b.deposit(amount);
    }

    public String toString()
    {
        return this.getName() + "'s bank account has a balance of " + this.getBalance();
        //prints balance and name of account

    }
}

