package thread.runInterface;

import thread.sleep.Ball;
import thread.sleep.BallComponent;
import thread.sleep.BounceFrame;

import javax.swing.*;
import java.awt.*;

public class BounceThread extends BounceFrame {
    BounceThread() {
        setTitle("ballThread");
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

    @Override
    public void addBalls() {
        ballComponent.add(new Ball(0, 0));
        ballComponent.add(new Ball(200, 100));
        ballComponent.add(new Ball(39, 70));
        Runnable r = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    ballComponent.getBalls().forEach((ball) -> ball.move(ballComponent.getBounds()));
                    ballComponent.repaint();
                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            BounceThread bt = new BounceThread();
            bt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            bt.setVisible(true);
        });
    }
}
