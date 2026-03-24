public class BookingReportService {
    public void generateReport(BookingHistory history){
        System.out.println("Booking History Report");
        for(Reservation r : history.getConfirmedReservations()){
            System.out.println("Guest: "+ r.getGuestName());
            System.out.println("Room Type: "+ r.getRoomType());
        }
    }
}