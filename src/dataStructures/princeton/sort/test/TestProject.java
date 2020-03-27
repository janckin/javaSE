package dataStructures.princeton.sort.test;

import a.dataStructures.princeton.sort.project.FastCollinearPoints;
import a.dataStructures.princeton.sort.project.LineSegment;
import a.dataStructures.princeton.sort.project.Point;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.List;

public class TestProject {

    public static void main(String[] args) {

        // read the n points from a file
        /*In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }*/
        Point[] points = getPoints();

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(-10, 10);
        StdDraw.setYscale(-10, 10);
        StdDraw.setPenRadius(0.008);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        //BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            //StdOut.println(segment);
            System.out.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

    private static Point[] getPoints() {
        List<Point> list = new ArrayList<>();
        //y = x
        list.add(new Point(0, 0));
        /*list.add(new Point(1, 1));
        list.add(new Point(-2, -2));
        list.add(new Point(-3, -3));
        list.add(new Point(-4, -4));
        list.add(new Point(-5, -5));*/

        //y = -x +3
        list.add(new Point(1, 2));
        list.add(new Point(0, 3));
        list.add(new Point(2, 1));
        list.add(new Point(3, 0));

        //x = 1
        list.add(new Point(1, 8));
        list.add(new Point(1, 5));
        list.add(new Point(1, 7));
        list.add(new Point(1, 6));

        // y = 0
        /*list.add(new Point(8, 0));
        list.add(new Point(6, 0));*/

        //other points
        list.add(new Point(2, 4));
        list.add(new Point(5, 7));
        list.add(new Point(-4, -9));
        list.add(new Point(-7, -6));
        //x = 0
        list.add(new Point(0, 6));
        list.add(new Point(0, 4));
        list.add(new Point(0, 2));

        return list.toArray(new Point[list.size()]);
    }
}
