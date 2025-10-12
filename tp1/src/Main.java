import javax.print.attribute.standard.Media;

public class Main {

    public static void main(String[] args) {

        // Heritage
        Item smartphone = new Item("iPhone", 800.0, 0.20);
        System.out.println(smartphone.getTotalPrice()); // 960.0
        smartphone.applyDiscount(10.0); // 10% de remise
        System.out.println(smartphone.getTotalPrice()); // 864.0

        // Polymorphisme
        MediaPlayer player = new MediaPlayer(10);
        Movie film = new Movie("titre", 2016, 110, "horreur", "quelqu'un", "une personne");
        Movie film2 = new Movie("titre2", 2017, 120, "horreur", "quelqu'un", "une personne");
        Song musique = new Song("titre", 2016, 3, "coolmusic", "quelqu'un");
        Song musique2 = new Song("titre2", 2017, 4, "coolmusic", "quelqu'un");
        Podcast podcast = new Podcast("titre", 2016, 30, "coolman", 1);
        Podcast podcast2 = new Podcast("titre2", 2017, 40, "coolman", 2);

        player.addMedia(film);
        player.addMedia(film2);
        player.addMedia(musique);
        player.addMedia(musique2);
        player.addMedia(podcast);
        player.addMedia(podcast2);
        player.getMediaByType("Podcast");
        player.getTotalSize();
        player.playAll();

    }// Parcours complet (clé + valeur)

}