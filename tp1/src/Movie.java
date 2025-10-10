public class Movie extends Media {

    String genre;
    String director;
    String producer;

    // Constructeur
    public Movie(String title, int year, double duration, String genre, String director, String producer) {
        super(title, year, duration);
        this.genre = genre;
        this.director = director;
        this.producer = producer;
    }

    @Override
    public void play() {
        System.out.println("Play: " + this.title);
    }

    public void pause() {
        System.out.println("Pause: " + this.title);
    }

    public String getMediaType() {
        return "Film";
    }

    public double getFileSize() {
        return 1000.0;
    }

    public void showCredits() {
        System.out.println("Credits");
    }

}