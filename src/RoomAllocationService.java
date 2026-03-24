import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;
    public RoomAllocationService(){
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }
    public void allocateRoom(Reservation reservation, RoomInventory inventory){
        String roomType = reservation.getRoomType();
        Integer available = inventory.getAvailability(roomType);
        if(available>0){
            String roomId = generateRoomId(roomType);
            allocatedRoomIds.add(roomId);
            if(assignedRoomsByType.get(roomType) == null){
                assignedRoomsByType.put(roomType, new HashSet<>());
            }
            assignedRoomsByType.get(roomType).add(roomId);
            inventory.updateAvailability(roomType, available-1);
            System.out.println("Booking confirmed for Guest: "
            + reservation.getGuestName()
            + ", Room ID: "
            + roomId);
        }
        else System.out.println("No Rooms available for " + roomType);

    }
    private String generateRoomId(String roomType){
        Set<String> room = assignedRoomsByType.get(roomType);
        if(room == null){
            return roomType + "-1";
        }
        int size =  (room.size() + 1);
        return roomType + "-" + size;
    }
}