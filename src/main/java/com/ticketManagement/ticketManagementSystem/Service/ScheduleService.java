package com.ticketManagement.ticketManagementSystem.Service;

import com.ticketManagement.ticketManagementSystem.Dto.ScheduleDto;
import com.ticketManagement.ticketManagementSystem.Entity.MovieEntity;
import com.ticketManagement.ticketManagementSystem.Entity.MoviesEntity;
import com.ticketManagement.ticketManagementSystem.Entity.ScheduleEntity;
import com.ticketManagement.ticketManagementSystem.Entity.TheaterEntity;
import com.ticketManagement.ticketManagementSystem.Repository.MoviesRepository;
import com.ticketManagement.ticketManagementSystem.Repository.ScheduleRepository;
import com.ticketManagement.ticketManagementSystem.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    MoviesRepository moviesRepository;

    @Autowired
    TheaterRepository theaterRepository;


    public List<ScheduleDto> getSchedule(String movieName) {
        List<ScheduleEntity> scheduleEntities=scheduleRepository.findByMovieName(movieName);

        return scheduleEntities.stream()
                .map(this::mapper)
                .collect(Collectors.toList());
    }

    private ScheduleDto mapper(ScheduleEntity scheduleEntity) {
        MovieEntity movies=moviesRepository.findById(scheduleEntity.getMovieId()).orElseThrow();
        TheaterEntity theater=theaterRepository.findById(scheduleEntity.getTheaterId()).orElseThrow();
        return ScheduleDto.builder()
                .movieName(scheduleEntity.getMovieName())
                .genre(movies.getGenre())
                .theaterName(theater.getTheaterName())
                .theaterLocation(theater.getLocation())
                .availableSeats(theater.getAvailableSeats())
                .time(scheduleEntity.getTime())
                .build();
    }


}
