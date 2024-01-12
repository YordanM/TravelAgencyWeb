package com.web.travelAgency.service.interfaces;

import com.web.travelAgency.model.DTOs.HolidayDTO;
import com.web.travelAgency.model.Holiday;
import jakarta.annotation.Nullable;

import java.time.LocalDate;
import java.util.List;

public interface IHolidayService {

    Holiday addHoliday(HolidayDTO holidayDTO);
    List<Holiday> findAllHolidays(@Nullable String location, @Nullable LocalDate startDate, @Nullable Integer duration);
    Holiday findHolidayById(Long id);
    Holiday updateHoliday(HolidayDTO holiday);
    void deleteHoliday(Long id);
}
