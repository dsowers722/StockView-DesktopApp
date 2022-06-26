import javax.swing.*;
import java.awt.*;

public class TradeWindow extends JFrame implements Runnable {

    public Account activeAccount;
    DimensionAdjuster adjuster = new DimensionAdjuster();
    private final Font font = new Font(Font.SANS_SERIF, Font.PLAIN, adjuster.adjustedFontSize(24));

    public TradeWindow(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    public synchronized void run() {
        this.setSize(adjuster.adjustedWidth(1400), adjuster.adjustedHeight(900));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("StockView");
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(40, 45, 55));
        // Panels
        // Top panel

        // Add panels and make the frame visible
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
