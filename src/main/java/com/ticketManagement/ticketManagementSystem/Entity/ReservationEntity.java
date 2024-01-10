package com.ticketManagement.ticketManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name= "customer_name")
    public String customerName;

    @Column(name= "number_of_seats")
    public Integer numberOfSeats;

    @Column(name= "amount_paid")
    public Integer amountPaid;

    @Column(name= "reservation_date")
    public Date reservationDate;

    @Column(name= "reservation_movie_id")
    public Integer movieId;

    @Column(name= "reservation_theater_id")
    public Integer theaterId;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "reservation")
    public MovieEntity movie;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "reservation")
    public TheaterEntity theater;

    public ReservationEntity() {
    }
}
