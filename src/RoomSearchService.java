import java.util.Map;

public class RoomSearchService {
    public void searchAvailableRooms(RoomInventory inventory, Room singleRoom, Room doubleRoom, Room suiteRoom){
        Map<String, Integer> availability = inventory.getRoomAvailability();
        if(availability.get("Single") > 0){
            singleRoom = new SingleRoom();
            System.out.println("Single Room: ");
            singleRoom.displayRoomDetails();
            System.out.println("Available: "+ inventory.getAvailability("Single"));
        }
        if(availability.get("Double") > 0){
            doubleRoom = new DoubleRoom();
            System.out.println("Double Room: ");
            doubleRoom.displayRoomDetails();
            System.out.println("Available: "+ inventory.getAvailability("Double"));
        }
        if(availability.get("Suite") > 0){
            suiteRoom = new SuiteRoom();
            System.out.println("Suite Room: ");
            suiteRoom.displayRoomDetails();
            System.out.println("Available: "+ inventory.getAvailability("Suite"));
        }
    }
}