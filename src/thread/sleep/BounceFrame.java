package thread.sleep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class BounceFrame extends JFrame {
    protected BallComponent ballComponent;
    protected static final int STEPS = 5000;/* 循环出现的次数 */
    protected static final int DELAY = 3;/* 毫秒数*/

    public BounceFrame() {
        setTitle("ball");
        //JPanel for background
        ballComponent = new BallComponent();
        add(ballComponent, BorderLayout.CENTER);

        //JPanel for button
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "start", even -> addBalls());
        addButton(buttonPanel, "exit", even -> System.exit(WindowConstants.DO_NOTHING_ON_CLOSE));
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }

    protected void addButton(Container container, String title, ActionListener actionListener) {
        JButton jb = new JButton(title);
        container.add(jb);
        jb.addActionListener(actionListener);
    }

    public void addBalls() {
        try {
            ballComponent.add(new Ball(0, 0));
            /*ballComponent.add(new Ball(200, 100));
            ballComponent.add(new Ball(39, 70));*/

            List<Ball> balls = ballComponent.getBalls();
            for (int i = 0; i < STEPS; i++) {
                balls.forEach((ball) -> ball.move(ballComponent.getBounds()));
                ballComponent.paintComponent(ballComponent.getGraphics());
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}