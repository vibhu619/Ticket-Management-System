package com.ticketManagement.ticketManagementSystem.Service;

import com.ticketManagement.ticketManagementSystem.Dto.TheaterDto;
import com.ticketManagement.ticketManagementSystem.Dto.TheatersDto;
import com.ticketManagement.ticketManagementSystem.Entity.TheaterEntity;
import com.ticketManagement.ticketManagementSystem.Entity.TheatersEntity;
import com.ticketManagement.ticketManagementSystem.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;


    public ResponseEntity<TheatersDto> getTheaters() {
        TheatersDto theatersDto=TheatersDto.builder()
                                           .theaterDtoList(getTheatersDto())
                                           .build();
        return new ResponseEntity<>(theatersDto,HttpStatus.OK);
    }

    private List<TheaterDto> getTheatersDto(){
        return theaterRepository
                .findAll()
                .stream()
                .map(this::mapper)
                .toList();

    }

    private TheaterDto mapper(TheaterEntity theaterEntity) {
        return TheaterDto.builder()
                .theaterName(theaterEntity.getTheaterName())
                .availableSeats(theaterEntity.getAvailableSeats())
                .location(theaterEntity.getLocation())
                .audiNumber(theaterEntity.getAudiNumber())
                .build();
    }
}
