package com.ticketManagement.ticketManagementSystem;

import com.ticketManagement.ticketManagementSystem.Entity.UsersEntity;
import com.ticketManagement.ticketManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TicketManagementSystemApplication{
	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(TicketManagementSystemApplication.class, args);
	}




}
