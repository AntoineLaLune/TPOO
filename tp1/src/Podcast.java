public class Podcast extends Media {

    // Attributs
    protected String host;
    protected int episodeNumber;

    // Constructeur
    public Podcast(String title, int year, double duration, String host, int episodeNumber) {
        super(title, year, duration);
        this.host = host;
        this.episodeNumber = episodeNumber;
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
        return "Podcast";
    }
    @Override
    public double getFileSize() {
        return (this.getDuration() / 60 * 3);
    }

    public void subscribe() {
        System.out.println("Subscribed");
    }
}