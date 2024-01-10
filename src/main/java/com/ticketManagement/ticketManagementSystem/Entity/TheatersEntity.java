package com.ticketManagement.ticketManagementSystem.Entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class TheatersEntity {
    public List<TheaterEntity> theaterEntityList;
}
