package dataStructures.graph;

public interface Path {
    /**
     * is there a path from s to v?
     *
     * @param v vertex
     * @return boolean
     */
    boolean hasPathTo(int v);

    /**
     * path from s to v; null if no such path
     *
     * @param v vertex
     * @return iterator
     */
    Iterable<Integer> pathTo(int v);
}
