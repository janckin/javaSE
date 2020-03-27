package dataStructures.princeton.priorityQueue.project;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Board {
    private final int dimension;
    private final int len;
    private final int[] blocks;
    private Board twin;

    /**
     * create a board from an n-by-n array of tiles,where tiles[row][col] = tile at (row, col)
     *
     * @param tiles
     */
    public Board(int[][] tiles) {
        dimension = tiles.length;
        len = dimension * dimension;
        blocks = new int[len];
        int index = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                int context = tiles[i][j];
                blocks[index] = context;
                index++;
            }
        }

    }

    private Board(int[] blocks, int dimension) {
        this.dimension = dimension;
        this.len = dimension * dimension;
        this.blocks = Arrays.copyOf(blocks, blocks.length);
    }

    /**
     * string representation of this board
     *
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dimension + "\n");
        int index = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                sb.append(blocks[index]);
                if (j != dimension - 1) {
                    sb.append(" ");
                }
                index++;
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * board dimension n
     *
     * @return the length of row or column
     */
    public int dimension() {
        return dimension;
    }

    /**
     * number of tiles out of place
     *
     * @return number
     */
    public int hamming() {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (blocks[i] != 0 && blocks[i] != (i + 1)) {
                count++;
            }
        }
        return count;
    }

    /**
     * sum of Manhattan distances between tiles and goal
     *
     * @return number
     */
    public int manhattan() {
        int manhattan = 0;
        for (int k = 0; k < len; k++) {
            if (blocks[k] == 0) continue;
            int rowDistance = Math.abs(getRow(blocks[k]) - getRow(k + 1));
            int colDistance = Math.abs(getCol(blocks[k]) - getCol(k + 1));
            manhattan = manhattan + rowDistance + colDistance;
        }
        return manhattan;
    }

    /**
     * justify this board to be goal board
     *
     * @return result
     */
    public boolean isGoal() {
        for (int k = 0; k < len - 1; k++) {
            if (blocks[k] != k + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * does this board equal y?
     *
     * @param object the object
     * @return the result of equality
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (this == object) return true;
        if (this.getClass() != object.getClass()) return false;
        Board board = (Board) object;
        return Arrays.equals(blocks, board.blocks);
    }


    /**
     * find all neighboring boards
     *
     * @return Iterable
     */
    public Iterable<Board> neighbors() {
        return () -> {
            /** find the 0 block */
            int index = 0;
            for (int i = 0; i < len; i++) {
                if (blocks[i] == 0) {
                    index = i;
                    break;
                }
            }
            /** get up,left,bottom,right index */
            int[] indexs = getSurroundIndexes(index);

            /** create the new board */
            List<Board> boards = new ArrayList<>();
            for (int i = 0; i < indexs.length; i++) {
                if (indexs[i] != -1) {
                    int[] neighbour = Arrays.copyOf(blocks, blocks.length);
                    exchangeElement(neighbour, indexs[i], index);
                    Board b = new Board(neighbour, dimension);
                    boards.add(b);
                }
            }
            return boards.iterator();
        };
    }

    /**
     * a board that is obtained by exchanging any pair of tiles
     *
     * @return a twin board
     */
    public Board twin() {
        if (twin == null) {
            int[] twinBlocks = Arrays.copyOf(blocks, blocks.length);
            /** choose a non-blank block randomly */
            int k, j;
            do {
                k = StdRandom.uniform(len);
                j = StdRandom.uniform(len);
            } while (blocks[k] == 0 || blocks[j] == 0 || k == j);

            exchangeElement(twinBlocks, k, j);
            twin = new Board(twinBlocks, dimension);
        }
        return twin;
    }

    /**
     * get row number(start from 1)
     *
     * @param index the index need to find
     * @return row
     */
    private int getRow(int index) {
        return (int) Math.ceil((double) index / (double) dimension);
    }


    /**
     * get column number(start from 1)
     *
     * @param index the index need to find
     * @return col
     */
    private int getCol(int index) {
        if (index % dimension == 0) return dimension;
        return index % dimension;
    }

    /**
     * get up,left,bottom,right index
     *
     * @param index the node index in blocks
     * @return all indexs in blocks
     */
    private int[] getSurroundIndexes(int index) {
        /** get row and col in n-n array*/
        int row = getRow(index + 1);
        int col = getCol(index + 1);

        /** get up,left,bottom,right index*/
        int[] indexes = new int[4];
        indexes[0] = getIndex(row - 1, col);
        indexes[1] = getIndex(row, col - 1);
        indexes[2] = getIndex(row + 1, col);
        indexes[3] = getIndex(row, col + 1);
        return indexes;
    }

    /**
     * exchange two element in a array
     *
     * @param array  the array
     * @param indexA first index
     * @param indexB second index
     */
    private void exchangeElement(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }


    /**
     * get index by row and col
     *
     * @param row
     * @param col
     * @return
     */
    private int getIndex(int row, int col) {
        if (row <= 0 || col <= 0 || row > dimension || col > dimension) {
            return -1;
        }
        return (row - 1) * dimension + (col - 1);
    }


    /**
     * unit testing (not graded)
     *
     * @param args
     */
    public static void main(String[] args) {
        //test neighbour method
        int[][] tiles = new int[3][3];
        tiles[0][0] = 0;
        tiles[0][1] = 1;
        tiles[0][2] = 3;
        tiles[1][0] = 4;
        tiles[1][1] = 2;
        tiles[1][2] = 5;
        tiles[2][0] = 7;
        tiles[2][1] = 8;
        tiles[2][2] = 6;
        Board b = new Board(tiles);
        Iterator<Board> it = b.neighbors().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //test getIndex
        //System.out.println(b.getIndex(2, 2));

        //test twin
        /*System.out.println(b);
        Board b1 = b.twin();
        System.out.println(b1);
        System.out.println(b.equals(b1));
        System.out.println(b1.equals(b));*/
    }
}