package com.ticketManagement.ticketManagementSystem.Controller;

import com.ticketManagement.ticketManagementSystem.Dto.TheatersDto;
import com.ticketManagement.ticketManagementSystem.Entity.TheatersEntity;
import com.ticketManagement.ticketManagementSystem.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @GetMapping("/getTheater")
    public ResponseEntity<TheatersDto> getTheaters(){
        return theaterService.getTheaters();
    }


}
