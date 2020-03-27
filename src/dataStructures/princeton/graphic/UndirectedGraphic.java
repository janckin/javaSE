package dataStructures.princeton.graphic;

import java.util.*;

public class UndirectedGraphic<T> {
    private int verticesNum;/* the number of edge vertices*/
    private int edgeNum;/* the number of edge */
    private Map<T, List<T>> verticesGraphic;/* record the very edge of a node*/

    public UndirectedGraphic(int verticesNum) {
        this.verticesNum = verticesNum;
        this.verticesGraphic = new HashMap<>();
    }

    public int getVerticesNum() {
        return verticesNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    public void addEdge(T one, T other) {
        List<T> list1 = verticesGraphic.get(one);
        List<T> list2 = verticesGraphic.get(other);
        if (list1 == null) {
            list1 = new LinkedList<>();
        }
        if (list2 == null) {
            list2 = new LinkedList<>();
        }

        list1.add(other);
        list2.add(one);

        edgeNum++;
    }

    public Iterable<T> iterable(T v) {
        return () -> listIterator(v);
    }

    private Iterator<T> listIterator(T v) {
        List<T> list1 = verticesGraphic.get(v);
        return list1.iterator();
    }


}
