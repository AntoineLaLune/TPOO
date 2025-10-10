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
    void borrow(boolean isBorrowed){
        isBorrowed = true;
        System.out.println("Le livre est emprunté");
    }
    void returnBook(boolean isBorrowed){
        isBorrowed = false;
       System.out.println("Le livre n'est pas emprunté");
    }
    void displayInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        if (isBorrowed) {
            System.out.println("Status: Not Available");
        } else {
            System.out.println("Status: Available");
        }

    }
    void getTitle(boolean isBorrowed){
        System.out.println("Title: " + title + "\n");
    }
    void isBorrowed(boolean isBorrowed){
        System.out.println("Status: " + isBorrowed + "\n");
    }
}
