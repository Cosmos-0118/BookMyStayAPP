public class ReservationValidator {
    public void validate(String guestName, String roomType, RoomInventory inventory) throws InvalidBookingException{
        if(guestName.trim().isEmpty() || guestName == null) throw new InvalidBookingException("Guest name cannot be empty.");
        if(!roomType.equals("Single") && !roomType.equals("Double") && !roomType.equals("Suite")) throw new InvalidBookingException("Invalid room type selected.");
        if(inventory.getAvailability(roomType) == 0) throw new InvalidBookingException("No rooms available for selected type.");
    }
}