import java.util.ArrayList;
import java.util.List;
public class BookingHistory{
    private List<Reservation> confirmedReservations;
    public BookingHistory(){
        confirmedReservations = new ArrayList<>();
    }
    public void addReservation(Reservation reservation){
        confirmedReservations.add(reservation);
    }
    public List<Reservation> getConfirmedReservations(){
        return confirmedReservations;
    }
}