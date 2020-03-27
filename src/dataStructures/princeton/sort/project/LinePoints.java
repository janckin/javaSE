package dataStructures.princeton.sort.project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * this class is used to store lineSegments with same slope in abs
 */
@Deprecated
public class LinePoints implements Comparable<LinePoints>, Comparator<LinePoints> {
    private List<LineSegment> lineSegments = null;

    public LinePoints() {
        lineSegments = new ArrayList<>();
    }

    public void add(LineSegment lineSegment) {
        double slope = getSlope();
        double slope_that = lineSegment.getSlope();
        if (slope == slope_that || lineSegments.size() == 0) {
            lineSegments.add(lineSegment);
        }
    }

    public LineSegment[] getLineSegmentsArray() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }

    List<LineSegment> getLineSegmentsList() {
        if (lineSegments == null) {
            return new ArrayList<>();
        }
        return lineSegments;
    }

    int getSegments_num() {
        return lineSegments.size();
    }

    double getSlope() {
        if (lineSegments.size() == 0 || lineSegments == null) {
            return Double.MIN_VALUE;
        } else {
            return lineSegments.get(0).getSlope();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinePoints that = (LinePoints) o;
        List<LineSegment> p1 = that.getLineSegmentsList();
        if (p1.size() != lineSegments.size()) {
            return false;
        }
        return lineSegments.containsAll(p1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineSegments);
    }

    @Override
    public int compareTo(LinePoints o) {
        int compare = o.getSegments_num() - o.getSegments_num();
        if (compare > 0) {
            return 1;
        } else if (compare == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public int compare(LinePoints o1, LinePoints o2) {
        double compare = o1.getSlope() - o2.getSlope();
        if (compare > 0) {
            return 1;
        } else if (compare == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    private class PointsInLine {
        private List<Point> points;
        private double slope;

        public PointsInLine() {
            points = new ArrayList<>();
            slope = Double.MIN_VALUE;
        }

        public PointsInLine(Point point) {
            points.add(point);
        }

        public PointsInLine(Point point1, Point point2) {
            if (point1.compareTo(point2) == 0) {
                points.add(point1);
                return;
            }
            points.add(point1);
            points.add(point2);
            slope = point1.slopeTo(point2);
        }

        public boolean add(Point point) {
            if (points.contains(point)) {
                return false;
            }
            if (points.size() <= 1) {
                points.add(point);
                if (points.size() == 2) {
                    slope = points.get(0).slopeTo(point);
                }
                return true;
            }
            Point startPoint = points.get(0);
            if (slope == startPoint.slopeTo(point)) {
                points.add(point);
                return true;
            }
            return false;
        }

        //return points number
        public int pointsNum() {
            return points.size();
        }

        // get the slope of those point
        public double getSlope() {
            return slope;
        }

        public LineSegment[] segments() {
            if (points.size() <= 1) {
                return new LineSegment[0];
            }
            List<LineSegment> list = new ArrayList<>();
            for (int i = 0; i < points.size() - 1; i++) {
                for (int j = i + 1; j < points.size(); j++) {
                    list.add(new LineSegment(points.get(i), points.get(j)));
                }
            }
            int length = points.size() * (points.size() - 1) / 2;
            return list.toArray(new LineSegment[length]);
        }


    }

}