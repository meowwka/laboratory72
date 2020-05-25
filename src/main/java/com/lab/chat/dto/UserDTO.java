package com.lab.chat.dto;

import com.lab.chat.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private int id;
    private String name;

    public static UserDTO from(User user){
        return builder().id(user.getId())
                .name(user.getName()).build();
    }
}
