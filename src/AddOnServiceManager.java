
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOnServiceManager {
    private Map<String, List<AddOnService>> servicesByReservation;
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }
    public void addService(String reservationId, AddOnService service) {
    if(servicesByReservation.get(reservationId) == null){
        servicesByReservation.put(reservationId, new ArrayList<>());
    }
    servicesByReservation.get(reservationId).add(service);
    }
    public double calculateTotalServiceCost(String reservationId) {
        List<AddOnService> services = servicesByReservation.get(reservationId);
        if(services == null){
            return 0;
        }
        double total = 0;
        for(AddOnService s : services){
            total += s.getCost();
        }
        return total;
    }
}