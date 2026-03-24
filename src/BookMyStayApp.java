
public class BookMyStayApp {
    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        CancellationService cancelService = new CancellationService();

        // Simulate bookings
        cancelService.registerBooking("Single-1", "Single");
        cancelService.registerBooking("Double-1", "Double");

        // Cancel booking
        cancelService.cancelBooking("Single-1", inventory);

        // Show rollback history
        cancelService.showRollbackHistory();

        // Show updated inventory
        System.out.println("Updated Single Room Availability: " + inventory.getRoomCount("Single"));
    }
}