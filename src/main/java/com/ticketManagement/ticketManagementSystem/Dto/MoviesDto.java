package com.ticketManagement.ticketManagementSystem.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class MoviesDto {
    public List<MovieDto> movieDtoList;
}
