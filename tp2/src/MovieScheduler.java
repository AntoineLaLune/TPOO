import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MovieScheduler {

    protected HashMap<String, Slot> MovieScheduler;

    public MovieScheduler() {
        this.MovieScheduler = new HashMap<String, Slot>();
    }

    void addMovie(String title, Slot slot) {
        if (title == null) {
            throw new IllegalArgumentException("Title is null");
        }
        if (slot == null) {
            throw new IllegalArgumentException("Slot is null");
        }
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title is empty");
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
    void removeMovie(String title) {
        this.MovieScheduler.remove(title);
    }
    Slot getMovieSlot(String title) {
        return this.MovieScheduler.get(title);
    }
    void updateMovieSlot(String title, Slot newSlot) {
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
    void display() {
        for (Map.Entry<String, Slot> entry : this.MovieScheduler.entrySet()) {
            System.out.println("For the " + entry.getKey() + " movie:");
            entry.getValue().display();
        }
    }
    void showStats() {
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

//        for (int i = 0; i < this.MovieScheduler.size(); i++) {
//            System.out.println("    " + this.MovieScheduler.values());
//        }

    }
    private void importMovie(String[] entre) {
        try {
            this.addMovie(entre[0], new Slot(entre[1], Long.parseLong(entre[2]), entre[3].charAt(6)));
        } catch (ParseException e) {
            throw new IllegalArgumentException (e + ": Erreur de formatage");
        }
    }
    public void importMovieSchedule(String[][] entre) {
        HashMap<String, Slot> backup = new HashMap<>(this.MovieScheduler);
        try {
            for (int i = 0; i < entre.length; i++) {
                this.importMovie(entre[i]);
            }
        } catch (IllegalArgumentException e) {
            this.MovieScheduler.clear();
            this.MovieScheduler.putAll(backup);
            throw new IllegalArgumentException (e + ": Erreur de formatage");
        }
    }

}
