package thread.sleep;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//this class is used to draw balls
public class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;
    private List<Ball> balls;

    public BallComponent() {
        balls = new ArrayList<>();
    }

    public void add(Ball ball) {
        balls.add(ball);
    }

    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);//erase background
        Graphics2D g = (Graphics2D) graphic;
        balls.forEach((ball) -> g.fill(ball.getSharp()));
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
