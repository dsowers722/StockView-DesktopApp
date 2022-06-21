import java.io.*;
import java.util.ArrayList;

public class AccountsManager {

    private String receivedUsername;
    private String receivedPassword;
    private ArrayList<Account> accountList = new ArrayList<>();
    private static final String directory = System.getProperty("user.dir") + "/Accounts.ser";

    public AccountsManager() {
        if (((new File(directory)).exists()) && ((new File(directory)).length() != 0)) {
            // If the file exists and is not empty, read the data into the arrayList of accounts
            try (ObjectInputStream objectInStream = new ObjectInputStream(new FileInputStream(directory))) {
                accountList= (ArrayList<Account>)objectInStream.readObject();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            //TODO Check if username and password is correct

        } else {
            Account newAccount = new Account(receivedUsername, receivedPassword);
            accountList.add(newAccount);
            // Create and write to the file the new list of accounts
            try (ObjectOutputStream objectOutStream = new ObjectOutputStream(new FileOutputStream(directory,
                                                                                                false))){
                objectOutStream.writeObject(accountList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
