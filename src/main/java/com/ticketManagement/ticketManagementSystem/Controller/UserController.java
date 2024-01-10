package com.ticketManagement.ticketManagementSystem.Controller;

import com.ticketManagement.ticketManagementSystem.Entity.UsersEntity;
import com.ticketManagement.ticketManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<String> addUser(@RequestBody UsersEntity user){
        return userService.addUser(user);

    }
}
