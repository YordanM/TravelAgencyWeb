package com.web.travelAgency.controller;

import com.web.travelAgency.model.DTOs.ReservationDTO;
import com.web.travelAgency.model.Reservation;
import com.web.travelAgency.service.interfaces.IReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("travel-agency/reservations")
@CrossOrigin
public class ReservationController {
    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("")
    public ResponseEntity<Reservation> addReservation(@RequestBody ReservationDTO reservationDTO){
        return ResponseEntity.ok(reservationService.addReservation(reservationDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<Reservation>> findAllReservations(@RequestParam(required = false) String phoneNumber){
        return ResponseEntity.ok(reservationService.findAllHolidays(phoneNumber));
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> findReservationById(@PathVariable Long id){
        return ResponseEntity.ok(reservationService.findReservationById(id));
    }

    @PutMapping("")
    public ResponseEntity<Reservation> editReservation(@RequestBody ReservationDTO reservationDTO){
        return ResponseEntity.ok(reservationService.updateReservation(reservationDTO));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
    }
}
