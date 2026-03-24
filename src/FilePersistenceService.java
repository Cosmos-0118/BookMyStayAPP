import java.io.*;
import java.util.Map;

public class FilePersistenceService {

    public void saveInventory(RoomInventory inventory, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Map.Entry<String, Integer> entry : inventory.getAllRooms().entrySet()) {
                writer.write(entry.getKey() + "-" + entry.getValue());
                writer.newLine();
            }

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }
        public void loadInventory(RoomInventory inventory, String filePath) {

        File file = new File(filePath);

        // File doesn't exist → safe start
        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("-");

                if (parts.length != 2) {
                    continue; // skip invalid line
                }

                String roomType = parts[0];
                int count = Integer.parseInt(parts[1]);

                inventory.setRoomCount(roomType, count);
            }

        } catch (Exception e) {
            System.out.println("Error loading inventory. Starting fresh.");
        }
    }
}