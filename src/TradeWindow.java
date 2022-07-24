import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TradeWindow extends JFrame implements Runnable, ActionListener {

    Stock currentStock;
    Account activeAccount;
    SearchInterface searchInterface;
    DimensionAdjuster adjuster = new DimensionAdjuster();
    Font font = new Font(Font.MONOSPACED, Font.ITALIC, adjuster.adjustedFontSize(22));
    JTextField stockSearch = addTextField("search", new Color(125, 125, 125), Color.BLACK,
                                          new Rectangle(adjuster.adjustedXBound(270), adjuster.adjustedYBound(415),
                                                        adjuster.adjustedWidth(175), adjuster.adjustedHeight(20)));
    JButton searchButton = addButton("search", new Color(120, 215, 235), Color.BLACK,
                                     new Rectangle(adjuster.adjustedXBound(470), adjuster.adjustedYBound(415),
                                                   adjuster.adjustedWidth(75), adjuster.adjustedHeight(20)));
    JButton buyButton = addButton("buy", new Color(80, 250, 125), Color.BLACK,
                                  new Rectangle(adjuster.adjustedXBound(270), adjuster.adjustedYBound(450),
                                                adjuster.adjustedWidth(75), adjuster.adjustedHeight(20)));
    JButton sellButton = addButton("sell", new Color(225, 85, 165), Color.BLACK,
                                   new Rectangle(adjuster.adjustedXBound(470), adjuster.adjustedYBound(450),
                                                 adjuster.adjustedWidth(75), adjuster.adjustedHeight(20)));
    JButton detailsButton = addButton("details", new Color(125, 125, 125), Color.BLACK,
                                      new Rectangle(adjuster.adjustedXBound(370), adjuster.adjustedYBound(450),
                                                    adjuster.adjustedWidth(75), adjuster.adjustedHeight(20)));
    JPanel westPanel = addPanel(new Color(40, 45, 55),
                                new Dimension(adjuster.adjustedWidth(300), adjuster.adjustedHeight(800)));
    JPanel eastPanel = addPanel(new Color(40, 45, 55),
                                new Dimension(adjuster.adjustedWidth(300), adjuster.adjustedHeight(800)));
    JPanel northPanel = addPanel(new Color(40, 45, 55),
                                 new Dimension(adjuster.adjustedWidth(1400), adjuster.adjustedHeight(80)));
    JPanel southPanel = addPanel(new Color(40, 45, 55),
                                 new Dimension(adjuster.adjustedWidth(1400), adjuster.adjustedHeight(80)));
    JPanel centerPanel = addPanel(new Color(40, 45, 55),
                                  new Dimension(adjuster.adjustedWidth(1400), adjuster.adjustedHeight(800)));

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
        // North Panel
        northPanel.add(addLabel("Welcome, " + activeAccount.getUsername(),
                                new Color(120, 215, 235),
                                new Rectangle(adjuster.adjustedXBound(595), adjuster.adjustedYBound(15),
                                              adjuster.adjustedWidth(1400), adjuster.adjustedHeight(100)),
                                new Font(font.getFontName(), Font.ITALIC, adjuster.adjustedFontSize(22))));
        // Center Panel
        buyButton.setFont(font.deriveFont((float)adjuster.adjustedFontSize(12)));
        sellButton.setFont(font.deriveFont((float)adjuster.adjustedFontSize(12)));
        detailsButton.setFont(font.deriveFont((float)adjuster.adjustedFontSize(12)));
        searchButton.setFont(font.deriveFont((float)adjuster.adjustedFontSize(12)));
        stockSearch.setFont(font.deriveFont((float)adjuster.adjustedFontSize(12)));
        centerPanel.add(buyButton);
        centerPanel.add(sellButton);
        centerPanel.add(detailsButton);
        centerPanel.add(searchButton);
        centerPanel.add(stockSearch);
        centerPanel.add(addLabel("Price", new Color(120, 215, 235),
                                new Rectangle(adjuster.adjustedXBound(370), adjuster.adjustedYBound(360),
                                              adjuster.adjustedWidth(1400), adjuster.adjustedHeight(50)),
                                new Font(font.getFontName(), Font.ITALIC, adjuster.adjustedFontSize(22))));
        centerPanel.add(addLabel("Stock Name", new Color(120, 215, 235),
                                 new Rectangle(adjuster.adjustedXBound(335), adjuster.adjustedYBound(320),
                                               adjuster.adjustedWidth(1400), adjuster.adjustedHeight(50)),
                                 new Font(font.getFontName(), Font.ITALIC, adjuster.adjustedFontSize(22))));
        // Add the panels
        this.add(BorderLayout.EAST, eastPanel);
        this.add(BorderLayout.WEST, westPanel);
        this.add(BorderLayout.NORTH, northPanel);
        this.add(BorderLayout.SOUTH, southPanel);
        this.add(BorderLayout.CENTER, centerPanel);
        // Make the window visible
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buyButton) {
            System.out.println("buy");
        }
        if (e.getSource() == sellButton) {
            System.out.println("sell");
        }
        if (e.getSource() == detailsButton) {
            System.out.println("details");
        }
        if (e.getSource() == searchButton) {
            System.out.println("search");
            searchInterface = new SearchInterface(stockSearch.getText());
        }
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