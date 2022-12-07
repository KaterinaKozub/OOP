package ua.opnu;

import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {
    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        this.minBalance = s.getBalance();
        this.maxBalance = s.getBalance();
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        if(this.maxBalance < super.getBalance()) this.maxBalance = super.getBalance();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        if(this.minBalance > super.getBalance()) this.minBalance = super.getBalance();
    }

    public int getMin() {
        return this.minBalance;
    }
    public int getMax() {
        return this.maxBalance;
    }
}

