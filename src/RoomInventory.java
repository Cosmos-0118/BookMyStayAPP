import java.util.HashMap;
import java.util.Map;

public class RoomInventory {
    private Map<String,Integer> inventory;
    RoomInventory(){
        inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }
    int getAvailability(String roomType){
        Integer count = inventory.get(roomType);
        if(count != null) 
            return count;
        return 0;
    }
    void updateAvailability(String roomType, int newCount){
        inventory.put(roomType,newCount);
    }
    void displayInventory(){
        for(Map.Entry<String, Integer> entry : inventory.entrySet()){
            System.out.println(entry.getKey() + " Room Available: " + entry.getValue());
        }
    }
    Map<String, Integer> getRoomAvailability(){
        return new HashMap<>(inventory);
    }
}