package com.lab.chat.dto;

import com.lab.chat.model.Message;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDTO {
    private int id;
    private String text;
    private String time;
    private String user;

    public static MessageDTO from(Message message){
        return builder().id(message.getId())
                .text(message.getText())
                .time(message.getTime().toString())
                .user(message.getUser().getName()).build();
    }
}
