package interfaceKnowledge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTest {
    public static void main(String[] args) {
        ActionListener al = e -> {
            System.out.println(new Date());
            Toolkit.getDefaultToolkit().beep();
        };
        Timer t = new Timer(1000, al);
        t.start();
        JOptionPane.showMessageDialog(null, "quit program?");
        System.exit(0);
    }
}
