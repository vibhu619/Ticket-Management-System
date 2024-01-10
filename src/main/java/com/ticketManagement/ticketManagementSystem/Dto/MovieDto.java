package com.ticketManagement.ticketManagementSystem.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
public class MovieDto {
    public  String  title;
    public  String genre;
    public Integer duration_of_movie;

    public MovieDto(String title, String genre, Integer duration_of_movie) {
        this.title = title;
        this.genre = genre;
        this.duration_of_movie = duration_of_movie;
    }


}
