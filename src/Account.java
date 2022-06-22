import java.io.Serializable;

public class Account implements Serializable {
    String username;
    String password;
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
