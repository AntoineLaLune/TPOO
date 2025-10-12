public class Movie extends Media {

    // Attributs
    protected String genre;
    protected String director;
    protected String producer;

    // Constructeur
    public Movie(String title, int year, double duration, String genre, String director, String producer) {
        super(title, year, duration);
        this.genre = genre;
        this.director = director;
        this.producer = producer;
    }

    // Méthodes concrètes
    @Override
    public void play() {
        System.out.println("Play: " + this.title);
    }
    @Override
    public void pause() {
        System.out.println("Pause: " + this.title);
    }
    @Override
    public String getMediaType() {
        return "Movie";
    }
    @Override
    public double getFileSize() {
        return (this.getDuration() / 60 * 10);
    }

    public void showCredits() {
        System.out.println("Credits:");
        System.out.println("    " + this.director + " - Director");
        System.out.println("    " + this.producer + " - Producer");
    }
}