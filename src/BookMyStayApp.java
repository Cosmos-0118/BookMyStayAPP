public class BookMyStayApp{
    public static void main(String[] args) {
        BookingHistory history = new BookingHistory();
        history.addReservation(new Reservation("Abhi", "Single"));
        history.addReservation(new Reservation("Subha", "Double"));
        history.addReservation(new Reservation("Vanmathi", "Suite"));
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}