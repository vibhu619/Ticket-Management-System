package com.ticketManagement.ticketManagementSystem.Repository;

import com.ticketManagement.ticketManagementSystem.Entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity,Integer> {

}
