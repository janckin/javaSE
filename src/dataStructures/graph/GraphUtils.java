package dataStructures.graph;

public class GraphUtils {
    /**
     * compute the degree of v
     *
     * @param g used graph
     * @param v the vertexes
     * @return the degree number
     */
    public static int degree(Graph g, int v) {
        int degree = 0;
        for (int w : g.adj(v)) degree++;
        return degree;
    }

    /**
     * compute the maximum degree in graph
     *
     * @param g graph
     * @return the max degree
     */
    public static int maxDegree(Graph g) {
        int max = 0;
        for (int i = 0; i < g.V(); i++) {
            int degree = degree(g, i);
            if (degree > max) max = degree;
        }
        return max;
    }

    /**
     * compute the average of degree on graph
     *
     * @param g the graph
     * @return the average
     */
    public static int avgDegree(Graph g) {
        return 2 * g.E() / g.V();
    }

    /**
     * count self-loops
     * @param g graph
     * @return the number of self-loops
     */
    public static int numberOfSelfLoops(Graph g) {
        int count = 0;
        for (int v = 0; v < g.V(); v++) {
            //w is very vertexes connecting to v
            for (int w : g.adj(v)) {
                if (w == v) count++;
            }
        }
        return count / 2;
    }
}
