public abstract class Room {
    protected int numberOfbeds;
    protected int squareFeet;
    protected double pricePerNight;
    Room(int beds, int size, double price){
        this.numberOfbeds = beds;
        this.squareFeet = size;
        this.pricePerNight = price;
    }
    void displayRoomDetails(){
        System.out.println("Number of Beds: "+ numberOfbeds);
        System.out.println("Size: "+ squareFeet +" sqft");
        System.out.println("Price per Night: "+ pricePerNight);
    }
}