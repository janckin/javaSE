package dataStructures.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//this class is the warm up for DepthFirstPath
public class DepthFirstSearch extends Search {

    DepthFirstSearch(GraphDPF graph, int start) {
        super(graph, start);
        search(graph, start);
    }

    //to marked all the connected node in the graph
    private void search(GraphDPF graph, int vertex) {
        super.marked[vertex] = true;
        super.count++;
        for (int w : graph.adj(vertex)) {
            if (!super.marked[w]) {
                System.out.println(vertex + " find -> " + w);
                search(graph, w);
            }
        }
    }

    @Override
    public boolean marked(int vertex) {
        return super.marked[vertex];
    }

    @Override
    public int count() {
        return super.count;
    }

    //test
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(DepthFirstSearch.class.getResourceAsStream("tinyCG.txt")))) {
            GraphDPF graph = new GraphDPF(bf);
            //it is some different from book because of iterator sequence
            DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
            System.out.println("find " + depthFirstSearch.count() + " times");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
