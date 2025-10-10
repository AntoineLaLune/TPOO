import org.w3c.dom.ls.LSOutput;

import java.util.SplittableRandom;

public class Podcast extends Media {

    String host;
    int episodeNumber;
    // Taille de fichier différente
    // Méthode subscribe()

    public Podcast(String title, int year, double duration, String host, int episodeNumber) {
        super(title, year, duration);
        this.host = host;
        this.episodeNumber = episodeNumber;
    }

    @Override
    public void play() {
        System.out.println("Play: " + this.title);
    }

    public void pause() {
        System.out.println("Pause: " + this.title);
    }

    public String getMediaType() {
        return "Podcast";
    }

    public double getFileSize() {
        return 30.0;
    }

    public void showCredits() {
        System.out.println("Credits");
    }

    public void subscribe() {
        System.out.println("Abonné");
    }

}