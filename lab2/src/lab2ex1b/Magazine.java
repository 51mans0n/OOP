package lab2ex1b;

public class Magazine extends LibraryItem {
    private String magazineNumber;
    private boolean soldedOut;
    public Magazine(String title, String author, int publicationYear, String magazineNumber) {
        super(title, author, publicationYear);
        this.magazineNumber = magazineNumber;
        this.soldedOut = false;
    }
    @Override
    public void soldOut() {
        if (this.soldedOut) {
            System.out.println(title + " magazine with issue " + magazineNumber + ", issue date " + publicationYear + " and author " + author + " was sold");
        }
        else {
            this.soldedOut = true;
            System.out.println("The magazine " + title + " with issue " + magazineNumber + ", issue date " + publicationYear + " and author " + author + " has not yet been sold out");
        }
    }
    @Override
    public void returnItem(LibraryItem libraryItem) {
        if(libraryItem instanceof Magazine){
            Magazine magazine = (Magazine) libraryItem;
            if (this.soldedOut) {
                System.out.println("Magazine " + magazine.title + " with number " + magazine.magazineNumber + " and author " + magazine.author + " has been sold out.");
            } else {
                System.out.println("Magazine " + magazine.title + " is not sold out.");
            }
        }
    }
    public String toString() {
        return "Magazine with title: " + title + ", author: " + author + ", publication year: " + publicationYear + " and number: " + magazineNumber;
    }
}
