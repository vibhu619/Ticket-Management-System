package com.ticketManagement.ticketManagementSystem.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Builder
public class TheaterDto {

    public String theaterName;

    public String location;

    public Integer availableSeats;

    public String audiNumber;

    public TheaterDto(String theaterName, String location, Integer availableSeats, String audiNumber) {
        this.theaterName = theaterName;
        this.location = location;
        this.availableSeats = availableSeats;
        this.audiNumber = audiNumber;
    }
}
