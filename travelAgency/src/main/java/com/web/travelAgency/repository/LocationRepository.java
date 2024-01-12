package com.web.travelAgency.repository;

import com.web.travelAgency.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {}
