package lab2ex1b;

public abstract class LibraryItem {
    protected String title;
    protected String author;
    protected int publicationYear;
    public LibraryItem(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
    public abstract void soldOut();
    public abstract void returnItem(LibraryItem libraryItem);
}
