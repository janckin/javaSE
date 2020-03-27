package dataStructures.princeton.priorityQueue.project;

public class TestUnits {
    public static Board puzzle07() {
        //reference moves() = 7
        int[][] tiles = new int[3][3];
        tiles[0][0] = 1;
        tiles[0][1] = 2;
        tiles[0][2] = 3;
        tiles[1][0] = 0;
        tiles[1][1] = 7;
        tiles[1][2] = 6;
        tiles[2][0] = 5;
        tiles[2][1] = 4;
        tiles[2][2] = 8;
        Board initial = new Board(tiles);
        return initial;
    }

    public static Board puzzle08() {
        //reference moves() = 8
        int[][] tiles = new int[3][3];
        tiles[0][0] = 2;
        tiles[0][1] = 3;
        tiles[0][2] = 5;
        tiles[1][0] = 1;
        tiles[1][1] = 0;
        tiles[1][2] = 4;
        tiles[2][0] = 7;
        tiles[2][1] = 8;
        tiles[2][2] = 6;
        Board initial = new Board(tiles);
        return initial;
    }

    public static Board puzzle01() {
        //reference moves() = 2
        int[][] tiles = new int[2][2];
        tiles[0][0] = 1;
        tiles[0][1] = 0;
        tiles[1][0] = 3;
        tiles[1][1] = 2;
        Board initial = new Board(tiles);
        return initial;
    }
}
