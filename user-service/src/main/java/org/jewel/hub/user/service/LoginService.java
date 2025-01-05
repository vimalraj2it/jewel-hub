package org.jewel.hub.user.service;

import org.jewel.hub.entity.user.AdminUser;
import org.jewel.hub.request.LoginRequestDTO;
import org.jewel.hub.response.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String greeting() {
        return "Welcome to Login service";
    }



    public LoginResponseDTO authenicate(LoginRequestDTO loginRequest) {
        LoginResponseDTO responseDTO = new LoginResponseDTO();

        AdminUser user = userDetailsService.findByUsername(loginRequest.getUserName());
        if (user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            responseDTO.setStatus(HttpStatus.FORBIDDEN);
            responseDTO.setErrorCode("INVALID_USER");
            responseDTO.setErrorMessage("Invalid username or password.");
            return responseDTO;
        }

        return responseDTO;

    }
}
