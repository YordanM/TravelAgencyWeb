package com.web.travelAgency.model.DTOs;

import com.web.travelAgency.model.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HolidayDTO {

    private Long id;
    private Long location;
    private String title;
    private LocalDate startDate;
    private int duration;
    private double price;
    private int freeSlots;

}
