public class BookMyStayApp{
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   Welcome to Book My Stay App!");
        System.out.println("   Hotel Booking Management System v1.0");
        System.out.println("=======================================\n");
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();
        int singleRoomAvailability = 10;
        int doubleRoomAvailability = 5;
        int suiteRoomAvailability = 2;
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailability);
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailability);
        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailability);
    }
}