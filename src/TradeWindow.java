import javax.swing.*;
import java.awt.*;

public class TradeWindow extends JFrame implements Runnable {

    public double fontSize = 12 / (1920 / Toolkit.getDefaultToolkit().getScreenSize().getWidth());
    public Font font = new Font(Font.SANS_SERIF, Font.PLAIN, (int)fontSize);
    public Account activeAccount;
    public JPanel topPanel;

    public TradeWindow(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    public synchronized void run() {
        System.out.println(fontSize);
        this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2
                        + (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 4,
                     (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2
                        + (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 4);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("StockView");
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(40, 42, 54));
        // Panels
        // Top panel
        topPanel = addPanel(null, new Dimension(0, this.getHeight() / 6));
        topPanel.add(addLabel("Welcome, " + activeAccount.getUsername(), new Color(80, 250, 125)));
        // Add panels and make the frame visible
        this.add(topPanel);
        this.setVisible(true);
    }

    public JPanel addPanel(Color background, Dimension dimension) {
        JPanel panel = new JPanel();
        panel.setBackground(background);
        panel.setPreferredSize(dimension);
        return panel;
    }

    public JLabel addLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }
}
