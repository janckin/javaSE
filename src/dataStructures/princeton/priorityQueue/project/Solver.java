package dataStructures.princeton.priorityQueue.project;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solver {
    private final int len;
    private final Iterator<Board> it;

    /**
     * find a solution to the initial board (using the A*algorithm)
     *
     * @param initial
     */
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        /** initial variable*/
        List<Board> list = new ArrayList<>();
        list.add(initial);

        /** find the minimum track of 8-puzzle */
        Board currentBoard = initial;
        while (!currentBoard.isGoal()) {
            Iterator<Board> it = currentBoard.neighbors().iterator();
            Board minBoard = currentBoard;
            while (it.hasNext()) {
                Board board = it.next();
                if (board.manhattan() < minBoard.manhattan()) {
                    minBoard = board;
                }
            }
            list.add(minBoard);
            currentBoard = minBoard;
        }
        len = list.size();
        it = list.iterator();
    }

    /**
     * is the initial board solvable?
     *
     * @return result
     */
    public boolean isSolvable() {
        return len != 1;
    }

    /**
     * min number of moves to solve initial board
     *
     * @return number
     */
    public int moves() {
        return len - 1;
    }

    /**
     * sequence of boards in a shortest solution
     *
     * @return
     */
    public Iterable<Board> solution() {
        return () -> {
            return it;
        };
    }

    //test client (see below)
    public static void main(String[] args) {


        //solve the puzzle
        Solver solver = new Solver(TestUnits.puzzle01());

        //test moves
        System.out.println(solver.moves());

        //print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }


        System.out.println(solver.moves());
    }

}
