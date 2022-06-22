import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AccountsManager {

    private ArrayList<Account> accountList = new ArrayList<>();
    private static final String directory = System.getProperty("user.dir") + "/Accounts.ser";

    public AccountsManager() {
        if (((new File(directory)).exists()) && ((new File(directory)).length() != 0)) {
            // If the file exists and is not empty, read the data into the arrayList of accounts
            try (ObjectInputStream objectInStream = new ObjectInputStream(new FileInputStream(directory))) {
                accountList = (ArrayList<Account>)objectInStream.readObject();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "An error has occurred\n" + Arrays.toString(exception.getStackTrace()), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void newAccount(String newUsername, String newPassword) {
        Account account = new Account(newUsername, newPassword);
        accountList.add(account);
        SaveData(accountList);
    }

    public boolean accountExists(String receivedUsername, String receivedPassword) {
        for (Account account : accountList) {
            if ((account.getUsername().equals(receivedUsername)) && (account.getPassword().equals(receivedPassword)))
                return true;
        }
        return false;
    }

    public Account getAccount(String username, String password) {
        for (Account account : accountList) {
            if ((account.getUsername().equals(username)) && (account.getPassword().equals(password)))
                return account;
        }
        return null;
    }

    public static void SaveData(ArrayList<Account> accountList) {
        try (ObjectOutputStream objectOutStream = new ObjectOutputStream(new FileOutputStream(directory))){
            objectOutStream.writeObject(accountList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
