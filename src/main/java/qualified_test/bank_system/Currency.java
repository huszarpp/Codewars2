package qualified_test.bank_system;

/*
It's in the currency package
It has a String code, a String centralBankName and float exchangeRateToUSD field.
All fields has a getter.
All fields can be set by a constructor.
Exchange rate can be set by a setter setExchangeRateToUSD(float exchangeRateToUSD).
If setting exchangeRateToUSD to a number which is not positive, IllegalArgumentException thrown.
*/
public class Currency {
    private String code;
    private String centralBankName;
    private float exchangeRateToUSD;

    public Currency(String code, String centralBankName, float exchangeRateToUSD) {
        this.code = code;
        this.centralBankName = centralBankName;
        setExchangeRateToUSD(exchangeRateToUSD);
    }

    public String getCode() {
        return code;
    }

    public String getCentralBankName() {
        return centralBankName;
    }

    public float getExchangeRateToUSD() {
        return exchangeRateToUSD;
    }

    public void setExchangeRateToUSD(float exchangeRateToUSD) {
        if (exchangeRateToUSD <= 0) {
            throw new IllegalArgumentException();
        }
        this.exchangeRateToUSD = exchangeRateToUSD;
    }
}
