package com.web.travelAgency.service.implementations;

import com.web.travelAgency.model.DTOs.HolidayDTO;
import com.web.travelAgency.model.Holiday;
import com.web.travelAgency.model.Location;
import com.web.travelAgency.repository.HolidayRepository;
import com.web.travelAgency.service.interfaces.IHolidayService;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;
import org.h2.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Service
public class HolidayService implements IHolidayService {

    private final HolidayRepository repository;

    public HolidayService(HolidayRepository repository) {
        this.repository = repository;
    }


    @Override
    public Holiday addHoliday(HolidayDTO holidayDTO) {
        Location location = new Location();
        location.setId(holidayDTO.getLocation());

        Holiday holiday = Holiday.builder()
                .title(holidayDTO.getTitle())
                .price(holidayDTO.getPrice())
                .duration(holidayDTO.getDuration())
                .freeSlots(holidayDTO.getFreeSlots())
                .startDate(holidayDTO.getStartDate())
                .location(location)
                .build();

        return repository.save(holiday);
    }

    @Override
    public List<Holiday> findAllHolidays(@Nullable String location, @Nullable LocalDate startDate, @Nullable Integer duration) {
        //return repository.findAll();

        List<Holiday> allHolidays = repository.findAll();

        List<Holiday> filteredHolidays = allHolidays.stream().filter(
                    h -> (StringUtils.isNullOrEmpty(location) ||
                            h.getLocation().getCity().contains(location) ||
                            h.getLocation().getCountry().contains(location)))
                .filter(h -> startDate == null || h.getStartDate().equals(startDate))
                .filter(h -> duration == null || h.getDuration() == duration)
                .toList();

        return filteredHolidays;
    }

    @Override
    public Holiday findHolidayById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Holiday updateHoliday(HolidayDTO holiday) {
        Holiday oldHoliday = this.findHolidayById(holiday.getId());
        Location location = Location.builder().id(holiday.getLocation()).build();

        Location location1 = new Location();
        location1.setId(holiday.getLocation());

        oldHoliday.setDuration(holiday.getDuration());
        oldHoliday.setPrice(holiday.getPrice());
        oldHoliday.setTitle(holiday.getTitle());
        oldHoliday.setFreeSlots(holiday.getFreeSlots());
        oldHoliday.setStartDate(holiday.getStartDate());
        oldHoliday.setLocation(location1);

        return repository.save(oldHoliday);
    }

    @Override
    public void deleteHoliday(Long id) {
        repository.deleteById(id);
    }
}
