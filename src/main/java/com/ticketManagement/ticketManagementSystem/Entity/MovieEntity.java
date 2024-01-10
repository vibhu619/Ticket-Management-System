package com.ticketManagement.ticketManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor

@Table(name = "movies")
public class MovieEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer id;

    @Column(name="title")
    public String title;

    @Column(name="genre")
    public String genre;

    @Column(name = "duration")
    public Integer durationInMin;

    @Column(name = "release_date")
    public Date releaseDate;

    @OneToOne
    @JoinColumn(name = "id" , referencedColumnName = "reservation_movie_id")
    public ReservationEntity reservation;

    public MovieEntity() {
    }
}
