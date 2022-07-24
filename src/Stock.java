public class Stock {

    private double price;
    private String companyName;
    private final String ticker;

    public Stock(String ticker, String companyName) {
        this.ticker = ticker;
        this.companyName = companyName;
    }

    public double getPrice() {
        return price;
    }

    public String getTicker() {
        return ticker;
    }

    public String getCompanyName() {
        return companyName;
    }
}