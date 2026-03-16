
import java.util.HashMap;
import java.util.Map;

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

class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String roomType, int availability) {
        inventory.put(roomType, availability);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int newAvailability) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, newAvailability);
        }
    }

    public void displayInventory() {
        System.out.println("\n--- Current Room Inventory ---");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " rooms available");
        }
    }
}

public class BookMyStayAPP {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   Welcome to Book My Stay App!");
        System.out.println("   Hotel Booking Management System v3.1");
        System.out.println("=======================================\n");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        single.displayRoomDetails();
        doubleRoom.displayRoomDetails();
        suite.displayRoomDetails();

        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType(single.getRoomType(), 5);
        inventory.addRoomType(doubleRoom.getRoomType(), 3);
        inventory.addRoomType(suite.getRoomType(), 2);
        inventory.displayInventory();

        inventory.updateAvailability("Single Room", 4);
        System.out.println("\nAfter booking one Single Room:");
        inventory.displayInventory();
    }
}