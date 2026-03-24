
public class BookMyStayApp {
    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistence = new FilePersistenceService();

        String filePath = "inventory.txt";

        persistence.loadInventory(inventory, filePath);

        inventory.displayInventory();
        inventory.decrementRoom("Single");
        persistence.saveInventory(inventory, filePath);
    }
}