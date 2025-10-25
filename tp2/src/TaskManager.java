import com.sun.net.httpserver.Authenticator;

import java.util.ArrayList;

public class TaskManager {

    // Attributs protégés
    protected ArrayList<Task> TaskManager;

    // Constructeur
    public TaskManager() {}

    public void addTask(Task task) {
        this.TaskManager.add(task);
    }
    public void removeTask(Task task) {
        this.TaskManager.remove(task);
    }
    public void displayTasks(Task task) {
        System.out.println("Tasks: \n" + task);
    }
    public void displayTasksByPriority(TaskManager Tasks, Priority priority) {
        System.out.println("Tasks: ");
        for (int i = 0; i < Tasks.TaskManager.size(); i++) {
            if (Tasks.TaskManager.get(i).priority.equals(priority)) {
                System.out.println(this.TaskManager);
            }
        }
    }
    public void displayTasksByTitle(TaskManager Tasks, String title) {
        System.out.println("Tasks: ");
        for (int i = 0; i < Tasks.TaskManager.size(); i++) {
            if (Tasks.TaskManager.get(i).title.equals(title)) {
                System.out.println(this.TaskManager);
            }
        }
    }
    public void displayTasksNumberOfTask(TaskManager Tasks) {
        System.out.println("Number of task: " + this.TaskManager.size());
    }
    public void displayTasksNumberOfTaskByPriority(TaskManager Tasks, Priority priority) {
        int count = 0;
        for (int i = 0; i < Tasks.TaskManager.size(); i++) {
            if (Tasks.TaskManager.get(i).priority.equals(priority)) {
                count ++;
            }
        }
        System.out.println("Number of task: " + count);
    }
    public boolean importTask(String[] taskData) {
        try {
            String title = taskData[0];
            String description = taskData[1];
            String priority = taskData[2];
            if (priority == null) {
                throw new IllegalArgumentException("Priority is null");
            }
            Priority priorityEnum = Priority.fromString(priority);
            try {
                Task task = new Task(title, description, priorityEnum);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }
            return true;
        } catch (IllegalArgumentException e) { // On capture IllegalArgument
            System.out.println("Tâche non importée : "+e.getMessage());
            return false;
        } catch (IndexOutOfBoundsException e) {// On capture IndexOutOfBounds
            System.out.println("Tâche non importée : Data mal formatée");
            return false;
        }
    }
    public void importTasks(String[][] tasksData) {
        int successCount = 0;
        int errorCount = 0;
        for (int i = 0; i < tasksData.length; i++) {
            if (!importTask(tasksData[i])) {
                errorCount ++;
            } else  {
                importTask(tasksData[i]);
                successCount ++;
            }
        }
        System.out.println("Success: " + successCount + "\nError: " + errorCount);
    }

}
