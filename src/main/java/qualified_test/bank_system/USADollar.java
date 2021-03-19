package qualified_test.bank_system;

/*
It's in the currency package
It extends Currency
exchangeRateToUSD is set to 1.0 by default, can't be set by constructor.
The code is USD by default.
The central bank name is Federal Reserve System by default.
 */

public class USADollar extends Currency {

    public USADollar() {
        super("USD", "Federal Reserve System", 1.0f);
    }
}
