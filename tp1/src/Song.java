public class Song extends Media {

    String album;
    String artist;

    // Constructeur
    public Song(String title, int year, double duration, String album, String artist) {
        super(title, year, duration);
        this.album = album;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Joue: " + this.title);
    }

    public void pause() {
        System.out.println("Pause: " + this.title);
    }

    public String getMediaType() {
        return "Musique";
    }

    public double getFileSize() {
        return 10.0;
    }

    public void showCredits() {
        System.out.println("Credits");
    }

    public void showLyrics() {
        System.out.println("Displaying lyrics for " + this.title);
    }


}