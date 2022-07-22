import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {

    private String username;
    private String password;
    private double usedBalance;
    private double totalBalance;
    private double availableBalance;
    private ArrayList<Stock> stocks = new ArrayList<>();

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setTotalBalance(double balance) {
        this.totalBalance = balance;
    }

    public double getTotalBalance() {
        return this.totalBalance;
    }

    /*public Stock getStock(String ticker) {

    } */
}
