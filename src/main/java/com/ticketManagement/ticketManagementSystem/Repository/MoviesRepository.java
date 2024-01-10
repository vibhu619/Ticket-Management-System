package com.ticketManagement.ticketManagementSystem.Repository;

import com.ticketManagement.ticketManagementSystem.Entity.MovieEntity;
import com.ticketManagement.ticketManagementSystem.Entity.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoviesRepository extends JpaRepository<MovieEntity,Integer> {
    public Optional<List<MovieEntity>> findMovieEntityByGenre(String genre);
}
