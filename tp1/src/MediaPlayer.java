public class MediaPlayer {

    // Attributs privé
    private Media[] playlist;
    private int mediaCount;

    // Constructeur
    public MediaPlayer(int capacity) {
        this.playlist = new Media[capacity];
        this.mediaCount = 0;
    }

    public void addMedia(Media media) {
        if (this.mediaCount == this.playlist.length) {
            System.out.println(media + " could not be added to the playlist: full");
        } else {
            this.playlist[this.mediaCount] = media;
            this.mediaCount ++;
            System.out.println(media + " added to the playlist");
        }
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
        return size;
    }
    public Media[] getMediaByType(String type) {
        Media[] playlist_short = new Media[this.mediaCount];
        for (int i = 0; i < this.mediaCount; i++) {
            if (this.playlist[i].getMediaType().equalsIgnoreCase(type)) {
                playlist_short[i] = this.playlist[i];
            }
        }
        return playlist_short;
    }
    public Media[] getRecentMedia(int year) {
        Media[] playlist_short = new Media[this.mediaCount];
        for (int i = 0; i < this.mediaCount; i++) {
            if (this.playlist[i].getYear() > year) {
                playlist_short[i] = this.playlist[i];
            }
        }
        return playlist_short;
    }
    public Media[] getLargeMedia(double sizeLimit) {
        Media[] playlist_short = new Media[this.mediaCount];
        for (int i = 0; i < this.mediaCount; i++) {
            if (this.playlist[i].getFileSize() > sizeLimit) {
                playlist_short[i] = this.playlist[i];
            }
        }
        return playlist_short;
    }
    public double getTotalDuration() {
        double total = 0;
        for (int i = 0; i < this.mediaCount; i++) {
            total = total + this.playlist[i].getDuration();
        }
        return total;
    }
}