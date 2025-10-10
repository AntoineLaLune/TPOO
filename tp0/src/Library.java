public class Library {
    String name;
    Book[] books;
    int bookCount;
    Library(String name){
        this.name = name;
        this.books = new Book[10];
    }
    void addBook(Book book){
        if (this.bookCount < 10) {
            this.books[this.bookCount] = book;
            this.bookCount ++;
        }
    }
    void displayAllBooks(){
        for (int i = 0; i < this.bookCount; i++) {
            this.books[i].displayInfo();
        }
    }
    void findBook(String title){

    }
    void countAvailableBooks(){

    }
}
