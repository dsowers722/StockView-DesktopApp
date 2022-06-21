import java.util.ArrayList;

public class AccountsManager {

    private String receivedUsername;
    private String receivedPassword;
    private ArrayList<Account> accountList = new ArrayList<>();

    public AccountsManager() {

    }

    public void setReceivedUsername(String receivedUsername) {
        this.receivedUsername = receivedUsername;
    }

    public void setReceivedPassword(String receivedPassword) {
        this.receivedPassword = receivedPassword;
    }

    public String getReceivedUsername() {
        return receivedUsername;
    }

    public String getReceivedPassword() {
        return receivedPassword;
    }

    public boolean accountExists(String receivedUsername, String receivedPassword) {
        return false;
    }

    public void createAccount(String receivedUsername, String receivedPassword) {}
}
