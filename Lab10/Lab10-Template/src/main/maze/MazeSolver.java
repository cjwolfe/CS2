package maze;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * MazeSolver is a backtracking version of MazeGame.
 * 
 * @author Mitch Parry
 * @author Willow Sapphire
 * @version 11/02/2023
 */
public class MazeSolver
{
    private boolean[][] visited;
    /**
     * The height of game maps.
     */
    private final static int HEIGHT = 99;

    /**
     * The width of game maps.
     */
    private final static int WIDTH = 99;

    /**
     * The game map, as a 2D array of booleans.
     * True indicates the spot is blocked.
     */
    private boolean[][] wall;

    /**
     * Constructor sets up the maps and the path list.
     * 
     * @param mazeFile name of the file containing the map.
     */
    public MazeSolver(String mazeFile)
    {
        wall = new boolean[HEIGHT][WIDTH];
        visited = new boolean[HEIGHT][WIDTH];
        loadMaze(mazeFile);
    }

    /**
     * Loads the data from the maze file and creates the map
     * 2D array.
     *  
     * @param mazeFile the input maze file.
     */
    private void loadMaze(String mazeFile)
    {
        wall = new boolean[HEIGHT][WIDTH];
        Scanner mazeScanner;
        try
        {
            mazeScanner = new Scanner(new FileReader(mazeFile));
            for (int i = 0; i < HEIGHT; i++)
            {
                for (int j = 0; j < WIDTH; j++)
                {
                    if (mazeScanner.next().equals("1"))
                    {
                        wall[i][j] = true;
                    }
                }
            }
            mazeScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + mazeFile);
        }
    }

    /**
     * Prints the map.
     */
    public void printMap()
    {
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                if (wall[i][j])
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public String findSolution(){
        String result = backtrack(0, 0, "");
        return result;
    }

    private String backtrack(int row, int col, String path) {
        // Base case: Check if we've reached the goal
        if (row == HEIGHT - 1 && col == WIDTH - 1) {
            return path;
        }

        // Mark the current cell as visited
        visited[row][col] = true;

        // Try moving in each direction: down, up, right, left
        if (isValidMove(row + 1, col)) { // Down
            String result = backtrack(row + 1, col, path + "down ");
            if (result != null) return result;
        }
        if (isValidMove(row - 1, col)) { // Up
            String result = backtrack(row - 1, col, path + "up ");
            if (result != null) return result;
        }
        if (isValidMove(row, col + 1)) { // Right
            String result = backtrack(row, col + 1, path + "right ");
            if (result != null) return result;
        }
        if (isValidMove(row, col - 1)) { // Left
            String result = backtrack(row, col - 1, path + "left ");
            if (result != null) return result;
        }

        // Backtrack: Unmark this cell before returning
        visited[row][col] = false;

        return null; // No solution found from this position
    }
    



    /**
     * Checks if a position is valid and not visited yet.
     * 
     * @param row the row index of the position.
     * @param col the column index of the position.
     * @param visited a 2D array indicating the visited positions.
     * @return true if the position is valid and not visited, false otherwise.
     */
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < HEIGHT && col >= 0 && col < WIDTH
                && !wall[row][col] && !visited[row][col];
    }
}

