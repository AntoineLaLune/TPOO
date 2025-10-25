import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        // Exercice 1.4
        try {
            Task task = new Task("", "Description", Priority.HIGH); // Titre vide !
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        TaskManager tasks = new TaskManager();
        String[] task = {"title", "description", "LOW"};
        System.out.println(tasks.importTask(task));

        // Exercice 1.5
        System.out.println("=== Test données valides ===");
        tasks.importTasks(TaskTestData.getValidTasks());
        System.out.println("=== Test données problématiques ===");
        tasks.importTasks(TaskTestData.getProblematicTasks());
        System.out.println("=== Test grande liste ===");
        tasks.importTasks(TaskTestData.getLargeTaskSet());

        Slot slot = new Slot("8h30",120,2);
        Slot slot2 = new Slot("8h30",120,3);
        Slot slot3 = new Slot("12h30",120,2);
        Slot slot4 = new Slot("12h30",120,3);
        Slot slot5 = new Slot("12h30",120,1);
        Slot slot6 = new Slot("8h30",120,1);
        Slot slot7 = new Slot("12h30",120,4);


        MovieScheduler m = new MovieScheduler();
        m.addMovie("up", slot);
        m.addMovie("titanic", slot2);
        m.addMovie("avatar", slot3);
        m.addMovie("portal 3", slot4);
        m.addMovie("m&s", slot5);
        m.showStats();

        m.MovieScheduler.clear();
        m.importMovieSchedule(MovieSlotTestData.getValidMovieSchedule());

//        m.MovieScheduler.clear();
//        m.importMovieSchedule(MovieSlotTestData.getProblematicMovieSchedule());
//
//        m.MovieScheduler.clear();
//        m.importMovieSchedule(MovieSlotTestData.getDuplicateMovieSchedule());
//
//        m.MovieScheduler.clear();
//        m.importMovieSchedule(MovieSlotTestData.getConflictingSchedule());
//
//        m.MovieScheduler.clear();
//        m.importMovieSchedule(MovieSlotTestData.getInvalidMovieSchedule());
//
//        m.MovieScheduler.clear();
//        m.importMovieSchedule(MovieSlotTestData.getLargeMovieSchedule());

    }
}