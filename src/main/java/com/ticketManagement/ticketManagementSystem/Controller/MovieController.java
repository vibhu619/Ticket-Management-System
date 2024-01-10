package com.ticketManagement.ticketManagementSystem.Controller;

import com.ticketManagement.ticketManagementSystem.Dto.MoviesDto;
import com.ticketManagement.ticketManagementSystem.Entity.MoviesEntity;
import com.ticketManagement.ticketManagementSystem.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MoviesService moviesService;

    @GetMapping("/getMovies")
    public ResponseEntity<MoviesDto> getMovies(){
        return moviesService.getMovies();
    }

    @GetMapping("/getMoviesByGenre")
    public ResponseEntity<MoviesEntity> getMoviesByGenre(@RequestParam String genre){
        return moviesService.getMoviesByGenre(genre);
    }


}
