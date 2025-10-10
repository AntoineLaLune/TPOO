import java.lang.reflect.Array;

public class MediaPlayer {

    private Media[] playlist;
    private int currentIndex;
    private int mediaCount;

    public MediaPlayer(int capacity) {
        this.playlist = new Media[capacity];
    }

    public void addMedia(Media media) {
        this.playlist[this.mediaCount] = media;
        this.mediaCount ++;
    }

    public void playAll() {
        for (int i = 0; i < this.mediaCount; i++) {
            this.playlist[i].play();
        }
    }

    public void displayPlaylist() {
        for (int i = 0; i < this.mediaCount; i++) {
            this.playlist[i].displayInfo();
        }
    }

    public double getTotalSize() {
        double size = 0.0;
        for (int i = 0; i < this.mediaCount; i++) {
            size = size + this.playlist[i].getFileSize();
        }
        System.out.println(size);
        return size;
    }

    public Media[] getMediaByType(String type) {
        Media[] playlist_short = new Media[this.mediaCount];
        for (int i = 0; i < this.mediaCount; i++) {
            if (this.playlist[i].getMediaType().equalsIgnoreCase(type)) {
                playlist_short[i] = this.playlist[i];
                System.out.println(this.playlist[i].title);
            }
        }
        return playlist_short;
    }

    public Media[] getRecentMedia(int year) {
        Media[] playlist_short = new Media[this.mediaCount];
        for (int i = 0; i < this.mediaCount; i++) {
            if (this.playlist[i].year > year) {
                playlist_short[i] = this.playlist[i];
                System.out.println(this.playlist[i].title);
            }
        }
        return playlist_short;
    }

    public Media[] getLargeMedia(double sizeLimit) {
        Media[] playlist_short = new Media[this.mediaCount];
        for (int i = 0; i < this.mediaCount; i++) {
            if (this.playlist[i].getFileSize() > sizeLimit) {
                playlist_short[i] = this.playlist[i];
                System.out.println(this.playlist[i].title);
            }
        }
        return playlist_short;
    }

    public double getTotalDuration() {
        double total = 0;
        for (int i = 0; i < this.mediaCount; i++) {
            total = total + this.playlist[i].duration;
        }
        System.out.println(total);
        return total;
    }

}