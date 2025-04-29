
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;





public class Matrices{

    static int[][] matrix = new int[12][2];
    static int[][] modifier = {
            {0,1},
            {1,0}
        };


    public void readMatrix(){
        Scanner fileInput = null;
        try{
            fileInput = new Scanner(new FileReader("points.txt"));
        } catch(FileNotFoundException e){
        }
    
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (fileInput.hasNextInt()) {
                    matrix[i][j] = fileInput.nextInt();
                }
            }
        }
        fileInput.close();
    }
    
    public void matrixMath(){

        


    }
    
    public void printMatrix(int[][] matrix){

        // System.out.print("[");


        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            if(i == (((matrix.length)/2)-1)){
                System.out.print("\n");
            }
                // System.out.println("");
        }
        // System.out.print("]");


    }

    // public static void printMatrix(int[][] matrix) {
    //     for (int[] column : matrix) {
    //         System.out.println(Arrays.toString(column));
    //     }
    // }

    public int[][] modifyMatrix(int[][] matrix, int[][] modifier){
        int[][] result= new int[matrix.length][matrix[0].length];


        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                for (int[] row : modifier){
                    for (int value : row){
                        modifier[i][j] *= value;
                    }
                }
            }
        }
        return result;
    }

public static void main(String[] args) {
        System.out.println("asdf");
        Matrices matrices = new Matrices();
        matrices.readMatrix();
        matrices.printMatrix(matrix);
        System.out.println("\nnew matrix");
        //System.out.print("\nmodifier length: " + modifier.length + "\n");
        matrices.printMatrix(matrices.modifyMatrix(matrix, modifier));

    }
}