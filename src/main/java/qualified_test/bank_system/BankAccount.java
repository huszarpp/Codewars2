package qualified_test.bank_system;

/*
It's in the root package (java folder)
It has a String name, a String pinCode, float amount and a currency.

All fields can be set by constructor, and has a getter.

It has a deposit method that takes a float amountToDeposit parameter

checks if the given parameter is positive, if not IllegalArgumentException thrown.
then adds the parameter to the amount
It has a withdraw method with two parameters: a pinCode and an amountToWithdraw

It checks if the given pin is correct (equals with the original pin)

and the available amount is more than the value of amountToWithdraw parameter

If so, subtracts the withdrawn amount from the available amount
and returns with the amount.

Otherwise don't modify the available amount and return with 0.

There is a method called float getAmountInUsd() which returns the available amount converted to USD. The formula for conversion: amount_in_USD = currency * exchangeRateToUSD.
 */

public class BankAccount {

    private String name;
    private String pinCode;
    private float amount;
    private Currency currency;

    public BankAccount(String name, String pinCode, float amount, Currency currency) {
        this.name = name;
        this.pinCode = pinCode;
        this.amount = amount;
        this.currency = currency;
    }

    public void deposit(float amountToDeposit) {
        if (amountToDeposit <= 0) {
            throw new IllegalArgumentException();
        }
        amount += amountToDeposit;
    }

    public float withdraw(String pinCode, float amountToWithdraw) {
        if (pinCode.equals(this.pinCode) && amount >= amountToWithdraw) {
            amount -= amountToWithdraw;
            return amount;
        }
        return 0;
    }

    public float getAmountInUsd() {
        return amount * currency.getExchangeRateToUSD();
    }

    public String getName() {
        return name;
    }

    public String getPinCode() {
        return pinCode;
    }

    public float getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
