import java.util.HashMap;

public class RoomInventory {
        private HashMap <String,Integer> inventory;
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
            for(String roomType : inventory.keySet()){
                Integer count = inventory.get(roomType);
                System.out.println(roomType+" Room Available: "+ count);
            }
        }
}