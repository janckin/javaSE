package dataStructures.princeton.sort.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {
    private final int MINIMAL = 4;
    private final List<LineSegment> segments = new ArrayList<>();

    //finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        //check corner cases
        if (points == null) {
            throw new NullPointerException("the number of points is invalidate");
        }
        if (hasDuplicate(points)) {
            throw new IllegalArgumentException("points have duplicate points");
        }
        if (points.length < MINIMAL) {
            return;
        }

        findLineSegments(points);
    }

    private void findLineSegments(Point[] points) {
        Arrays.sort(points);
        int len = points.length;
        Point[] oldPoints = new Point[len];
        for (int i = 0; i < len; i++) {
            oldPoints[i] = points[i];
        }

        for (int i = 0; i < len - 3; i++) {
            Arrays.sort(points, oldPoints[i].slopeOrder());
            int p = 0;
            for (int first = 1, last = 2; last < len; last++) {
                Point p0 = points[p];
                Point p1 = points[first];
                double slope_first = p0.slopeTo(p1);
                while (last < len && Double.compare(slope_first, p0.slopeTo(points[last])) == 0) {
                    last++;
                }
                if (last - first >= (MINIMAL - 1) && p0.compareTo(p1) < 0) {
                    segments.add(new LineSegment(p0, points[last - 1]));
                }
                first = last;
            }

        }
    }

    //the line segments
    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[segments.size()]);
    }

    //the number of line segments
    public int numberOfSegments() {
        return segments.size();
    }

    //check whether points have repeat point
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