public class Stock {

    private double price;
    private int numberOfShares;
    private String companyName;
    private final String ticker;
    SearchInteface searchInteface;

    public Stock(String ticker) {
        this.ticker = ticker;
        searchInteface =  new SearchInteface(ticker);
    }

    public double getTotalCost() {
        return price * numberOfShares;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public String getTicker() {
        return ticker;
    }

    public String getCompanyName() {
        return "company";
    }
}