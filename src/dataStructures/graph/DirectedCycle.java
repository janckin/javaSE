package dataStructures.graph;

import java.util.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    DirectedCycle(GraphDPF graph) {
        int num = graph.V();
        this.marked = new boolean[num];
        this.edgeTo = new int[num];
        this.onStack = new boolean[num];
        for (int v = 0; v < num; v++) {
            if (!marked[v]) dpf(graph, v);
        }
    }

    private void dpf(GraphDPF graph, int v) {
        onStack[v] = true;
        marked[v] = true;
        //找出v顶点下，与他相连的全部节点
        for (int w : graph.adj(v)) {
            if (hasCycle()) {
                return;//找到环就退出
            } else if (!marked[w]) {
                //w节点没有被遍历
                edgeTo[w] = v;
                //继续记录边长关系
                dpf(graph, w);
            } else if(onStack[w]){
                cycle = new Stack<>();
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }


    boolean hasCycle() {
        return cycle != null;
    }

    Iterable<Integer> cycle() {
        return cycle;
    }
}
