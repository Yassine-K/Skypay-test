public class Main {

    public static void main(String[] args) {
        try {
            Service s = new Service();
            s.setRoom(1, RoomType.STANDARD, 1000);
            s.setRoom(2, RoomType.JUNIOR, 2000);
            s.setRoom(3, RoomType.SUITE, 3000);
            s.setUser(1, 5000);
            s.setUser(2, 10000);
            s.bookRoom(1, 2, new Date("30/06/2026"), new Date("07/07/2026"));
            s.bookRoom(1, 2, new Date("07/07/2026"), new Date("30/06/2026"));
            s.bookRoom(1, 1, new Date("07/07/2026"), new Date("08/07/2026"));
            s.bookRoom(2, 1, new Date("07/07/2026"), new Date("09/07/2026"));
            s.bookRoom(2, 3, new Date("07/07/2026"), new Date("08/07/2026"));
            s.setRoom(1, RoomType.SUITE, 10000);
            s.printAll();

        }
        catch (IllegalArgumentException e) {
            System.out.print(e + "\n");
        }
    }
}
