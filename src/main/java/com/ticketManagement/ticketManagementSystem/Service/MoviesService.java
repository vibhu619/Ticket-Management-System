package com.ticketManagement.ticketManagementSystem.Service;

import com.ticketManagement.ticketManagementSystem.Dto.MovieDto;
import com.ticketManagement.ticketManagementSystem.Dto.MoviesDto;
import com.ticketManagement.ticketManagementSystem.Entity.MovieEntity;
import com.ticketManagement.ticketManagementSystem.Entity.MoviesEntity;
import com.ticketManagement.ticketManagementSystem.Repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    @Autowired
    MoviesRepository moviesRepository;
    public ResponseEntity<MoviesDto> getMovies() {
        List<MovieEntity> movies=moviesRepository.findAll();
        List<MovieDto> movieDtos=movies.stream()
                .map(this::mapper)
                .toList();

        MoviesDto moviesDto=MoviesDto.builder().movieDtoList(movieDtos).build();
        return new ResponseEntity<>(moviesDto, HttpStatus.OK);
    }

    private MovieDto mapper(MovieEntity movieEntity) {
        return MovieDto.builder()
                .title(movieEntity.getTitle())
                .genre(movieEntity.getGenre())
                .duration_of_movie(movieEntity.getDurationInMin())
                .build();
    }

    public ResponseEntity<MoviesEntity> getMoviesByGenre(String genre) {
        Optional<List<MovieEntity>> movies=moviesRepository.findMovieEntityByGenre(genre);
        MoviesEntity moviesEntity=MoviesEntity.builder()
                .movies(movies.orElseThrow())
                .build();
        return new ResponseEntity<>(moviesEntity, HttpStatus.OK);
    }
}
