public class BookMyStayApp{
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing");
        RoomAllocationService allocate = new RoomAllocationService();
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);
        while(bookingQueue.hasPendingRequests()){
            Reservation current = bookingQueue.getNextRequest();
            allocate.allocateRoom(current, inventory);
        }
    }
}