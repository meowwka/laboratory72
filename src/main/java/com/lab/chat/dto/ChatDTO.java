package com.lab.chat.dto;

import com.lab.chat.model.Chat;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatDTO {
    private int id;
    private String time;
    private String name;
    private int messages;
     public static ChatDTO from(Chat chat){
         return builder().id(chat.getId())
                 .name(chat.getName())
                 .time(chat.getTime().toString())
                 .messages(chat.getMessages().size()).build();
     }
}
