public class Book {
    String title;
    String author;
    int pages;
    boolean isBorrowed;
    Book(String title, String author, int pages, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isBorrowed = isBorrowed;
    }
    void borrow(){
        if (!this.isBorrowed) {
            this.isBorrowed = true;
            System.out.println("Le livre est emprunté");
        }
    }
    void returnBook(){
        if (this.isBorrowed) {
            this.isBorrowed = false;
            System.out.println("Le livre n'est pas emprunté");
        }
    }
    void displayInfo(){
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Pages: " + this.pages);
        if (this.isBorrowed) {
            System.out.println("Status: Not Available");
        } else {
            System.out.println("Status: Available");
        }

    }
    String getTitle(){
        return this.title;
    }
    boolean isFree(){
        return !this.isBorrowed;
    }
}
