package com.web.travelAgency.repository;

import com.web.travelAgency.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHolidayRepository extends JpaRepository<Holiday, Long> {
}
