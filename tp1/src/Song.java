public class Song extends Media {

    protected String album;
    protected String artist;

    // Constructeur
    public Song(String title, int year, double duration, String album, String artist) {
        super(title, year, duration);
        this.album = album;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Play: " + this.title);
    }

    public void pause() {
        System.out.println("Pause: " + this.title);
    }

    public String getMediaType() {
        return "Music";
    }

    public double getFileSize() {
        return (this.getDuration() / 60 * 4);
    }

    public void showLyrics() {
        System.out.println("Displaying lyrics for " + this.title);
    }


}