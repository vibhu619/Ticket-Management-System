package com.ticketManagement.ticketManagementSystem.Controller;

import com.ticketManagement.ticketManagementSystem.Dto.ReservationDto;
import com.ticketManagement.ticketManagementSystem.Entity.ReservationEntity;
import com.ticketManagement.ticketManagementSystem.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;


    //Fetch reservation for particular id
    @GetMapping("/getReservation")
    public ResponseEntity<ReservationDto> getReservation(@RequestParam Integer id){
        return reservationService.getReservation(id);
    }


    //Make reservation and also reduce the seats by number of seats booked for particular theater
    @PostMapping("/makeReservation")
    public ResponseEntity<String> makeReservation(@RequestBody  ReservationEntity reservation){
        return reservationService.makeReservation(reservation);
    }

    //Cancel a reservation and increase seats
    @DeleteMapping("/cancelReservation")
    public ResponseEntity<String> cancelReservation(@RequestParam Integer id){
        return reservationService.cancelReservation(id);
    }
}
