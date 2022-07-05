import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TradeWindow extends JFrame implements Runnable, ActionListener {

    Account activeAccount;
    DimensionAdjuster adjuster = new DimensionAdjuster();
    Font font = new Font(Font.MONOSPACED, Font.PLAIN, adjuster.adjustedFontSize(12));
    JPanel westPanel = addPanel(new Color(40, 45, 55),
                                new Dimension(adjuster.adjustedWidth(300), adjuster.adjustedHeight(800)));
    JPanel eastPanel = addPanel(new Color(40, 45, 45/*55*/),
                                new Dimension(adjuster.adjustedWidth(300), adjuster.adjustedHeight(800)));
    JPanel northPanel = addPanel(new Color(40, 45, 55),
                                 new Dimension(adjuster.adjustedWidth(1400), adjuster.adjustedHeight(80)));
    JPanel southPanel = addPanel(new Color(40, 45, 55),
                                 new Dimension(adjuster.adjustedWidth(1400), adjuster.adjustedHeight(80)));

    public TradeWindow(Account activeAccount) {
        this.activeAccount = activeAccount;
        this.activeAccount.setTotalBalance(200);
    }

    public synchronized void run() {
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

    public void actionPerformed(ActionEvent e) {

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

    public JButton addButton(String title, Color background, Color foreground, Rectangle bounds) {
        JButton button = new JButton(title);
        button.addActionListener(this);
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFocusable(false);
        button.setBounds(bounds);
        button.setFont(font);
        return button;
    }

    public JTextField addTextField(String title, Color background, Color foreground, Rectangle bounds) {
        JTextField textField = new JTextField(title);
        textField.setBackground(background);
        textField.setForeground(foreground);
        textField.addActionListener(this);
        textField.setFocusable(true);
        textField.setBounds(bounds);
        textField.setFont(font);
        textField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (textField.getText().equals(title))
                    textField.setText("");
            }
        }); // Change the title text to empty as soon as clicked
        return textField;
    } // This method is a basic template for creating text fields
}
