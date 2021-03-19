package qualified_test.bank_system;

/*
It's in the root package (java folder)

It has a BankAccount list.

It has a createAccount method with a BankAccount as an input parameter

it adds the BankAccount to the list
It has a getAllMoney method, which returns the sum of all money in the bank converted to USD.
 */

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> bankAccounts = new ArrayList<>();

    public void createAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public float getAllMoney() {
        float moneySum = 0;
        for (BankAccount account : bankAccounts) {
            moneySum += account.getAmountInUsd();
        }
        return moneySum;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
