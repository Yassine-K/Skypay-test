
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Room {

    private RoomType type;
    private int price;
    private int id;
    private ArrayList<Date[]> bookingTime = new ArrayList<>();

    public Room(int id, RoomType t, int p) {
        if (p < 0 || id < 0) {
            throw new IllegalArgumentException("Invalid input: Values can't be a negative numbers!");
        }
        this.type = t;
        this.price = p;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

    public RoomType getType() {
        return this.type;
    }

    public int addDate(Date checkIn, Date checkOut) {
        for (Date[] d : bookingTime) {
            long start = ChronoUnit.DAYS.between(checkIn.getDate(), d[0].getDate());
            long end = ChronoUnit.DAYS.between(checkOut.getDate(), d[0].getDate());
            if (start >= 0 && end <= 0) {
                return 0;
            }
            end = ChronoUnit.DAYS.between(checkOut.getDate(), d[1].getDate());
            if (start <= 0 && end >= 0) {
                return 0;
            }
        }
        this.bookingTime.add(new Date[]{checkIn, checkOut});
        return 1;
    }
}
