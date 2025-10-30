import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MovieScheduler {

    protected HashMap<String, Slot> MovieScheduler;

    public MovieScheduler() {
        this.MovieScheduler = new HashMap<String, Slot>();
    }

    void addMovie(String title, Slot slot) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title can't be null or empty");
        }
        if (slot == null) {
            throw new IllegalArgumentException("Slot cannot be null");
        }
        if (this.MovieScheduler.containsKey(title)) {
            throw new IllegalArgumentException("Title already exist");
        }
        for (Map.Entry<String, Slot> entry : this.MovieScheduler.entrySet()) {
            if (slot.hasTimeConflict(entry.getValue())) {
                throw new IllegalArgumentException("Time conflict detected");
            }
        }
        this.MovieScheduler.put(title, slot);
    }
    public void removeMovie(String title) {
        this.MovieScheduler.remove(title);
    }
    public Slot getMovieSlot(String title) {
        return this.MovieScheduler.get(title);
    }
    public void updateMovieSlot(String title, Slot newSlot) {
        // this.MovieScheduler.replace(title, this.getMovieSlot(title), newSlot); // Has no hasTimeConflict
        if (newSlot == null) {
             throw new IllegalArgumentException("Slot is null");
        }
        if (this.MovieScheduler.containsKey(title)) {
            Slot backup = this.MovieScheduler.get(title);
            this.removeMovie(title);
            for (Map.Entry<String, Slot> entry : this.MovieScheduler.entrySet()) {
                if (newSlot.hasTimeConflict(entry.getValue())) {
                    this.MovieScheduler.put(title, backup);
                    throw new IllegalArgumentException("Time conflict detected\nNo change apply");
                } else {
                    this.MovieScheduler.put(title, newSlot);
                }
            }
        } else {
        System.out.println(title + " do not exist");
        }
    }
    public void display() {
        for (Map.Entry<String, Slot> entry : this.MovieScheduler.entrySet()) {
            System.out.println("For the " + entry.getKey() + " movie:");
            entry.getValue().display();
        }
    }
    public void showStats() {
        System.out.println("Number of films: " + this.MovieScheduler.size());
        double duration = 0;
        for (Map.Entry<String, Slot> entry : this.MovieScheduler.entrySet()) {
            duration = duration + entry.getValue().getDuration();
        }
        System.out.println("Total duration: " + duration);
        System.out.println("Films by rooms:");
        int number_of_room = 0;
        for (Map.Entry<String, Slot> entry : this.MovieScheduler.entrySet()) {
            if (entry.getValue().room > number_of_room) {
                number_of_room = entry.getValue().room;
            }
        }
        ArrayList<String>[] ram = new ArrayList[number_of_room];
        for (int i = 0; i < ram.length; i++) {
            ram[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Slot> entry : this.MovieScheduler.entrySet()) {
            ram[entry.getValue().room - 1].add(entry.getKey());
        }
        for (int i = 0; i < number_of_room; i++) {
            System.out.println("    " + (i+1) + ram[i].toString());
        }

    }
    private void importMovie(String[] movie) {
        try {
            this.addMovie(movie[0], new Slot(movie[1], movie[2], movie[3]));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public void importMovieSchedule(String[][] movies) {
        HashMap<String, Slot> backup = new HashMap<>(this.MovieScheduler);
        try {
            for (int i = 0; i < movies.length; i++) {
                this.importMovie(movies[i]);
            }
        } catch (IllegalArgumentException e) {
            this.MovieScheduler.clear();
            this.MovieScheduler.putAll(backup);
            throw new IllegalArgumentException (e + ": Erreur de formatage");
        }
    }

}
