public class UseCase2RoomInitialization{
    public static void main(String[] args) {
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