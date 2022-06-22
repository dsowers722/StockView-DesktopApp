import javax.swing.*;
import java.awt.*;

public class TradeWindow extends JFrame implements Runnable {

    public Account activeAccount;

    public TradeWindow(Account activeAccount) {
        this.activeAccount = activeAccount;
    }
    public synchronized void run() {
        this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 +
                        (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 4,
                     (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 +
                             (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 4);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
