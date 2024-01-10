package com.ticketManagement.ticketManagementSystem.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReservationDto {

    public String movie;

    public String theater;

    public String customerName;

    public Integer numberOfSeats;

    public Integer amountPaid;

    public Date reservationDate;

}
