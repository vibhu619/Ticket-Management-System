package com.ticketManagement.ticketManagementSystem.Repository;

import com.ticketManagement.ticketManagementSystem.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity,Integer> {
    public Optional<UsersEntity> findByUsername(String username);
}
