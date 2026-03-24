public class BookMyStayApp{
    public static void main(String[] args) {
        System.out.println("Room Service Processing");
        String reservationId = "Single-1";
        AddOnServiceManager manager = new AddOnServiceManager();
        AddOnService s1 = new AddOnService("Wifi", 500);
        AddOnService s2 = new AddOnService("Food", 1000);
        manager.addService(reservationId, s1);
        manager.addService(reservationId, s2);
        double total = manager.calculateTotalServiceCost(reservationId);
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + total);
    }
}