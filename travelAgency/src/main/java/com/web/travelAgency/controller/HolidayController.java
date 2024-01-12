package com.web.travelAgency.controller;

import com.web.travelAgency.model.DTOs.HolidayDTO;
import com.web.travelAgency.model.Holiday;
import com.web.travelAgency.service.interfaces.IHolidayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("travel-agency/holidays")
@CrossOrigin
public class HolidayController {
    private final IHolidayService holidayService;

    public HolidayController(IHolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @PostMapping("")
    public ResponseEntity<Holiday> addHoliday(@RequestBody HolidayDTO holidayDTO) {
        return ResponseEntity.ok(holidayService.addHoliday(holidayDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<Holiday>> findAllHolidays(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) Integer duration
            ){
        return ResponseEntity.ok(holidayService.findAllHolidays(location, startDate, duration));
    }

    @GetMapping("{id}")
    public ResponseEntity<Holiday> findHolidayById(@PathVariable Long id){
        return ResponseEntity.ok(holidayService.findHolidayById(id));
    }

    @PutMapping("")
    public ResponseEntity<Holiday> editHoliday(@RequestBody HolidayDTO holiday){
        return ResponseEntity.ok(holidayService.updateHoliday(holiday));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteHoliday(@PathVariable Long id){
        holidayService.deleteHoliday(id);
    }
}
