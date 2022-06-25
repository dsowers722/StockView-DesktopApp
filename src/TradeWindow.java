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
        this.setVisible(true);
    }

    public JPanel addPanel(LayoutManager layout, Color background) {
        JPanel panel = new JPanel();
        panel.setBackground(background);
        panel.setLayout(layout);
        return panel;
    }

    public JLabel addLabel() {
        JLabel label = new JLabel();
        return label;
    }
}
