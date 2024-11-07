package library;

import java.util.*;
import storage.SortedLinkedList;


public class BookReader {
    private Scanner fileIn;
    private SortedLinkedList<Book> books;

    public BookReader(String filename) {
        books = new SortedLinkedList<>();
        setFileIn(fileIn);
        readLines();
    }

    public void setFileIn(Scanner fileIn) {
            
                this.fileIn = fileIn;
            
        }

    public void readLines() {
        // Code to read the file line by line and construct Book objects
        // Code to print books with more than 300 pages
        for (Book book : books) {
            if (book.getNumPages() > 300) {
            System.out.println(book);
            }
        }
        // Code to print books with more than 300 pages
    }
    public SortedLinkedList<Book> getBooks() {
        return books;
    }

    public void printMoreThan300(){

    }

    public void removeLessThan200(){
    
    }


    public double averagePages() {
        double total = 0;
        int count = 0;
        for (Book book : books) {
            total += book.getNumPages();
            count++;
        }
        if (count == 0) {
            return 0;
        }
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getNumPages() < 200) {
                iterator.remove();
            }
        }
        // Code to remove books with less than 200 pages
        return total / count;
    }

    // @Override
    // public boolean hasNext() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
    // }

    // @Override
    // public Book next() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'next'");
    // }
}