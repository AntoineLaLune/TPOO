public class Main {
    public static void main(String[] args) {
        Book Book1 = new Book("Une course", "Nori", 380, true);
        Book Book2 = new Book("La course", "Niri", 360, false);
        Book Book3 = new Book("Course", "Noro", 400, true);
        Book Book4 = new Book("Imposteur", "Non", 0, true);
        Book1.displayInfo();
        Library Library1 = new Library("LGL");
        Library1.addBook(Book1);
        Library1.addBook(Book2);
        Library1.addBook(Book3);
        Library1.addBook(Book1);
        Library1.addBook(Book2);
        Library1.addBook(Book3);
        Library1.addBook(Book1);
        Library1.addBook(Book2);
        Library1.addBook(Book3);
        Library1.addBook(Book1);
        Library1.displayAllBooks();
    }
}