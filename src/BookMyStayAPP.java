import java.util.*;

// Main Application
public class BookMyStayAPP {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("   Welcome to Book My Stay App!");
        System.out.println("   Hotel Booking Management System v6.1");
        System.out.println("=======================================\n");

        // Initialize rooms
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        Room[] rooms = {single, doubleRoom, suite};

        // Inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType(single.getRoomType(), 2);
        inventory.addRoomType(doubleRoom.getRoomType(), 1);
        inventory.addRoomType(suite.getRoomType(), 0);

        inventory.displayInventory();

        // Search service
        SearchService searchService = new SearchService(inventory);
        searchService.searchAvailableRooms(rooms);

        // Booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Double Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Diana", "Single Room"));

        bookingQueue.displayQueue();

        // Booking service
        BookingService bookingService = new BookingService(inventory);
        bookingService.processRequests(bookingQueue);

        System.out.println("\nFinal Availability:");
        searchService.searchAvailableRooms(rooms);
    }
}

/* ================= ROOM CLASSES ================= */

abstract class Room {

    protected String roomType;
    protected double price;

    public String getRoomType() {
        return roomType;
    }

    public abstract void displayRoomDetails();
}

class SingleRoom extends Room {

    public SingleRoom() {
        roomType = "Single Room";
        price = 1000;
    }

    public void displayRoomDetails() {
        System.out.println(roomType + " - Price: ₹" + price);
    }
}

class DoubleRoom extends Room {

    public DoubleRoom() {
        roomType = "Double Room";
        price = 1800;
    }

    public void displayRoomDetails() {
        System.out.println(roomType + " - Price: ₹" + price);
    }
}

class SuiteRoom extends Room {

    public SuiteRoom() {
        roomType = "Suite Room";
        price = 3000;
    }

    public void displayRoomDetails() {
        System.out.println(roomType + " - Price: ₹" + price);
    }
}

/* ================= INVENTORY ================= */

class RoomInventory {

    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public void displayInventory() {

        System.out.println("\nRoom Inventory:");

        for (String type : inventory.keySet()) {
            System.out.println(type + " : " + inventory.get(type));
        }
    }
}

/* ================= SEARCH SERVICE ================= */

class SearchService {

    private RoomInventory inventory;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms(Room[] rooms) {

        System.out.println("\nAvailable Rooms:");

        for (Room room : rooms) {
            int count = inventory.getAvailability(room.getRoomType());

            if (count > 0) {
                System.out.println(room.getRoomType() + " available (" + count + ")");
            } else {
                System.out.println(room.getRoomType() + " - Fully Booked");
            }
        }
    }
}

/* ================= RESERVATION ================= */

class Reservation {

    private String customerName;
    private String roomType;

    public Reservation(String customerName, String roomType) {
        this.customerName = customerName;
        this.roomType = roomType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoomType() {
        return roomType;
    }
}

/* ================= BOOKING QUEUE ================= */

class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        queue.add(reservation);
    }

    public Reservation getNextRequest() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {

        System.out.println("\nBooking Requests:");

        for (Reservation r : queue) {
            System.out.println(r.getCustomerName() + " requested " + r.getRoomType());
        }
    }
}

/* ================= BOOKING SERVICE ================= */

class BookingService {

    private RoomInventory inventory;

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void processRequests(BookingRequestQueue queue) {

        System.out.println("\nProcessing Bookings...");

        while (!queue.isEmpty()) {

            Reservation r = queue.getNextRequest();
            String roomType = r.getRoomType();
            int available = inventory.getAvailability(roomType);

            if (available > 0) {
                inventory.updateAvailability(roomType, available - 1);
                System.out.println("Booking confirmed for " + r.getCustomerName() + " (" + roomType + ")");
            } else {
                System.out.println("Sorry " + r.getCustomerName() + ", " + roomType + " not available.");
            }
        }
    }
}