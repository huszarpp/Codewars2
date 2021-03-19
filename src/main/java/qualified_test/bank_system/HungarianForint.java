package qualified_test.bank_system;

/*
It's in the currency package
It extends Currency
exchangeRateToUSD is set by constructor.
The code is HUF by default.
The central bank name is Hungarian National Bank by default.
 */

public class HungarianForint extends Currency {

    public HungarianForint(float exchangeRateToUSD) {
        super("HUF", "Hungarian National Bank", exchangeRateToUSD);
    }
}
