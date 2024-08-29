public class Temp {
    public static void main(String[] args) {
        int[][] table = { { 0, 1, -2, 3, -10 },
                { -1, 3, 4, 8 } };
        int pos = countPositives(table);
        System.out.println(pos);
    }

    /**
     * Write an int method called countPositives that takes as an input parameter
     * a 2-dimensional array of int and returns the count of all the positive
     * integers (those>0) in the array
     * 
     */
    public static void nestedForLoops(int[][] table) {

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {

            }
        }

    }

    public static int countPositives(int[][] table) {
        int count = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {

            }
        }
        return count;
    }

    public static void printWithAverage(int[][] table) {
        @SuppressWarnings("unused")
        double sum = 0;
        @SuppressWarnings("unused")
        int count = 0;

        System.out.print("Cols:\t");
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {

            }
        }

    }

    // prompts

    /**
     * Write an int method, findLargestRow, which takes as input a 2-dimensional
     * array of
     * double and returns the index of the row that has the largest sum
     */

    /**
     * Write a method that prints a 2-dimensional array of integers
     * as a table. at the end of each row, also print the average of
     * the row. put a couple of extra spaces before the average and
     * 
     */

    /**
     * Write an int method, productDiagonal, which has a square
     * 2-dimensional array of integers as a parameter and returns
     * the product of the main diagonal. the main diagonal refers
     * to the entries where row == column. Can you solve this with a single for
     * loop?
     */

    public static int productDiagonal(int[][] table) {
        int product = 1;

        for (int i = 0; i < table.length; i++) {
            product *= table[i][i];
        }
        return product;
    }

}
