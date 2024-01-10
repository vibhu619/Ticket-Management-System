package com.ticketManagement.ticketManagementSystem.Service;

import com.ticketManagement.ticketManagementSystem.Entity.CustomUserDetails;
import com.ticketManagement.ticketManagementSystem.Entity.UsersEntity;
import com.ticketManagement.ticketManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user=userRepository.findByUsername(username).orElseThrow();
        return new CustomUserDetails(user);
    }
}
