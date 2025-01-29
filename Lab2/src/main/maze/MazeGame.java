package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Javadoc buuuuuulllllllllshit.
 * 
 * @author cwolfe
 * @version 2024 08 29
 */


public class MazeGame 
{
    public final static int HEIGHT = 19;
    public final static int WIDTH = 39;
    private final static int ROW = 0;
    private final static int COL = 1;

    private Scanner playerInput;
    private boolean[][] blocked;
    private boolean[][] visited;
    private int[] player;
    private int[] goal;
    private int[] start;

    // public static void main(String[] args) 
    // {
    //     // System.out.println("Nothing is working");
    // }

    public MazeGame(String mazeFile) throws FileNotFoundException{
        //this.playerInput = playerInput;
        loadMaze(mazeFile);
    }

    public MazeGame(String mazeFile, Scanner playerInput) throws FileNotFoundException {
    
        this.playerInput = new Scanner(System.in);
        loadMaze(mazeFile);
    }

    public void playGame() {
        do {
            prompt();
        } while (!makeMove(playerInput.nextLine().trim()));
    }

    public void printMaze() {
        System.out.println("*".repeat(WIDTH + 2)); // Top border
    
        for (int r = 0; r < HEIGHT; r++) {
            System.out.print("|"); // Left border
            for (int c = 0; c < WIDTH; c++) {
                char displayChar = ' ';
                if (player[ROW] == r && player[COL] == c) {
                    displayChar = '@';
                } else if (goal[ROW] == r && goal[COL] == c) {
                    displayChar = 'G';
                } else if (start[ROW] == r && start[COL] == c) {
                    displayChar = 'S';
                } else if (visited[r][c]) {
                    displayChar = '.';
                } else if (blocked[r][c]) {
                    displayChar = 'X';
                }
                System.out.print(displayChar);
            }
            System.out.println("|"); // Right border
        }
    
        System.out.println("*".repeat(WIDTH + 2)); // Bottom border
    }

    public int getPlayerRow() 
    {
        return this.player[ROW];
    }

    public int getPlayerCol() 
    {
        return this.player[COL];
    }

    public int getGoalRow() 
    {
        return this.goal[ROW];
    }

    public int getGoalCol() 
    {
        return this.goal[COL];
    }

    public int getStartRow() 
    {
        return this.start[ROW];
    }

    public int getStartCol() 
    {
        return this.start[COL];
    }

    public boolean[][] getBlocked() 
    {
        boolean[][] copy = new boolean[blocked.length][blocked[0].length];
        for (int i = 0; i < blocked.length; i++) 
        {
            for (int j = 0; j < blocked[0].length; j++) 
            {
                copy[i][j] = blocked[i][j];
            }
        }
        return copy;
    }

    public boolean[][] getVisited() 
    {
        boolean[][] copy = new boolean[visited.length][visited[0].length];
        for (int i = 0; i < visited.length; i++) 
        {
            for (int j = 0; j < visited[0].length; j++) 
            {
                copy[i][j] = visited[i][j];
            }
        }
        return copy;
    }
    

    public Scanner getPlayerInput() 
    {
        return playerInput;
    }
/**
 * Sets/Gets player row
 * 
 * @param row
 * @return player row.
 */
    public void setPlayerRow(int row) 
    {
        this.player[ROW] = row;
    }
    /**
 * Sets/Gets
 * 
 * @param col
 * @return player col
 */

