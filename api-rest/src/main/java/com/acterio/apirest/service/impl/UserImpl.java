package com.acterio.apirest.service.impl;

import com.acterio.apirest.dto.LoginDTO;
import com.acterio.apirest.dto.UserDTO;
import com.acterio.apirest.model.User;
import com.acterio.apirest.repository.UserRepository;
import com.acterio.apirest.response.LoginResponse;
import com.acterio.apirest.service.UserService;
import org.hibernate.annotations.DialectOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<String> usersEmails = new ArrayList<>();
    public List<String> usersEmailsId = new ArrayList<>();
    @Override
    public String addUser(UserDTO userDTO) {

        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );
        User user2 = userRepository.findByEmail(userDTO.getEmail());
        if(user2 != null) {
            return ("Email already registered");
        } else {
            userRepository.save(user);
            usersEmails.add(user.getEmail());
            usersEmailsId.add(user.getId().toString());
            return user.getFirstName();
        }

    }
    @Override
    public void deleteUser(Long id){
        for(int i = 0; i < usersEmails.size(); i++){
            if( usersEmailsId.get(i).equals(id.toString())){
                usersEmailsId.remove(i);
                usersEmails.remove(i);
            }
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<String> showEmailsCount(){
        List<String> finalEmails = new ArrayList<>();
        int countGmail = 0;
        int countHotmail = 0;
        int countOutlook = 0;
        int countOther = 0;
        for(int i = 0; i < usersEmails.size(); i++){
            if( usersEmails.get(i).contains("@gmail.com")   ){
                countGmail++;
            } else if( usersEmails.get(i).contains("@hotmail.com")   ){
                countHotmail++;
            } else if( usersEmails.get(i).contains("@outlook.com")   ){
                countOutlook++;
            } else{
                countOther++;
            }
        }
        finalEmails.add("Count of gmail: " + countGmail);
        finalEmails.add("Count of hotmail: " + countHotmail);
        finalEmails.add("Count of outlook: " + countOutlook);
        finalEmails.add("Count of other: " + countOther);
        return finalEmails;
    }



    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepository.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("You are logged in!", true);
                } else {
                    return new LoginResponse("Something wrong happened", false);
                }
            } else {
                return new LoginResponse("Password is incorrect. Try again please.", false);
            }
        }else {
            return new LoginResponse("Email not found. Try again please.", false);
        }
    }
}
