package dataStructures.graph;

import dataStructures.fundamentals.Bag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//undirected graph
@SuppressWarnings("unchecked")
public class Graph {
    private Bag<Integer>[] adj;
    private int verticesNum;
    private int edgeNum;

    /**
     * constructor build by vertices number
     *
     * @param v the number of vertices
     */
    Graph(int v) {
        this.verticesNum = v;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Bag<>();
        }
    }

    /**
     * constructor built by the file
     *
     * @param bf the file
     */
    Graph(BufferedReader bf) throws IOException {
        this(Integer.parseInt(bf.readLine()));
        //init
        int edgeNum = Integer.parseInt(bf.readLine());
        String s;
        while ((s = bf.readLine()) != null) {
            String[] vs = s.split(" ");
            int v = Integer.parseInt(vs[0]);
            int w = Integer.parseInt(vs[1]);
            addEdge(v, w);
        }
    }

    /**
     * number of vertices
     *
     * @return number
     */
    int V() {
        return verticesNum;
    }

    /**
     * number of edges
     *
     * @return number
     */
    int E() {
        return edgeNum;
    }

    /**
     * add edge v-w to this graph
     *
     * @param v one vertex
     * @param w the other vertex
     */
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edgeNum++;
    }

    /**
     * vertices adjacent to v
     *
     * @param v the target
     * @return iterable of all vertexes
     */
    Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(verticesNum).append(" vertices, ").append(edgeNum).append(" edges\n");
        for (int i = 0; i < adj.length; i++) {
            sb.append(i).append(": ");
            for (Integer w : adj[i]) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(Graph.class.getResourceAsStream("tinyG.txt")))) {
            Graph graph = new Graph(bf);
            System.out.println(graph.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
