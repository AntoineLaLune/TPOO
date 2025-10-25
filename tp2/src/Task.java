public class Task {

    // Attributs protégés
    protected String title;
    protected String description;
    protected Priority priority;

    // Constructeur
    public Task(String title, String description, Priority priority) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title is null");
        }
        if (description == null) {
            throw new IllegalArgumentException("Description is null");
        }
        if (priority == null) {
            throw new IllegalArgumentException("Priority is null");
        }
        this.title = title;
        this.description = description;
        this.priority = priority;
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