package org.jewel.hub.order.controller;

import org.jewel.hub.request.LoginRequestDTO;
import org.jewel.hub.response.LoginResponseDTO;
import org.jewel.hub.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping
    public String greetingMessage() {
        return service.greeting();
    }

    @PostMapping("/auth")
    public LoginResponseDTO authenicate(@RequestBody LoginRequestDTO loginRequest) {
        return service.authenicate(loginRequest);
    }
}
