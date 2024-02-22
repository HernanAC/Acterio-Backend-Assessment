package com.acterio.apirest.service;

import com.acterio.apirest.dto.LoginDTO;
import com.acterio.apirest.dto.UserDTO;
import com.acterio.apirest.response.LoginResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
    void deleteUser(Long id);
    List<String> showEmailsCount();
}
