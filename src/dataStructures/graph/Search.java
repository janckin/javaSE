package dataStructures.graph;

// this class is api for DepthFirstSearch
public abstract class Search {
    protected boolean[] marked;
    protected int count;
    protected int vertex;

    Search(GraphDPF graph, int start) {
        marked = new boolean[graph.V()];
        count = 0;
        this.vertex = start;
    }

    /**
     * whether vertex connect to target
     *
     * @param vertex a vertex
     * @return result
     */
    public abstract boolean marked(int vertex);

    /**
     * how many vertexes are connect to target
     *
     * @return number
     */
    public abstract int count();
}
