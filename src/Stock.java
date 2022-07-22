public class Stock {

    SearchInteface searchInteface;
    private final String ticker;
    private double price;
    private int numberOfShares;

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
}