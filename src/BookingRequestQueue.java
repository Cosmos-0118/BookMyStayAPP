import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {
    private Queue<Reservation> requestQueue;
    public BookingRequestQueue(){
        requestQueue = new LinkedList<>();
    }
    public void addRequest(Reservation reservation){
        requestQueue.offer(reservation);
    }
    public Reservation getNextRequest(){
        return requestQueue.poll();
    }
    public boolean hasPendingRequests(){
        return !requestQueue.isEmpty();
    }
}