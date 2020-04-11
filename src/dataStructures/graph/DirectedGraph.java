package dataStructures.graph;

import dataStructures.fundamentals.BagForDFP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DirectedGraph {
    private int vertexNum;
    private int edgeNum;
    private BagForDFP<Integer>[] adj;

    public DirectedGraph(int vertexNum, int edgeNum) {
        init(vertexNum, edgeNum);
    }

    public DirectedGraph(BufferedReader bf) {
        if (bf == null) {
            return;
        }
        try (bf) {
            init(Integer.parseInt(bf.readLine()), Integer.parseInt(bf.readLine()));
            String s;
            while ((s = bf.readLine()) != null) {
                String[] vertexes = s.split(" ");
                addEdge(Integer.parseInt(vertexes[0]), Integer.parseInt(vertexes[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("all")
    private void init(int vertexNum, int edgeNum) {
        this.vertexNum = vertexNum;
        this.edgeNum = edgeNum;
        adj = new BagForDFP[vertexNum];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new BagForDFP<>();
        }
    }

    /**
     * number of vertices
     *
     * @return number
     */
    public int V() {
        return vertexNum;
    }

    /**
     * number of edges
     *
     * @return number
     */
    public int E() {
        return edgeNum;
    }

    /**
     * add edge v->w to this digraph
     *
     * @param start vertex
     * @param end   other vertex
     */
    public void addEdge(int start, int end) {
        adj[start].add(end);
    }

    /**
     * vertices connected to v by edges
     *
     * @param v the start vertex
     * @return iterable
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * reverse of this digraph
     *
     * @return DirectGraph
     */
    public DirectedGraph reverse() {
        DirectedGraph reverseDG = new DirectedGraph(vertexNum, edgeNum);
        for (int i = 0; i < adj.length; i++) {
            for (Integer integer : adj[i]) {
                reverseDG.addEdge(integer, i);
            }
        }
        return reverseDG;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < adj.length; i++) {
            sb.append(i).append(" : ");
            for (Integer vertex : adj(i)) {
                sb.append(vertex).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(DirectedGraph.class.getResourceAsStream("tinyDG.txt")))) {
            System.out.println(">>> test DirectedGraph >>>");
            DirectedGraph dg = new DirectedGraph(bf);
            System.out.println("vertex number :" + dg.V());
            System.out.println("edge number :" + dg.E());
            System.out.println(dg);
            System.out.println(">>> test reverse >>>");
            System.out.println(dg.reverse());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
