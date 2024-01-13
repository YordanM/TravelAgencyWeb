package com.web.travelAgency.repository;

import com.web.travelAgency.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}
