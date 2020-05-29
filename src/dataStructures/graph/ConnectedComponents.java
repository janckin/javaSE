package dataStructures.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//this class is used to find the connected components of a graph
public class ConnectedComponents {
    private boolean[] marked;
    private int[] ids;/* 如果ids的值是一样的，说明这2个点在同一个连接内 */
    private int count;/* 整个图中有连接节点的数量 */
    private int[] edgeTo;

    /*
    ConnectedComponents(GraphDPF G) {
        int vertexesNum = G.V();
        this.marked = new boolean[vertexesNum];
        this.ids = new int[vertexesNum];
        this.count = 0;
        this.graphDPF = G;
        for (int i = 0; i < marked.length; i++) {
            if (!marked[i]) {
                depthFirstSearch(G, i);
                count++;
            }
        }
    }

    //this method will cause stackOverFlow
    private void depthFirstSearch(GraphDPF graph, int vertex) {
        marked[vertex] = true;
        ids[vertex] = count;//??
        for (Integer integer : graph.adj(vertex)) {
            if (!marked[integer]) {
                path[integer] = vertex;
                depthFirstSearch(graph, vertex);
            }
        }

    }*/
    ConnectedComponents(GraphDPF G) {
        int vertexesNum = G.V();
        this.marked = new boolean[vertexesNum];
        this.ids = new int[vertexesNum];
        this.edgeTo = new int[vertexesNum];
        this.count = 0;
        depthFirstSearch(G, 0);
        rebuildMarked();
    }

    private void depthFirstSearch(GraphDPF graph, int vertex) {
        marked[vertex] = true;
        for (Integer integer : graph.adj(vertex)) {
            if (!marked[integer]) {
                edgeTo[integer] = vertex;
                depthFirstSearch(graph, integer);
            }
        }
    }

    private void buildIds() {
    }

    private void rebuildMarked() {
        Arrays.fill(marked, false);
    }

    // are v and w connected?
    public boolean connected(int v, int w) {
        return ids[v] == ids[w];
    }

    // number of connected components
    public int count() {
        return this.count;
    }

    //component identifier for v ( between 0 and count()-1 )
    public int id(int v) {
        return ids[v];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(count).append(" connected component");
        for (int i = 0; i < count; i++) {
            sb.append(i).append(" : ");
            for (int i1 = 0; i1 < ids.length; i1++) {
                if (ids[i1] == i) {
                    sb.append(i1).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(ConnectedComponents.class.getResourceAsStream("tinyG.txt")))) {
            GraphDPF graphDPF = new GraphDPF(bf);
            ConnectedComponents connectedComponents = new ConnectedComponents(graphDPF);
            System.out.println(connectedComponents.toString()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
