import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CancellationService {
    private Stack<String> releasedRoomIds;
    private Map<String, String> reservationRoomTypeMap;
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }
        public void cancelBooking(String reservationId, RoomInventory inventory) {

        // 1. Validate existence
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Reservation not found.");
            return;
        }

        // 2. Get room type
        String roomType = reservationRoomTypeMap.get(reservationId);

        // 3. Restore inventory
        inventory.incrementRoom(roomType);

        // 4. Push to rollback stack
        releasedRoomIds.push(reservationId);

        // 5. Remove booking record
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }
        public void showRollbackHistory() {

        System.out.println("Rollback History (Most Recent First):");

        Stack<String> tempStack = new Stack<>();
        tempStack.addAll(releasedRoomIds);

        while (!tempStack.isEmpty()) {
            System.out.println("Released Reservation ID: " + tempStack.pop());
        }
    }
}