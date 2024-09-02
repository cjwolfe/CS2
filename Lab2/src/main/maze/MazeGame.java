package main.maze;

import java.util.Scanner;

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
        System.out.println("Nothing is working");
    }

    public MazeGame(String mazeFile) {
        this.playerInput = new Scanner(System.in);
        // try {
        // loadMaze(mazeFile);
        // } catch (FileNotFoundException e) {
        // System.out.println("Error loading maze: " + e.getMessage());
        // }

    }

    public MazeGame(String mazeFile, Scanner playerInput) {
        this.playerInput = new Scanner(System.in);
    }

    public void playGame() {

    }

    public void printMaze() {

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
        return null;
    }

    public boolean[][] getVisited() {
        return null;
    }

    public Scanner getPlayerInput() {
        return null;
    }

    public void setPlayerRow(int row) {
        // this.player(ROW) = row;
    }

    public void setPlayerCol(int col) {

    }

    public void setGoalRow(int row) {

    }

    public void setGoalCol(int col) {

    }

    public void setStartRow(int row) {

    }

    public void setStartCol(int col) {

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

    }

    private boolean playerAtGoal() {
        return true;
    }

    private boolean valid(int row, int col) {
        return true;
    }

    private void visit(int row, int col) {

    }

    private void loadMaze(String mazeFile) {

    }

    private boolean makeMove(String move) {
        return true;
    }
}