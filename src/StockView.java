// Main class that starts the entire process by calling the run() in LoginWindow class.

import javax.swing.*;

public class StockView {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new  LoginWindow());
    }
}
