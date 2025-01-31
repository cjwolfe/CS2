
import java.util.Random;


/**
 * Class TwoDArraysHomework is the first homework assignment,
 * to give you practice writing methods to process & use
 * 2 dimensional arrays.
 *
 * @author Val Lapensée-Rankine
 * @author cwolfe
 * @version 2025 01 31
 */
public class TwoDArraysHomework
{
    /**
     * The main method.
     * 
     * This method is were you should call your 2D array
     * methods to test them. I have provided an example of
     * how to test the showMap() method, and what it should
     * print.
     * 
     * I would highly recommend that you use the main method
     * to run and test the other array methods that you write
     * as well. It is always good practice to test all code
     * you write.
     * 
     * I will not be grading the main method, only the 4 other
     * methods.
     * 
     * @param args unused command-line parameter
     */
    public static void main(String[] args)
    {
        boolean[][] boolArr = {{true, false, true},
                {false, true, true},
                {false, false, true}};
        /*
         * This method call should print:
         * X X
         *  XX
         *   X
         */
        showMap(boolArr);
        System.out.println("Next");
        showMap(createMines());
        
        // You should test the rest of your methods below here.
    }

    /**
     * showMap method.
     * 
     * Write a void method, showMap, that takes a 2-dimensional
     * array of boolean as a parameter and prints the array in
     * the following tabular format: if the corresponding entry
     * is true, then an ‘X’ is printed, otherwise a space (' ')
     * is printed.
     * 
     * @param map the map that is provided to determine true/false for each corresponding location.
     */
    public static void showMap(boolean[][] map)
    {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++){
                if (map[i][j] == true){
                System.out.print("X");
                }
                else{
                System.out.print(" ");
                }
                
            }
            System.out.print("\n");
        }
    }
    
    /**
     * createMines method.
     * 
     * Write a method createMines that creates and returns a
     * 10x10 array of boolean. Set 10 random entries in the
     * table to true. The rest of the entries should be false.
     * Make sure that your code ONLY and EXACTLY sets 10
     * entries to true.
     * 
     * @return returns a 10x10 array with 10 random mines
     */
    public static boolean[][] createMines()
    {

        boolean[][] mines = new boolean[10][10];

        int count = 0;
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
        
                Random random = new Random();
                int randomNumber = random.nextInt(10);
                
                if(randomNumber == 0){
                    mines[i][j] = true;
                    count++;
                    if (count >11){
                    break;
                    }
                }   else {
                    mines[i][j] = false;
                }
            }
        }
        return mines;
    }
    
    /**
     * findAverages method.
     * 
     * Write a method, findAverages, which takes a 2-dimensional
     * array of double as a parameter and returns a
     * 1-dimensional array of double containing the averages of
     * each row of the 2-dimensional array.
     * 
     * @param list the input list that will be averaged
     * @return a one dimensional array which contains the averages of each row.
     */
    public static double[] findAverages(double[][] list)
    {
        
        double averages[] = new double[list.length];
        for (int i = 0; i < list.length; i++){
            double sum = 0;
            for (int j = 0; j < list.length; j++){
                sum+= list[i][j];
            }
            averages[i] = sum/ list[i].length;
        }
        return averages;
    }
    
    /**
     * noDuplicate method.
     * 
     * Write a boolean method, noDuplicate, which takes a
     * 2-dimensional array of int as a parameter and returns
     * true if there are no two entries in the array that are
     * the same and false otherwise.
     * 
     * @param array the input array
     * @return true if no two entries are the same, false otherwise
     */
    public static boolean noDuplicates(int[][] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int current = array[i][j];
                for (int k = 0; k < array.length; k++) {
                    for (int l = 0; l < array[k].length; l++) {
                        if (i == k && j == l) {
                            continue; // Skip the same element
                        }
                        if (current == array[k][l]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}