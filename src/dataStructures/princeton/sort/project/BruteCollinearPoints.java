package dataStructures.princeton.sort.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    private final List<LineSegment> segments = new ArrayList<>();

    /**
     * finds all line segments containing 4 points
     *
     * @param points all points
     */
    public BruteCollinearPoints(Point[] points) {
        //check corner cases
        if (points == null) {
            throw new NullPointerException("the number of points is invalidate");
        }
        if (hasDuplicate(points)) {
            throw new IllegalArgumentException("points have duplicate points");
        }
        //sort array so that lineSegment start from second or third Quadrant
        Arrays.sort(points);

        //create the vector by points
        double slope;
        int n = points.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                slope = points[i].slopeTo(points[j]);
                for (int k = j + 1; k < n - 1; k++) {
                    if (slope == points[i].slopeTo(points[k])) {
                        for (int x = k + 1; x < n; x++) {
                            if (slope == points[i].slopeTo(points[x])) {
                                segments.add(new LineSegment(points[i], points[x]));
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * print the number of line segments
     *
     * @return the number of line segments
     */
    public int numberOfSegments() {
        return segments.size();
    }

    /**
     * create segments
     *
     * @return array of LineSegment
     */
    public LineSegment[] segments() {
        if (segments == null) {
            return new LineSegment[0];
        }

        return segments.toArray(new LineSegment[segments.size()]);
    }

    private boolean hasDuplicate(Point[] points) {
        Arrays.sort(points);
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                return true;
            }
        }
        return false;
    }

}
