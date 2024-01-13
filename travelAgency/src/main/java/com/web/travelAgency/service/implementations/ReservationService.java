package com.web.travelAgency.service.implementations;

import com.web.travelAgency.model.DTOs.HolidayDTO;
import com.web.travelAgency.model.DTOs.ReservationDTO;
import com.web.travelAgency.model.Holiday;
import com.web.travelAgency.model.Reservation;
import com.web.travelAgency.repository.IReservationRepository;
import com.web.travelAgency.service.interfaces.IReservationService;
import jakarta.annotation.Nullable;
import org.h2.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService {

    private final IReservationRepository repository;

    public ReservationService(IReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Reservation addReservation(ReservationDTO reservationDTO) {
        Holiday holiday = Holiday.builder().id(reservationDTO.getHoliday()).build();

        Reservation reservation = Reservation.builder()
                .phoneNumber(reservationDTO.getPhoneNumber())
                .contactName(reservationDTO.getContactName())
                .holiday(holiday)
                .build();

        return repository.save(reservation);
    }

    @Override
    public List<Reservation> findAllHolidays(@Nullable String phoneNumber) {
        List<Reservation> allReservations = repository.findAll();

        List<Reservation> filteredReservations = allReservations.stream().filter(
                r -> phoneNumber == null || r.getPhoneNumber().equals(phoneNumber)
        ).toList();

        return filteredReservations;
    }

    @Override
    public Reservation findReservationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Reservation updateReservation(ReservationDTO reservationDTO) {
        Reservation oldReservation = this.findReservationById(reservationDTO.getId());
        Holiday holiday = Holiday.builder().id(reservationDTO.getHoliday()).build();

        oldReservation.setContactName(reservationDTO.getContactName());
        oldReservation.setPhoneNumber(reservationDTO.getPhoneNumber());
        oldReservation.setHoliday(holiday);

        return repository.save(oldReservation);
    }

    @Override
    public void deleteReservation(Long id) {
        repository.deleteById(id);
    }
}
