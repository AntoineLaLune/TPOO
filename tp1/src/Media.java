import java.time.Year;

public abstract class Media {

    // Attributs protégés
    protected String title;
    protected int year;
    protected double duration; // en minutes

    // Constructeur
    public Media(String title, int year, double duration) {
        this.title = title;
        this.year = year;
        this.duration = duration;
    }

    // Méthodes concrètes
    public void displayInfo() {
        System.out.println(this.title);
        System.out.println(this.year);
        System.out.println(this.duration);
    }
    public int getAge() {
        return Year.now().getValue() - year;
    }

    // Méthodes abstraites
    public abstract void play();
    public abstract void pause();
    public abstract String getMediaType();
    public abstract double getFileSize(); // en MB
}