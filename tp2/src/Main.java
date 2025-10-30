import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        // Exercice 1.4
        try {
            Task task = new Task("", "Description", "HIGH"); // Titre vide !
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        try {
            TaskManager tasks = new TaskManager();
            String[] task = {"title", "description", "LOW"};
            System.out.println(tasks.importTask(task));
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        // Exercice 1.5
        try {
            System.out.println("=== Test données valides ===");
            TaskManager tasks = new TaskManager();
            tasks.importTasks(TaskTestData.getValidTasks());
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        try {
            System.out.println("=== Test données problématiques ===");
            TaskManager tasks = new TaskManager();
            tasks.importTasks(TaskTestData.getProblematicTasks());
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        try {
            System.out.println("=== Test grande liste ===");
            TaskManager tasks = new TaskManager();
            tasks.importTasks(TaskTestData.getLargeTaskSet());
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("=== mS ===");

        MovieScheduler mS = new MovieScheduler();

        Slot slot = new Slot("8h30","120","Salle 122");
        Slot slot2 = new Slot("8h30","120","Salle 3");
        Slot slot3 = new Slot("12h30","120","Salle 2");
        Slot slot4 = new Slot("12h30","120","Salle 3");
        Slot slot5 = new Slot("12h30","120","Salle 1");
        Slot slot6 = new Slot("8h30","120","Salle 1");
        Slot slot7 = new Slot("12h30","120","Salle 4");

        mS.addMovie("up", slot);
        mS.addMovie("titanic", slot2);
        mS.addMovie("avatar", slot3);
        mS.addMovie("portal 3", slot4);
        mS.addMovie("m&s", slot5);
        mS.showStats();

        mS.MovieScheduler.clear();
        mS.importMovieSchedule(MovieSlotTestData.getValidMovieSchedule());

//        mS.MovieScheduler.clear();
//        mS.importMovieSchedule(MovieSlotTestData.getProblematicMovieSchedule());

//        mS.MovieScheduler.clear();
//        mS.importMovieSchedule(MovieSlotTestData.getDuplicateMovieSchedule());

//        mS.MovieScheduler.clear();
//        mS.importMovieSchedule(MovieSlotTestData.getConflictingSchedule());

//        mS.MovieScheduler.clear();
//        mS.importMovieSchedule(MovieSlotTestData.getInvalidMovieSchedule());

        mS.MovieScheduler.clear();
        mS.importMovieSchedule(MovieSlotTestData.getLargeMovieSchedule());

    }
}