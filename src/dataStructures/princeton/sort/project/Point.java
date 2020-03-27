package dataStructures.princeton.sort.project;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    /**
     * Initializes a new point.
     *
     * @param x the <em>x</em>-coordinate of the point
     * @param y the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {
        int x0, y0, x1, y1;
        x0 = this.x;
        y0 = this.y;
        x1 = that.x;
        y1 = that.y;

        if (x1 == x0) {
            if (y1 == y0) {
                //(x0, y0) and (x1, y1) are equal
                return Double.NEGATIVE_INFINITY;
            } else {
                //vertical
                return Double.POSITIVE_INFINITY;
            }
        }

        double slope = (double) (y1 - y0) / (x1 - x0);
        if (slope == 0) {
            //horizontal
            return +0.0;
        }
        return slope;
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     * point (x0 = x1 and y0 = y1);
     * a negative integer if this point is less than the argument
     * point; and a positive integer if this point is greater than the
     * argument point
     */
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        if (this.y < that.y) {
            return -1;
        }
        if (this.y == that.y) {
            if (this.x < that.x) {
                return -1;
            } else if (this.x == that.x) {
                return 0;
            }
        }
        return 1;
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        Comparator<Point> comparator = new ByIndex();
        return comparator;
    }

    private class ByIndex implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            Point point0 = new Point(x, y);
            double slope = point0.slopeTo(o1);
            double slope2 = point0.slopeTo(o2);
            if (slope - slope2 < 0) {
                return -1;
            } else if (slope - slope2 > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Unit tests the Point data type.
     */
    /*public static void main(String[] args) {
        Point a1 = new Point(0, 1);

        //horizontal
        Point a1_hor = new Point(0, -2);
        //vertical
        Point a11 = new Point(1, 1);
        //equal
        Point a0 = new Point(0, 1);

        Point a00 = new Point(0, 0);
        Point a11_line = new Point(2, 0);

        //test compareTo
        assert a1.compareTo(a0) == 0;
        assert a1.compareTo(a11) < 0;
        assert a1.compareTo(a11_line) > 0;

        //test slop
        *//*
     * For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *//*
        assert a1.slopeTo(a1_hor) == +0.0;
        assert a1.slopeTo(a11) == Double.POSITIVE_INFINITY;
        assert a1.slopeTo(a00) == Double.NEGATIVE_INFINITY;
        assert a0.slopeTo(a1) == 1;
        assert a1.slopeTo(a11_line) == 1;


        //slopeOrder
        Point[] points = new Point[]{a00, a1_hor, a11_line, a0, a11, a1};
        Point[] result = new Point[]{a1_hor, a00, a0, a11_line, a1, a11};
        Arrays.sort(points, new Point(0, 0).slopeOrder());
        assert result.equals(points);

        System.out.println("test pass!!");
    }*/
}