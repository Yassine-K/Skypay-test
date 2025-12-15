
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Service {

    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        for (Room r : rooms) {
            if (r.getId() == roomNumber) {
                System.out.println("Room already exists!");
                return;
            }
            if (r.getType() == roomType && roomPricePerNight == r.getPrice()) {
                System.out.println("A room with a similar type and price already exists!");
                return;
            }
        }
        rooms.add(0, new Room(roomNumber, roomType, roomPricePerNight));
    }

    void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        User client = null;
        for (User u : users) {
            if (u.getId() == userId) {
                client = u;
                break;
            }
        }

        if (client == null) {
            System.out.println("User not found!");
            return;
        }

        long duration = ChronoUnit.DAYS.between(checkIn.getDate(), checkOut.getDate());
        if (duration < 1) {
            System.out.println("Error: Check-in date cannot be after check-out date!");
            return;
        }

        Room room = null;
        for (Room r : rooms) {
            if (r.getId() == roomNumber) {
                room = r;
                break;
            }
        }

        Booking check = new Booking(client, room, checkIn, checkOut, duration);
        if (check.user.getBalance() < check.total) {
            System.out.println("Insufficient balance!");
            return;
        }
        if (room.addDate(checkIn, checkOut) != 0) {
            bookings.add(0, check);
            check.user.makePurchase((int) check.total);
        } else {
            System.out.println("The room is booked!");
        }
    }

    void printAll() {
        System.out.println("User Id\t|| Balance\t|| Number of Nights\t|| Checkin\t\t|| Checkout\t\t|| Room Type\t|| Number\t|| Price per night\t\t|| Total");
        for (Booking b : bookings) {
            System.out.printf("%d\t|| %d\t\t|| %d\t\t\t|| %s\t\t|| %s\t\t|| %s\t|| %d\t\t|| %d\t\t\t\t|| %d\n", b.user.getId(), b.user.getBalance(), (int) b.duration, b.bookingTime.get(0).getDate(), b.bookingTime.get(1).getDate(), b.room.getType().name().toLowerCase(), b.room.getId(), b.room.getPrice(), b.total);
        }
    }

    void setUser(int userId, int balance) {
        for (User u : users) {
            if (u.getId() == userId) {
                System.out.println("User already exists!");
                return;
            }
        }
        users.add(0, new User(userId, balance));
    }

    void printAllUsers() {
        for (User u : users) {
            System.out.println("The user " + u.getId() + " has a balance of $" + u.getBalance() + "");
        }
    }
}
