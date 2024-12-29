package repository;

import models.Hotel;

import java.util.HashMap;
import java.util.Map;

public class HotelRepositoryImpl implements HotelRepository {

    private Map<Long, Hotel> hotelDatabase = new HashMap<>();

    public HotelRepositoryImpl() {
        // Adding some initial hotels to the "database"
        hotelDatabase.put(1L, new Hotel(1L, "Grand Plaza", 10));
        hotelDatabase.put(2L, new Hotel(2L, "Beach Resort", 5));
        hotelDatabase.put(3L, new Hotel(3L, "Mountain Inn", 0)); // No rooms available
    }

    @Override
    public Hotel findHotelById(long id) {
        return hotelDatabase.get(id);
    }

    @Override
    public boolean updateHotel(Hotel hotel) {
        if (hotel != null && hotelDatabase.containsKey(hotel.getId())) {
            hotelDatabase.put(hotel.getId(), hotel);
            return true;
        }
        return false;
    }
}

