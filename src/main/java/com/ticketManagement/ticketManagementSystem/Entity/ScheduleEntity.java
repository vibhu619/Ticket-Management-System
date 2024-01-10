package com.ticketManagement.ticketManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "schedule")

public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "movie")
    public String movieName;

    @Column(name = "movie_id")
    public Integer movieId;

    @Column(name = "time")
    public String time;

    @Column(name = "theater_id")
    public Integer theaterId;

    public ScheduleEntity(Integer id, String movieName, Integer movieId, String time, Integer theaterId) {
        this.id = id;
        this.movieName = movieName;
        this.movieId = movieId;
        this.time = time;
        this.theaterId = theaterId;
    }


    public ScheduleEntity() {

    }
}
