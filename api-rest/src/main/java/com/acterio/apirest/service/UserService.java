package com.acterio.apirest.service;

import com.acterio.apirest.dto.LoginDTO;
import com.acterio.apirest.dto.UserDTO;
import com.acterio.apirest.response.LoginResponse;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
}
