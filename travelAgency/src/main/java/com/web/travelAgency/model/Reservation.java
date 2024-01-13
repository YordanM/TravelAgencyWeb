package com.web.travelAgency.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contactName;
    private String phoneNumber;

    @ManyToOne
    private Holiday holiday;
}
