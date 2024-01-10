package com.ticketManagement.ticketManagementSystem.Repository;

import com.ticketManagement.ticketManagementSystem.Entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity,Integer> {
    public List<ScheduleEntity> findByMovieName(String movieName);
}
