import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Slot {

    // Attributs protégés
    protected Date startTime;
    protected long duration;
    protected int room;

    // Contructor
    public Slot(String startTime, String duration, String room) {
        if (startTime == null || startTime.isEmpty()) {
            throw new IllegalArgumentException("Start Time cannot be null or empty");
        }
        if (Long.parseLong(duration) <= 0) {
            throw new IllegalArgumentException("The duration must be a positive number");
        }
        String roomRes = "";
        for (int i = 0; i < room.length(); i++) {
            if (Character.isDigit(room.charAt(i))) {
                roomRes = roomRes + Character.toString(room.charAt(i));
            }
        }
        if (Integer.parseInt(roomRes) <= 0) {
            throw new IllegalArgumentException("The room must be a positive number");
        }
        SimpleDateFormat simpleSimpleDateFormat = new SimpleDateFormat("HH'h'mm");
        try {
            this.startTime = simpleSimpleDateFormat.parse(startTime);
        } catch (ParseException e) {
            throw new RuntimeException("The start time must be in the \"HH 'h' mm\" format (e.g., \"12h00\")");
        }
        this.duration = Long.parseLong(duration);
        this.room = Integer.parseInt(roomRes);
    }

    // Method
    public Date getEndTime() {
        return new Date(this.startTime.getTime() + (this.duration * 60 * 1000));
    }
    public void display() {
        System.out.println("    For the room " + this.room + ":");
        System.out.println("        Start at: " + this.startTime);
        System.out.println("        For: " + this.duration + "minutes");
        System.out.println("        End at: " + this.getEndTime());
    }
    public boolean hasTimeConflict(Slot other) {
        if (other.room == this.room) {
            if (this.startTime.before(other.getEndTime())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    // Getter
    public int getRoom() {
        return this.room;
    }

    public long getDuration() {
        return this.duration;
    }
}
