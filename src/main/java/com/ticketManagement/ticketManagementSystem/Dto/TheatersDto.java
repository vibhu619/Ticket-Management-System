package com.ticketManagement.ticketManagementSystem.Dto;

import jakarta.servlet.http.PushBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class TheatersDto {

    public List<TheaterDto> theaterDtoList;
}
