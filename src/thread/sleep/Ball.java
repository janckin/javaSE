package thread.sleep;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
    private double x;/* the left up corner */
    private double y;/* the left up corner */
    private double dx = 1;/* the number of the increase of x axis*/
    private double dy = 1;/* the number of the increase of x axis*/
    private static final int WIDTH = 15;
    private static final int HEIGHT = 15;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * change the x,y axis so that Ball can move
     *
     * @param bounds the panel
     */
    public void move(Rectangle2D bounds) {
        //the next place
        x = x + dx;
        y = y + dy;

        //test bounds
        double xLeft = bounds.getMinX();
        double xRight = bounds.getMaxX();
        double yUp = bounds.getMinY();
        double yBottom = bounds.getMaxY();

        //out of left bounds
        if (x < xLeft) {
            x = xLeft;
            dx = -dx;//change the direction
        }

        //out of right bounds
        if (x + WIDTH >= xRight) {
            x = xRight - WIDTH;
            dx = -dx;//change the direction
        }

        //out of up bounds
        if (y < yUp) {
            y = yUp;
            dy = -dy;//change the direction
        }

        //out of bottom bounds
        if (y + HEIGHT >= yBottom) {
            y = yBottom - HEIGHT;
            dy = -dy;//change the direction
        }
    }


    /**
     * get the sharp of current ball
     *
     * @return Ellipse2D
     */
    public Ellipse2D getSharp() {
        return new Ellipse2D.Double(x, y, WIDTH, HEIGHT);
    }


}
