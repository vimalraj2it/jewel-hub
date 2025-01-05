package org.jewel.hub.user.controller;

import org.jewel.hub.entity.user.AdminUser;
import org.jewel.hub.request.UserRequestDTO;
import org.jewel.hub.response.UserResponseDTO;
import org.jewel.hub.user.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/list")
    public UserResponseDTO listUser(){
        UserResponseDTO responseDTO = new UserResponseDTO();
        List<AdminUser> userList = customUserDetailsService.getAllUser();

        responseDTO.setUser(userList);

        return responseDTO;
    }

    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody UserRequestDTO userReq) {
        UserResponseDTO responseDTO = new UserResponseDTO();

        if (customUserDetailsService.findByUsername(userReq.getUserName()) != null) {
            responseDTO.setStatus(HttpStatus.FORBIDDEN);
            responseDTO.setMessage("Username is already taken.");
            return responseDTO;
        }

        AdminUser user = new AdminUser();
        user.setUserId(userReq.getUserName());
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(userReq.getPassword()));
        user.setRole("USER"); // Default role
        customUserDetailsService.save(user);
        responseDTO.setUser(new ArrayList<>());
        responseDTO.getUser().add(user);
        return responseDTO;
    }
}