    public void setPlayerCol(int col) 
    {
        this.player[COL] = col;
    }
/**
 * Sets/Gets
 * 
 * @param row
 * @return goal row
 */
    public void setGoalRow(int row) 
    {
        this.goal[ROW] = row;
    }
/**
 * Sets/Gets
 * 
 * @param col
 * @return goal col
 */
    public void setGoalCol(int col) 
    {
        this.goal[COL] = col;
    }
/**
 * Sets/Gets
 * 
 * @param row
 * @return start row
 */
    public void setStartRow(int row) 
    {
        this.start[ROW] = row;
    }
/**
 * Sets/Gets
 * 
 * @param col
 * @return start col
 */
    public void setStartCol(int col) 
    {
        this.start[COL] = col;
    }
/**
 * Sets/Gets
 * 
 * @param blocked
 * 
 */
    public void setBlocked(boolean[][] blocked) 
    {
        this.blocked = copyTwoDimBoolArray(blocked);
    }
/**
 * Sets/Gets
 * 
 * @param visited
 * 
 */
    public void setVisited(boolean[][] visited) 
    {
        this.visited = copyTwoDimBoolArray(visited);
    }
/**
 * Sets/Gets
 * 
 * @param playerInput
 * 
 */
    public void setPlayerInput(Scanner playerInput) 
    {
        this.playerInput = playerInput;
    }
/**
 * copyTwoDimBoolArray
 * 
 * @param arrayToCopy
 * @return utility copy array
 */
private boolean[][] copyTwoDimBoolArray(boolean[][] arrayToCopy) {
    boolean[][] copy = new boolean[arrayToCopy.length][];
    for (int i = 0; i < arrayToCopy.length; i++) {
        copy[i] = java.util.Arrays.copyOf(arrayToCopy[i], arrayToCopy[i].length);
    }
    return copy;
}
/**
 * prompt
 * 
 * prompts user
 */
    private void prompt() 
    {
        printMaze();
        System.out.print("Enter your move (up, down, left, right, or q to quit): ");

    }
    /**
 * playeratGoal
 * 
 * 
 * @return True if player at goal, false otherwise.
 */
private boolean playerAtGoal() {
    return player[ROW] == goal[ROW] && player[COL] == goal[COL];
}

private boolean valid(int row, int col) {
    return row >= 0 && row < HEIGHT && col >= 0 && col < WIDTH && !blocked[row][col];
}
    /**
 * Visited
 * 
 * @param row
 * @param col
 * @return visited True if , false otherwise.
 */
private void visit(int row, int col) {
    visited[row][col] = true;
}

private void loadMaze(String mazeFile) throws FileNotFoundException {
    blocked = new boolean[HEIGHT][WIDTH];
    visited = new boolean[HEIGHT][WIDTH];
    player = new int[]{0, 0}; // Ensure initialization
    goal = new int[]{0, 0};
    start = new int[]{0, 0};
    
    Scanner fileScanner = new Scanner(new File(mazeFile));
    for (int r = 0; r < HEIGHT; r++) {
        String line = fileScanner.next();
        for (int c = 0; c < WIDTH; c++) {
            char ch = line.charAt(c);
            switch (ch) {
                case '1': blocked[r][c] = true; break;
                case '0': blocked[r][c] = false; break;
                case 'S': 
                    start[ROW] = player[ROW] = r;
                    start[COL] = player[COL] = c; 
                    break;
                case 'G': 
                    goal[ROW] = r;
                    goal[COL] = c; 
                    break;
            }
        }
    }
    fileScanner.close();
}
    
/**
 * Makes a move in the maze game based on the given input.
 * 
 * @param move The move input provided by the player.
 * @return True if true, false if otherwise
 */
private boolean makeMove(String move) {
    String moveInput = move.toLowerCase().substring(0, 1);

    int newRow = getPlayerRow();
    int newCol = getPlayerCol();

    switch (moveInput) {
        case "q":
            return true;
        case "l":
            newCol--;
            break;
        case "r":
            newCol++;
            break;
        case "u":
            newRow--;
            break;
        case "d":
            newRow++;
            break;
        default:
            System.out.println("Invalid move! Use: up, down, left, right, or q to quit.");
            return false; // Continue the game
    }

    if (valid(newRow, newCol)) {
        setPlayerRow(newRow);
        setPlayerCol(newCol);
        visit(newRow, newCol);
    } else {
        System.out.println("Move blocked! Try a different direction.");
    }

    return playerAtGoal();
}
}