package thread.sleep;

import javax.swing.*;
import java.awt.*;

public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            BounceFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

