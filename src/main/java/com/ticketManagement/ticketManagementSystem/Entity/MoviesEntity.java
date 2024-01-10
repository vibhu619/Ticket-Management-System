package com.ticketManagement.ticketManagementSystem.Entity;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class MoviesEntity {

    public List<MovieEntity> movies;
}
