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
        this.setTitle("StockView");
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(40, 42, 54));
        //////////
        JLabel label = new JLabel("Hi, " + activeAccount.getUsername());
        label.setFont(new Font(null, Font.PLAIN, 30));
        label.setVisible(true);
        label.setForeground(new Color(117, 215, 235));
        this.add(BorderLayout.NORTH, label);
        /////////
        this.setVisible(true);
    }
}
