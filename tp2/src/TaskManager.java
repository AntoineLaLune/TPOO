import java.util.ArrayList;

public class TaskManager {

    // Attributs protégés
    protected ArrayList<Task> tasks;

    // Constructeur
    public TaskManager() {
        this.tasks = new ArrayList<Task>();
    }

    // Getter
    public ArrayList<Task> getTasksByPriority(Priority priority) {
        ArrayList<Task> res = new ArrayList<Task>();
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).priority.equals(priority)) {
                res.add(this.tasks.get(i));
            }
        }
        return res;
    }
    public ArrayList<Task> getTasksByTitle(String title) {
        ArrayList<Task> res = new ArrayList<Task>();
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).title.equals(title)) {
                res.add(this.tasks.get(i));
            }
        }
        return res;
    }
    public int getTasksNumberOfTask() {
        return this.tasks.size();
    }
    public int getTasksNumberOfTaskByPriority(Priority priority) {
        int res = 0;
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).priority.equals(priority)) {
                res ++;
            }
        }
        return res;
    }

    // Fonctions
    public void addTask(Task task) {
        this.tasks.add(task);
    }
    public void removeTask(Task task) {
        this.tasks.remove(task);
    }
    public void displayTasks() {
        for (int i = 0; i < this.tasks.size(); i++) {
            this.tasks.get(i).displayInfo();
        }
    }
    public boolean importTask(String[] taskData) {
        if (taskData.length != 3) {
            System.out.println("The date must contain title, desciption, and priority");
            return false;
        }
        try {
            String title = taskData[0];
        } catch (IllegalArgumentException e) {
            System.out.println("Task not imported : "+e.getMessage());
            return false;
        }
        try {
            String description = taskData[1];
        } catch (IllegalArgumentException e) {
            System.out.println("Task not imported : "+e.getMessage());
            return false;
        }
        try {
            String priority = taskData[2];
        } catch (IllegalArgumentException e) {
            System.out.println("Task not imported : "+e.getMessage());
            return false;
        }
        String title = taskData[0];
        String description = taskData[1];
        String priority = taskData[2];
        Task task = new Task(title, description, priority);
        return true;
    }
    public void importTasks(String[][] tasksData) {
        int successCount = 0;
        int errorCount = 0;
        for (int i = 0; i < tasksData.length; i++) {
            try {
                if (importTask(tasksData[i])) {
                    successCount ++;
                } else {
                    errorCount ++;
                }
            } catch (IllegalArgumentException e) {
                errorCount ++;
                System.out.println(e);
            }
        }
        System.out.println("Success: " + successCount + "\nError: " + errorCount);
    }

}
