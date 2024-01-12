package com.web.travelAgency.controller;

import com.web.travelAgency.model.DTOs.LocationDTO;
import com.web.travelAgency.model.Location;
import com.web.travelAgency.service.interfaces.ILocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("travel-agency/locations")
@CrossOrigin
public class LocationController {
    private final ILocationService locationService;

    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("")
    public ResponseEntity<Object> createLocation(@RequestBody LocationDTO locationDTO) {
        return ResponseEntity.ok(locationService.addLocation(locationDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<Location>> getAllLocations() {
        return ResponseEntity.ok(locationService.findAllLocations());
    }

    @GetMapping("{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.findLocationById(id));
    }

    @PutMapping("")
    public ResponseEntity<Location> editLocation(@RequestBody Location location) {
        return ResponseEntity.ok(locationService.updateLocation(location));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}
