package repository;

import models.Hotel;

import java.util.List;

public interface HotelRepository {
    Hotel findHotelById(long id);
    boolean updateHotel(Hotel hotel);
    int totalNoOfHotelAvailable();
    List<String> gethotelNames();
}

