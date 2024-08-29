/**
 * Something
 * 
 * @param args
 */

public static void main(string[] args) {

    String[][] table = { { "a", "b", "c" },
            { "d", "e", "f" } };

    printTable(table); // dataType of table: String[][]

}

/**
 * printTable
 * 
 * Print the parameter table to the screen so that it looks like a neat table
 * with row and column headings.
 * 
 * Ex:
 * Cols: 0 1 2
 * Row 0: a b c
 * Row 1: d e f
 */
public static void printTable(String[][] table) {

    System.out.println("Cols:\t");
    for (int k = 0; k < table[0].length; k++) {
        System.out.print(k + "\t");
    }
    System.out.print("\n");

    for (int i = 0; i < table[0].length; i++) {
        System.out.print(i + "\t");
    }

    // for(
    // int i = 0;i<table.length;i++)

}
