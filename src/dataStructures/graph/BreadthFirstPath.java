package dataStructures.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// implement breadth first path
public class BreadthFirstPath implements Path {
    private boolean[] marked;
    private GraphDPF graph;
    private int vertex;
    private int[] edgeTo;

    BreadthFirstPath(GraphDPF graph, int vertex) {
        this.graph = graph;
        this.vertex = vertex;
        int vertexesNum = graph.V();
        this.edgeTo = new int[vertexesNum];
        this.marked = new boolean[vertexesNum];
        findPath();
    }

    private void findPath() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(vertex);
        int current;
        while (!allMark() && !queue.isEmpty()) {
            current = queue.poll();
            for (Integer nextVertex : graph.adj(current)) {
                if (marked[nextVertex]) continue;
                queue.add(nextVertex);
                marked[nextVertex] = true;
                edgeTo[nextVertex] = current;
            }
        }

    }

    private boolean allMark() {
        for (boolean b : marked) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int w = v; w != vertex; w = edgeTo[w]) {
            queue.add(w);
        }
        queue.add(vertex);
        return queue;
    }

    public int[] getEdgeTo() {
        return edgeTo;
    }

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(DepthFirstSearch.class.getResourceAsStream("tinyCG.txt")))) {
            GraphDPF graph = new GraphDPF(bf);
            int startVertex = 0;
            //it is some different from book because of iterator sequence
            BreadthFirstPath breadthFirstPath = new BreadthFirstPath(graph, startVertex);

            System.out.println(">>>> path >>>>>");
            int[] path = breadthFirstPath.getEdgeTo();
            for (int i = 0; i < path.length; i++) {
                System.out.println(path[i] + "->" + i);
            }

            System.out.println(">>>> pathTo >>>>>");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.length; i++) {
                sb.append(startVertex).append(" to ").append(i).append(" path: ");
                for (Integer j : breadthFirstPath.pathTo(i)) {
                    sb.append(j).append(" -> ");
                }
                sb.append("end").append("\n");
            }
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
