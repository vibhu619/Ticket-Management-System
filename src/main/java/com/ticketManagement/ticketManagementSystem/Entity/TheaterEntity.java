package com.ticketManagement.ticketManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Table(name = "theater")
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name= "name")
    public String theaterName;

    @Column(name= "location")
    public String location;

    @Column(name= "total_number_of_seats")
    public Integer totalSeats;

    @Column(name= "number_of_audi")
    public String audiNumber;

    @Column(name= "available_seats")
    public Integer availableSeats;

    @Column(name = "movie_id")
    public Integer movieId;

    @ManyToMany
    public List<MovieEntity> movies;

    @OneToOne
    @JoinColumn(name = "id" , referencedColumnName = "reservation_theater_id")
    public ReservationEntity reservation;


}
