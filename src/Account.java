import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {

    String username;
    String password;
    double usedBalance;
    double totalBalance;
    double availableBalance;
    ArrayList<Stock> stocks = new ArrayList<>();


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
}
