import javax.swing.*;
import java.awt.*;

public class TradeWindow extends JFrame implements Runnable {
    public synchronized void run() {
        this.setSize(new Dimension(200, 200));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
