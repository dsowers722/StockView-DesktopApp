import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginWindow extends JFrame implements Runnable, ActionListener {

    DimensionAdjuster adjuster = new DimensionAdjuster();
    AccountsManager accountsManager = new AccountsManager();
    Font font = new Font(Font.MONOSPACED, Font.PLAIN, adjuster.adjustedFontSize(10));
    JLabel welcomeLabel = addLabel("Welcome to StockView!", new Color(80, 250, 125),
                                   new Font(Font.MONOSPACED, Font.PLAIN, adjuster.adjustedFontSize(20)),
                                   new Rectangle(adjuster.adjustedXBound(76), adjuster.adjustedYBound(55),
                                                 adjuster.adjustedWidth(300), adjuster.adjustedHeight(25)));
    JTextField usernameField = addTextField("username", Color.GRAY, Color.BLACK,
                                            new Rectangle(adjuster.adjustedXBound(50), adjuster.adjustedYBound(120),
                                                          adjuster.adjustedWidth(300), adjuster.adjustedHeight(25)));
    JTextField passwordField = addTextField("password", Color.GRAY, Color.BLACK,
                                            new Rectangle(adjuster.adjustedXBound(50), adjuster.adjustedYBound(155),
                                                          adjuster.adjustedWidth(300), adjuster.adjustedHeight(25)));
    JButton loginButton = addButton("login", new Color(255, 120, 200), Color.BLACK,
                                    new Rectangle(adjuster.adjustedXBound(50), adjuster.adjustedYBound(190),
                                                  adjuster.adjustedWidth(300), adjuster.adjustedHeight(25)));
    JButton createAccButton = addButton("create account", new Color(255, 120, 200), Color.BLACK,
                                        new Rectangle(adjuster.adjustedXBound(50), adjuster.adjustedYBound(225),
                                                      adjuster.adjustedWidth(300), adjuster.adjustedHeight(25)));

    public synchronized void run() {
        this.setSize(adjuster.adjustedWidth(400), adjuster.adjustedHeight(400)); // Size
        this.setLocationRelativeTo(null); // This helps center the frame
        this.setLayout(null); // Don't want a layout manager
        this.setResizable(false); // Disable resize
        this.setTitle("Login to StockView"); // Title
        this.getContentPane().setBackground(new Color(40, 45, 55)); // Background color
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closing window ends program
        this.getContentPane().add(loginButton); // Add login button
        this.getContentPane().add(createAccButton); // Add sign up button
        this.getContentPane().add(usernameField); // Add username field
        this.getContentPane().add(passwordField); // Add password field
        this.getContentPane().add(welcomeLabel);
        this.setVisible(true); // Make it visible
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            if (accountsManager.accountExists(usernameField.getText(),
                    passwordField.getText())) {
                // If login is successful
                TradeWindow tradeWindow = new TradeWindow(accountsManager.getAccount(usernameField.getText(),
                                                  passwordField.getText()));
                SwingUtilities.invokeLater(tradeWindow);
                this.dispose();
            } else {
                // If login is unsuccessful
                JOptionPane.showMessageDialog(null,
                                      "You have entered incorrect login information!", "Error",
                                              JOptionPane.ERROR_MESSAGE);
                usernameField.setText("username");
                passwordField.setText("password");
            }
        }
        if (e.getSource() == createAccButton) {
            accountsManager.newAccount(usernameField.getText(), passwordField.getText());
        }
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
    } // This method is a basic template for creating buttons

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

    public JLabel addLabel(String text, Color color, Font font, Rectangle bounds) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setBounds(bounds);
        label.setFont(font);
        return label;
    }
}
