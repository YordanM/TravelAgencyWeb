package com.web.travelAgency.service.interfaces;

import com.web.travelAgency.model.DTOs.HolidayDTO;
import com.web.travelAgency.model.DTOs.ReservationDTO;
import com.web.travelAgency.model.Holiday;
import com.web.travelAgency.model.Reservation;
import jakarta.annotation.Nullable;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(ReservationDTO reservationDTO);
    List<Reservation> findAllHolidays(@Nullable String phoneNumber);
    Reservation findReservationById(Long id);
    Reservation updateReservation(ReservationDTO reservationDTO);
    void deleteReservation(Long id);
}
