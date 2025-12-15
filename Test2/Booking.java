
import java.util.ArrayList;

public class Booking {

    User user;
    Room room;
    long total;
    long duration;
    ArrayList<Date> bookingTime = new ArrayList<>();

    public Booking(User u, Room r, Date checkIn, Date checkOut, long duration) {
        this.user = u;
        this.room = r;
        this.total = r.getPrice() * duration;
        this.duration = duration;
        this.bookingTime.add(checkIn);
        this.bookingTime.add(checkOut);
    }
}
