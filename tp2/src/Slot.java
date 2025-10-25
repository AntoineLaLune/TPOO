import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Slot {

    // Attributs protégés
    protected Date startTime;
    protected long duration;
    protected int room;

    // Contructor
    public Slot(String startTime,long duration, int room) throws ParseException {
        if (startTime == null) {
            throw new IllegalArgumentException("Start Time is null");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration is invalid");
        }
        if (room <= 0) {
            throw new IllegalArgumentException("Room is invalid");
        }
        SimpleDateFormat simpleSimpleDateFormat = new SimpleDateFormat("HH'h'mm");
        this.startTime = simpleSimpleDateFormat.parse(startTime);
        this.duration = duration;
        this.room = room;
    }

    // Method
    public Date getEndTime() {
        return new Date(this.startTime.getTime() + (this.duration * 60 * 1000));
    }
    public void display() {
        System.out.println("    For the " + this.room + " room:");
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
