import java.io.*;

public class ForIfIfElseStudying {
    public static void main(String[] args) {
        

        // basic if statement
        int x = 2;
        if (x == 3) {
            System.out.println("X is 3.");
        }
        System.out.println(x);

        // basic if-else statement
        if (x == 3) 
        {
            System.out.println("X is 3.");
        } 
        else 
        {
        System.out.println("X is " + x + ".");
        }

        // basic for statement
        for(int i = 0; i < 4; i++)
        {
            System.out.println(i);
        }

        // advanced for loop

        int[] numbers = {0, 1, 2, 3};

        for (int num : numbers) 
        {
            System.out.println(num);
        }

        // nested for loop
        for (int i = 1; i <= 4; i++) 
        {
            for (int j = 1; j <= 4; j++) 
            {
                System.out.println("i: " + i + ", j: " + j);
            }
        }
        // nested for loop with 2D array
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("matrix[" + i + "][" + j + "]: " + matrix[i][j]);
            }
        }


        // do while loop
        int y = 0;
        do 
        {
            System.out.println("y: " + y);
            y++;
        } 
        while (y < 5);

        // try catch

        try {
            // Code that may throw a FileNotFoundException
            FileReader fileReader = new FileReader("path/to/file.txt");
            // do { 
            //     System.out.println(fileReader);
            // } while (true));
            // Rest of the code
        } catch (FileNotFoundException e) {
            // Code to handle the exception
            System.out.println("File not found.");
            //e.printStackTrace();
        }



    }
}