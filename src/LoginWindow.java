import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginWindow extends JFrame implements Runnable, ActionListener {

    DimensionAdjuster adjuster = new DimensionAdjuster();
    AccountsManager accountsManager = new AccountsManager();
    JButton loginButton = addButton("Sign in", Color.GRAY, Color.BLACK);
    JButton createAccButton = addButton("Sign up", Color.GRAY, Color.BLACK);
    JTextField usernameField = addTextField("username", Color.GRAY, Color.BLACK);
    JTextField passwordField = addTextField("password", Color.GRAY, Color.BLACK);
    private final Font font = new Font(Font.SANS_SERIF, Font.PLAIN, adjuster.adjustedFontSize(72));

    public synchronized void run() {
        this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 5,
                (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 4); // Size
        this.setLocationRelativeTo(null); // This helps center the frame
        this.setLayout(null); // Don't want a layout manager
        this.setResizable(false); // Disable resize
        this.setTitle("Login to StockView"); // Title
        this.getContentPane().setBackground(new Color(40, 45, 55)); // Background color
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closing window ends program

        // Set up and add buttons
        loginButton.setBounds(this.getWidth() / 4, this.getHeight() / 3 + this.getHeight() / 12,
                              this.getWidth() / 4, this.getHeight() / 16);
        createAccButton.setBounds(this.getWidth() / 4, this.getHeight() / 3 + this.getHeight() / 6,
                                  this.getWidth() / 4, this.getHeight() / 16);
        loginButton.addActionListener(this);
        createAccButton.addActionListener(this);
        this.getContentPane().add(loginButton);
        this.getContentPane().add(createAccButton);

        //Set up and add text fields
        usernameField.setBounds(this.getWidth() / 4, this.getHeight() / 4,
                                this.getWidth() / 2, this.getHeight() / 16);
        passwordField.setBounds(this.getWidth() / 4, this.getHeight() / 4 + this.getHeight() / 12,
                                this.getWidth() / 2, this.getHeight() / 16);
        this.getContentPane().add(usernameField);
        this.getContentPane().add(passwordField);

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

    public JButton addButton(String title, Color background, Color foreground) {
        JButton button = new JButton(title);
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFocusable(false);
        button.setFont(font);
        return button;
    } // This method is a basic template for creating buttons

    public JTextField addTextField(String title, Color background, Color foreground) {
        JTextField textField = new JTextField(title);
        textField.setBackground(background);
        textField.setForeground(foreground);
        textField.addActionListener(this);
        textField.setFocusable(true);
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
