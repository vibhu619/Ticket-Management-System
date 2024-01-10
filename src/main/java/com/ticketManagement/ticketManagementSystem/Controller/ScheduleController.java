package com.ticketManagement.ticketManagementSystem.Controller;

import com.ticketManagement.ticketManagementSystem.Dto.ScheduleDto;
import com.ticketManagement.ticketManagementSystem.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    //gives details of a movie name given(schedule, movie details, and theater details)
    @GetMapping("/getSchedule")
    public List<ScheduleDto> getSchedule(@RequestParam String movieName){
        return scheduleService.getSchedule(movieName);
    }
}