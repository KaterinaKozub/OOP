package ua.opnu;

public class BankAccount {
    public String name;
    public double balance;
    double transactionFee;

    public BankAccount() {

        this.balance = balance;
        this.transactionFee = 0;

    }


    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("The amount balance is below zero");
        } else {
            balance += amount;
            System.out.println("The operation successful");
        }
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        if(amount > 0 && (amount + transactionFee) <= this.balance){
            this.balance -= amount + transactionFee;
            return true;
        }
        else
        {
            return false;
        }
    }


    boolean transfer(ua.opnu.BankAccount receiver, double amount) {
        if (amount > 0 && (amount + transactionFee) <= this.balance){
            this.balance -= amount + transactionFee;
            receiver.balance += amount;
            return true;
        }
        else
            return false;
    }

}

