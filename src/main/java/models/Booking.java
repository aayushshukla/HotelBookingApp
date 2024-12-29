package models;

public class Booking {
    private long id;
    private long hotelId;
    private String customerName;

    public Booking(long id, long hotelId, String customerName) {
        this.id = id;
        this.hotelId = hotelId;
        this.customerName = customerName;
    }

    public long getId() {
        return id;
    }

    public long getHotelId() {
        return hotelId;
    }

    public String getCustomerName() {
        return customerName;
    }
}
