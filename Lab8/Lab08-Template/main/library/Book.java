package library;

public class Book implements Comparable<Book> {
    private String author;
    private String title;
    private int numPages;

    public Book(String author, String title, int numPages) {
        this.author = author;
        this.title = title;
        this.numPages = numPages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getNumPages() {
        return numPages;
    }

    @Override
    public int compareTo(Book otherBook) {
        int authorComparison = author.compareTo(otherBook.author);
        if (authorComparison != 0) {
            return authorComparison;
        } else {
            return title.compareTo(otherBook.title);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book otherBook = (Book) obj;
        return author.equals(otherBook.author) && title.equals(otherBook.title);
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + numPages;
    }
}
