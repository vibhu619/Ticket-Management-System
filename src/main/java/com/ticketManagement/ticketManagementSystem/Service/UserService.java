package com.ticketManagement.ticketManagementSystem.Service;

import com.ticketManagement.ticketManagementSystem.Entity.UsersEntity;
import com.ticketManagement.ticketManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    public ResponseEntity<String> addUser(UsersEntity user){
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
