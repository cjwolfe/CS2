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

        for (Book book : books) {
            if (book.getNumPages() > 300) {
            System.out.println(book);
            }
        }

    }
    public SortedLinkedList<Book> getBooks() {
        return books;
    }

    public void printMoreThan300(){
        for (Book book : books) {
            if (book.getNumPages() > 300) {
                System.out.println(book);
            }
        }
    }

    public void removeLessThan200() {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getNumPages() < 200) {
                iterator.remove();
            }
        }
    }

    public double averagePages(){
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
        return total / count;
    }


}