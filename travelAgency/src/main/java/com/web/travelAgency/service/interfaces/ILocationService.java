package com.web.travelAgency.service.interfaces;

import com.web.travelAgency.model.DTOs.LocationDTO;
import com.web.travelAgency.model.Location;

import java.util.List;

public interface ILocationService {
    Location addLocation(LocationDTO locationDTO);
    List<Location> findAllLocations();
    Location findLocationById(Long id);
    Location updateLocation(Location updatedLocation);
    void deleteLocation(Long id);
}
