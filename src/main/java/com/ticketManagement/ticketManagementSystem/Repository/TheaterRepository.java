package com.ticketManagement.ticketManagementSystem.Repository;

import com.ticketManagement.ticketManagementSystem.Entity.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
}
