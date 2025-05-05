

/**
 *
 * @author chris (actually svrankine for printtable)
 */
public class printTable {

    public static void PrintTableAverages(int[][] table){
        for(int k = 0; k < table[0].length; k++){
            System.out.print("\tCol " + k);
        }
        System.out.println("\tAVERAGE");

        for(int i = 0; i < table.length; i++){
            System.out.print("Row " + i);
            int sum = 0;
            for(int j = 0; j < table[i].length; j++)
            {
                System.out.print("\t" + table[i][j]);
                sum += table[i][j];

            }
            System.out.println("\t" + ((double) sum / table[i].length));
        
        }
    }


    /** 
     * Write an int method, findLargestRow, which takes as input a 
     * 2-dimensional array of double and returns the index of the
     * row that has the largest sum.
     * 
    */

    public static double findLargestRow(double[][] table){
        double largest = 0;
        double largestSum = Double.MIN_VALUE;
        for(int i = 0; i < table[i].length; i++){
            double sum = 0;
            for(int j = 0; j< table[j].length; j++){
                sum+=table[i][j];
            }
            if(largestSum > sum){
                largestSum = sum;
                largest = i;
            }
            

        
        }
        return largest;    
    }

    /**
     * Write an int method, productDiagonal, which has a square
     * 2-dimensional array of integers as a parameter and returns the product of
     * the main diagonal.
     * the main diagonal refers to the entries where row == column.
     * When you declare the variable that you will use for the product,
     * initialize it to 1, not 0. Can you solve this with a single for loop?
     * 
     * @param table
     * @return
     */

    public static int productDiagonal(int[][] table){
        int product = 1;
        for ( int i = 0; i < table.length; i++){
            product *= table[i][i];

        }

        return product;
                    }
        
        /**
         * Write a method, countIsolatedZeroes, which takes a
         * 2-dimensional integer array as a parameter and
         * returns the number of zeros that have no neighbors
         * (above, below, left. or right) that are also zeros.
        */

        





}
