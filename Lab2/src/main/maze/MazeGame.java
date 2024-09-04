package main.maze;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Javadoc buuuuuulllllllllshit.
 * 
 * @author cwolfe
 * @version 2024 08 29
 */

public class MazeGame {
    public static final int HEIGHT = 19;
    public static final int WIDTH = 39;
    private static final int ROW = 0;
    private static final int COL = 1;

    private Scanner playerInput;
    private boolean[][] blocked;
    private boolean[][] visited;
    private int[] player;
    private int[] goal;
    private int[] start;

    public static void main(String[] args) {
        // System.out.println("Nothing is working");
    }

    public MazeGame(String mazeFile) {
        this.playerInput = new Scanner(System.in);

        loadMaze(mazeFile);

    }

    public MazeGame(String mazeFile, Scanner playerInput) {
        this.playerInput = new Scanner(System.in);
        loadMaze(mazeFile);
    }

    public void playGame() {
        while (!playerAtGoal()) {
            prompt();
            String input = playerInput.nextLine();
            if (makeMove(input)) {
                break;
            }
        }

        if (playerAtGoal()) {
            System.out.println("You Won!");
        } else {
            System.out.println("Goodbye!");
        }
    }

    public void printMaze() {
        System.out.println("***********************************************");
        for (int i = 0; i < HEIGHT; i++) {
            System.out.print("|");
            for (int j = 0; j < WIDTH; j++) {
                if (player[ROW] == i && player[COL] == j) {
                    System.out.print("@");
                } else if (start[ROW] == i && start[COL] == j) {
                    System.out.print("S");
                } else if (goal[ROW] == i && goal[COL] == j) {
                    System.out.print("G");
                } else if (visited[i][j]) {
                    System.out.print(".");
                } else if (blocked[i][j]) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("***********************************************");
    }

    public int getPlayerRow() {
        return this.player[ROW];
    }

    public int getPlayerCol() {
        return this.player[COL];
    }

    public int getGoalRow() {
        return this.goal[ROW];
    }

    public int getGoalCol() {
        return this.goal[COL];
    }

    public int getStartRow() {
        return this.start[ROW];
    }

    public int getStartCol() {
        return this.start[COL];
    }

    public boolean[][] getBlocked() {
        boolean[][] copy = new boolean[blocked.length][blocked[0].length];
        for (int i = 0; i < blocked.length; i++) {
            for (int j = 0; j < blocked[0].length; j++) {
                copy[i][j] = blocked[i][j];
            }
        }
        return copy;
    }

    public boolean[][] getVisited() {
        boolean[][] copy = new boolean[visited.length][visited[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                copy[i][j] = visited[i][j];
            }
        }
        return copy;
    }

    public Scanner getPlayerInput() {
        return null;
    }

    public void setPlayerRow(int row) {
        this.player[ROW] = row;
    }

    public void setPlayerCol(int col) {
        this.player[COL] = col;
    }

    public void setGoalRow(int row) {
        this.goal[ROW] = row;
    }

    public void setGoalCol(int col) {
        this.goal[COL] = col;
    }

    public void setStartRow(int row) {
        this.start[ROW] = row;
    }

    public void setStartCol(int col) {
        this.start[COL] = col;
    }

    public void setBlocked(boolean[][] blocked) {

    }

    public void setVisited(boolean[][] visited) {

    }

    public void setPlayerInput(Scanner playerInput) {

    }

    private boolean[][] copyTwoDimBoolArray(boolean[][] arrayToCopy) {
        return null;
    }

    private void prompt() {
        System.out.print("Enter your move (up, down, left, right, or q to quit): ");
        printMaze();
    }

    private boolean playerAtGoal() {
        return getPlayerRow() == getGoalRow() && getPlayerCol() == getGoalCol();
    }

    private boolean valid(int row, int col) {
        if (row < 0 || row >= HEIGHT || col < 0 || col >= WIDTH || blocked[row][col]) {
            return false;
        }
        return true;
    }

    private void visit(int row, int col) {
        visited[row][col] = true;
    }

    private void loadMaze(String mazeFile) {
        try {
            Scanner file = new Scanner(new File(mazeFile));
            blocked = new boolean[HEIGHT][WIDTH];
            visited = new boolean[HEIGHT][WIDTH];
            for (int i = 0; i < HEIGHT; i++) {
                String line = file.nextLine();
                for (int j = 0; j < WIDTH; j++) {
                    blocked[i][j] = line.charAt(j) == 'X';
                    visited[i][j] = false;
                    if (line.charAt(j) == 'S') {
                        start = new int[] { i, j };
                        player = new int[] { i, j };
                    }
                    if (line.charAt(j) == 'G') {
                        goal = new int[] { i, j };
                    }
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading maze: " + e.getMessage());
        }

    }

    private boolean makeMove(String move) {
        String moveInput = move.toLowerCase().substring(0, 1);
        if (moveInput.equals("q")) {
            return true;
        } else if (moveInput.equals("l")) {
            if (valid(getPlayerRow(), getPlayerCol() - 1)) {
                setPlayerCol(getPlayerCol() - 1);
                visit(getPlayerRow(), getPlayerCol());
            }
        } else if (moveInput.equals("d")) {
            if (valid(getPlayerRow() + 1, getPlayerCol())) {
                setPlayerRow(getPlayerRow() + 1);
                visit(getPlayerRow(), getPlayerCol());
            }
        } else if (moveInput.equals("u")) {
            if (valid(getPlayerRow() - 1, getPlayerCol())) {
                setPlayerRow(getPlayerRow() - 1);
                visit(getPlayerRow(), getPlayerCol());
            }
        } else if (moveInput.equals("r")) {
            if (valid(getPlayerRow(), getPlayerCol() + 1)) {
                setPlayerCol(getPlayerCol() + 1);
                visit(getPlayerRow(), getPlayerCol());
            }
        }
        return playerAtGoal();
    }
}