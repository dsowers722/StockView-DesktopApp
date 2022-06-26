public class Stock {

    double price;
    int numberOfShares;

    public Stock() {

    }

    public double getTotalCost() {
        return price * numberOfShares;
    }
}
