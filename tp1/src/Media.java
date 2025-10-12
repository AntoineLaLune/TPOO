import java.time.Year;

public abstract class Media {

    // Attributs protégés
    protected String title;
    protected int year;
    protected double duration; // seconds

    // Constructeur
    public Media(String title, int year, double duration) {
        this.title = title;
        this.year = year;
        this.duration = duration;
    }

    // Méthodes concrètes
    public void displayInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Year: " + this.year);
        System.out.println("Duration: " + this.duration);
    }
    public int getAge() {
        return Year.now().getValue() - year;
    }

    // Getter
    public int getYear() {
        return this.year;
    }
    public double getDuration() {
        return this.duration;
    }

    // Méthodes abstraites
    public abstract void play();
    public abstract void pause();
    public abstract String getMediaType();
    public abstract double getFileSize(); // en MB
}