package dataStructures.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// using the depth first search in a directed graph to make sure whether a vertex is reachable in graph
public class DGDepthFirstSearch {
    private boolean[] marked;

    DGDepthFirstSearch(DirectedGraph graph, int startVertex) {
        this.marked = new boolean[graph.V()];
        depthFirstSearch(graph, startVertex);
    }

    private void depthFirstSearch(DirectedGraph graph, int vertex) {
        marked[vertex] = true;
        for (Integer end : graph.adj(vertex)) {
            if (!marked(end)) {
                depthFirstSearch(graph, end);
            }
        }
    }

    public boolean marked(int vertex) {
        return marked[vertex];
    }

    public void showReachVertexes() {
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(DGDepthFirstSearch.class.getResourceAsStream("tinyDG.txt")))) {
            DirectedGraph graph = new DirectedGraph(bf);
            DGDepthFirstSearch dgDepthFirstSearch = new DGDepthFirstSearch(graph, 2);
            dgDepthFirstSearch.showReachVertexes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
