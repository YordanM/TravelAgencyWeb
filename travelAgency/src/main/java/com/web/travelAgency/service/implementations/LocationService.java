package com.web.travelAgency.service.implementations;

import com.web.travelAgency.model.DTOs.LocationDTO;
import com.web.travelAgency.model.Location;
import com.web.travelAgency.repository.LocationRepository;
import com.web.travelAgency.service.interfaces.ILocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location addLocation(LocationDTO locationDTO) {
        //variant one using the constructor inside the model
        //return repository.save(new Location(street, number, city, country));

        //variant two
        //this way we don't need to make constructor in the model
        Location location = Location.builder()
                .street(locationDTO.getStreet())
                .number(locationDTO.getNumber())
                .city(locationDTO.getCity())
                .country(locationDTO.getCountry())
                .build();

        return repository.save(location);
    }

    @Override
    public List<Location> findAllLocations() {
        return repository.findAll();
    }

    @Override
    public Location findLocationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Location updateLocation(Location updatedLocation) {
        Location oldLocation = this.findLocationById(updatedLocation.getId());

        oldLocation.setCity(updatedLocation.getCity());
        oldLocation.setCountry(updatedLocation.getCountry());
        oldLocation.setNumber(updatedLocation.getNumber());
        oldLocation.setStreet(updatedLocation.getStreet());

        return repository.save(oldLocation);
    }

    @Override
    public void deleteLocation(Long id) {
        repository.deleteById(id);
    }
}
