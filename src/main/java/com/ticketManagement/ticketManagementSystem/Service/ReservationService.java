package com.ticketManagement.ticketManagementSystem.Service;

import com.ticketManagement.ticketManagementSystem.Dto.ReservationDto;
import com.ticketManagement.ticketManagementSystem.Entity.ReservationEntity;
import com.ticketManagement.ticketManagementSystem.Entity.TheaterEntity;
import com.ticketManagement.ticketManagementSystem.Repository.ReservationRepository;
import com.ticketManagement.ticketManagementSystem.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public ResponseEntity<ReservationDto> getReservation(Integer id) {
        ReservationEntity reservation=reservationRepository.findById(id).orElseThrow();

        ReservationDto reservationDto=ReservationDto.builder()
                .movie(reservation.getMovie().getTitle())
                .theater(reservation.getTheater().getTheaterName())
                .amountPaid(reservation.getAmountPaid())
                .customerName(reservation.getCustomerName())
                .numberOfSeats(reservation.getNumberOfSeats())
                .reservationDate(reservation.getReservationDate())
                .build();

        return new ResponseEntity<>(reservationDto,HttpStatus.OK);



    }

    public ResponseEntity<String> makeReservation(ReservationEntity reservation) {
        reservationRepository.save(reservation);
        Integer availableSeats= theaterRepository.findById(reservation.getTheaterId()).orElseThrow().getAvailableSeats()- reservation.getNumberOfSeats();
        TheaterEntity theater=theaterRepository.findById(reservation.getTheaterId()).orElseThrow();
        theater.setAvailableSeats(availableSeats);
        theaterRepository.save(theater);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }


    public ResponseEntity<String> cancelReservation(Integer id) {
        ReservationEntity reservation=reservationRepository.findById(id).orElseThrow();
        Integer availableSeats = reservation.getNumberOfSeats() + theaterRepository.findById(reservation.getTheaterId())
                                                                                                        .orElseThrow()
                                                                                                        .getAvailableSeats();

        TheaterEntity theater=theaterRepository.findById(reservation.getTheaterId()).orElseThrow();
        theater.setAvailableSeats(availableSeats);

        theaterRepository.save(theater);

        reservationRepository.deleteById(id);

        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);

    }
}
