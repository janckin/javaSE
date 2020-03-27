package dataStructures.princeton.sort.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Deprecated
public class BruteCollinearPointsOld {
    private int segments_num = 0;
    private List<LineSegment> segments = new ArrayList<>();
    private int MINIMAL_NUM = 4;

    /**
     * finds all line segments containing 4 points
     *
     * @param points all points
     */
    public BruteCollinearPointsOld(Point[] points) {
        if (points.length <= 1) {
            return;
        }

        //sort points so that the smaller one is the start point
        Arrays.sort(points);

        //create the vector by points
        List<LineSegment> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                LineSegment lineSegment = new LineSegment(points[i], points[j]);
                list.add(lineSegment);
            }
        }

        //sort the array by the number of lineSegments which have same slope
        List<LinePoints> list_liP = new ArrayList<>();
        LinePoints linePoints = new LinePoints();
        for (int i = 0; i < list.size(); i++) {
            LineSegment lineSegment = list.get(i);
            //segment is on the same line or first segment
            if (lineSegment.getSlope() != linePoints.getSlope() && linePoints.getSegments_num() != 0) {
                list_liP.add(linePoints);
                linePoints = new LinePoints();
            }
            linePoints.add(lineSegment);
            if (i == list.size() - 1) {
                list_liP.add(linePoints);
            }
        }

        //get very lineSegments which contains more than MINIMAL_NUM points/2 lineSegments;
        Collections.sort(list_liP, new LinePoints());
        for (int i = 0; i < list_liP.size(); i++) {
            LinePoints liPs = list_liP.get(i);
            int segment_num = liPs.getSegments_num();
            double slope = liPs.getSlope();
            boolean inXY = slope == Double.NEGATIVE_INFINITY || slope == Double.POSITIVE_INFINITY || slope == 0;
            if (segment_num >= MINIMAL_NUM && !inXY) {

                //account the segments_num;
                this.segments_num += segment_num;

                //set the segments method
                segments.addAll(liPs.getLineSegmentsList());
            }
        }
    }


    /**
     * print the number of line segments
     *
     * @return the number of line segments
     */
    public int numberOfSegments() {
        return segments_num;
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

}
