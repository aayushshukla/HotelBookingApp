package models;

public class Hotel {
    private long id;
    private String name;
    private int availableRooms;

    public Hotel(long id, String name, int availableRooms) {
        this.id = id;
        this.name = name;
        this.availableRooms = availableRooms;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }
}
