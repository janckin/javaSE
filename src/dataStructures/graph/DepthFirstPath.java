package dataStructures.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class DepthFirstPath implements Path {
    private GraphDPF graph;
    private int[] edgeTo;
    private boolean[] marked;
    private int vertex;

    DepthFirstPath(GraphDPF graph, int vertex) {
        this.graph = graph;
        this.vertex = vertex;
        int vertexesNum = graph.V();
        this.edgeTo = new int[vertexesNum];
        this.marked = new boolean[vertexesNum];
        findPath(this.graph, vertex);
    }

    private void findPath(GraphDPF graph, int vertex) {
        this.marked[vertex] = true;
        for (Integer connect : graph.adj(vertex)) {
            if (!this.marked[connect]) {
                edgeTo[connect] = vertex;//记录唯一次的节点
                findPath(graph, connect);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return this.marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != this.vertex; x = edgeTo[x])// if not equal to vertex, x will change to parent node
            path.push(x);
        path.push(this.vertex);
        return path;
    }

    public int[] getEdgeTo() {
        return edgeTo;
    }

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(DepthFirstSearch.class.getResourceAsStream("tinyCG.txt")))) {
            GraphDPF graph = new GraphDPF(bf);
            //it is some different from book because of iterator sequence
            DepthFirstPath depthFirstPath = new DepthFirstPath(graph, 0);

            System.out.println(">>>> path >>>>>");
            int[] path = depthFirstPath.getEdgeTo();
            for (int i = 0; i < path.length; i++) {
                System.out.println(path[i] + "->" + i);
            }

            System.out.println(">>>> pathTo >>>>>");
            depthFirstPath.pathTo(1).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
