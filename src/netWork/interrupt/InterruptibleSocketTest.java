package netWork.interrupt;

import javax.swing.*;

public class InterruptibleSocketTest {
    public static void main(String[] args) {
        JFrame jFrame = new InterruptibleSocketFrame();
        jFrame.setTitle("测试不拥塞socket");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
