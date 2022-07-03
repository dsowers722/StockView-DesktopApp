import javax.swing.*;
import java.awt.*;

public class TradeWindow extends JFrame implements Runnable {

    Account activeAccount;
    DimensionAdjuster adjuster = new DimensionAdjuster();
    Font font = new Font(Font.MONOSPACED, Font.PLAIN, adjuster.adjustedFontSize(12));
    JPanel westPanel = addPanel(new Color(40, 45, 55),
                                new Dimension(adjuster.adjustedWidth(300), adjuster.adjustedHeight(800)));
    JPanel eastPanel = addPanel(new Color(40, 45, 55),
                                new Dimension(adjuster.adjustedWidth(300), adjuster.adjustedHeight(800)));
    JPanel northPanel = addPanel(new Color(40, 45, 55),
                                 new Dimension(adjuster.adjustedWidth(1400), adjuster.adjustedHeight(80)));
    JPanel southPanel = addPanel(new Color(40, 45, 55),
                                 new Dimension(adjuster.adjustedWidth(1400), adjuster.adjustedHeight(80)));

    public TradeWindow(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    public synchronized void run() {
        System.out.println(activeAccount.getUsername());
        this.setSize(adjuster.adjustedWidth(1400), adjuster.adjustedHeight(900));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("StockView");
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(40, 45, 55));
        // Panels
        //northPanel.add(welcomeLabel);
        northPanel.add(addLabel("Welcome, " + activeAccount.getUsername(),
                                new Color(140, 235, 255),
                                new Rectangle(adjuster.adjustedXBound(600), adjuster.adjustedYBound(15),
                                              adjuster.adjustedWidth(1400), adjuster.adjustedHeight(100)),
                                new Font(font.getFontName(), Font.ITALIC, adjuster.adjustedFontSize(22))));
        this.add(BorderLayout.EAST, eastPanel);
        this.add(BorderLayout.WEST, westPanel);
        this.add(BorderLayout.NORTH, northPanel);
        this.add(BorderLayout.SOUTH, southPanel);
        // Add panels and make the frame visible
        this.setVisible(true);
    }

    public JPanel addPanel(Color background, Dimension dimension) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(dimension);
        panel.setBackground(background);
        return panel;
    }

    public JLabel addLabel(String text, Color color, Rectangle bounds, Font font) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setBounds(bounds);
        label.setFont(font);
        return label;
    }
}
