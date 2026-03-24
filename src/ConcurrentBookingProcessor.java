public class ConcurrentBookingProcessor implements Runnable {
    private final BookingRequestQueue bookingQueue;
    private final RoomInventory inventory;
    private final RoomAllocationService allocationService;
    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService
    ) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }
    public boolean isEmpty() {
        return !bookingQueue.hasPendingRequests();
    }

    public Reservation getNextRequest() {
        return bookingQueue.getNextRequest();
    }
        @Override
    public void run() {

        while (true) {
            Reservation reservation;
            synchronized (bookingQueue) {
                if (isEmpty()) {
                    break;
                }

                reservation = getNextRequest();
            }
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}