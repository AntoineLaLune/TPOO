public class Task {

    // Attributs protégés
    protected String title;
    protected String description;
    protected Priority priority;

    // Constructeur
    public Task(String title, String description, String priority) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cant' be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cant' be null or empty");
        }
        if (priority == null || priority.isEmpty()) {
            throw new IllegalArgumentException("Priority cant' be null or empty");
        }
        this.title = title;
        this.description = description;
        this.priority = Priority.fromString(priority);
    }

    // Getter
    public String getTitle() {
        return this.title;
    }
    public String getDescription() {
        return this.description;
    }
    public Priority getPriority() {
        return this.priority;
    }

    // Fonctions
    public void displayInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Description: " + this.description);
        System.out.println("Priority: " + this.priority);
    }

}