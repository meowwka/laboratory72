package com.lab.chat.service;

import com.lab.chat.dto.UserDTO;
import com.lab.chat.repo.UserRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Service
public class UserService {
    private final UserRepo userRepo;
    public UserDTO getByName(String email){
        var user = userRepo.findByName(email);
        return UserDTO.from(user);
    }
}
