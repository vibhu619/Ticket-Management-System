package com.ticketManagement.ticketManagementSystem.Dto;


import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
public class ScheduleDto {

    public String movieName;

    public String genre;

    public String time;

    public String theaterName;

    public String theaterLocation;

    public Integer availableSeats;

}
