

import java.util.HashMap;
import java.util.Map;

// Abstract class representing a generalized Room
abstract class Room {
    private String roomType;
    private int numberOfBeds;
    private double pricePerNight;

    public Room(String roomType, int numberOfBeds, double pricePerNight) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public abstract void displayRoomDetails();
}

// Concrete room classes
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 1500.0);
    }
    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + getRoomType() +
                " | Beds: " + getNumberOfBeds() +
                " | Price: ₹" + getPricePerNight());
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 2500.0);
    }
    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + getRoomType() +
                " | Beds: " + getNumberOfBeds() +
                " | Price: ₹" + getPricePerNight());
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 5000.0);
    }
    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + getRoomType() +
                " | Beds: " + getNumberOfBeds() +
                " | Price: ₹" + getPricePerNight());
    }
}

// UC3: Centralized Inventory Management
class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Register room type with availability
    public void addRoomType(String roomType, int availability) {
        inventory.put(roomType, availability);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int newAvailability) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, newAvailability);
        }
    }

    // Display current inventory state
    public void displayInventory() {
        System.out.println("\n--- Current Room Inventory ---");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " rooms available");
        }
    }
}

// UC4: Search Service (Read-only access)
class SearchService {
    private RoomInventory inventory;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // Display available rooms without modifying state
    public void searchAvailableRooms(Room[] rooms) {
        System.out.println("\n--- Search Results: Available Rooms ---");
        for (Room room : rooms) {
            int availability = inventory.getAvailability(room.getRoomType());
            if (availability > 0) {
                room.displayRoomDetails();
                System.out.println("Availability: " + availability + " rooms\n");
            }
        }
    }
}

// Application Entry Point
public class BookMyStayAPP {
    public static void main(String[] args) {
        // UC1: Welcome message
        System.out.println("=======================================");
        System.out.println("   Welcome to Book My Stay App!");
        System.out.println("   Hotel Booking Management System v4.1");
        System.out.println("   Hotel Booking Management System v3.1");
        System.out.println("=======================================\n");

        // UC2: Initialize room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        Room[] rooms = { single, doubleRoom, suite };

        // UC3: Centralized Inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType(single.getRoomType(), 5);
        inventory.addRoomType(doubleRoom.getRoomType(), 3);
        inventory.addRoomType(suite.getRoomType(), 0); // Suite fully booked

        inventory.displayInventory();

        // UC4: Room Search (Read-only)
        SearchService searchService = new SearchService(inventory);
        searchService.searchAvailableRooms(rooms);

        inventory.updateAvailability("Single Room", 4);
        System.out.println("\nAfter booking one Single Room:");
        inventory.displayInventory();

        searchService.searchAvailableRooms(rooms);
        single.displayRoomDetails();
        doubleRoom.displayRoomDetails();
        suite.displayRoomDetails();

        RoomInventory inventory1 = new RoomInventory();
        inventory1.addRoomType(single.getRoomType(), 5);
        inventory1.addRoomType(doubleRoom.getRoomType(), 3);
        inventory1.addRoomType(suite.getRoomType(), 2);

        inventory1.displayInventory();

        inventory1.updateAvailability("Single Room", 4);
        System.out.println("\nAfter booking one Single Room:");
        inventory1.displayInventory();
    }
}