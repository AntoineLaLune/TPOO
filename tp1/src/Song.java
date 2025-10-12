public class Song extends Media {

    // Attributs
    protected String album;
    protected String artist;

    // Constructeur
    public Song(String title, int year, double duration, String album, String artist) {
        super(title, year, duration);
        this.album = album;
        this.artist = artist;
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
        return "Music";
    }
    @Override
    public double getFileSize() {
        return (this.getDuration() / 60 * 4);
    }

    public void showLyrics() {
        System.out.println("Displaying lyrics for " + this.title);
    }
}