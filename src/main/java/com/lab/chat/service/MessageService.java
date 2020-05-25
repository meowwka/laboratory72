package com.lab.chat.service;

import com.lab.chat.dto.MessageDTO;
import com.lab.chat.model.Chat;
import com.lab.chat.model.Message;
import com.lab.chat.repo.MessageRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Service
public class MessageService {
    private final MessageRepo messageRepo;
    public Page<MessageDTO> getMessages(Integer chatId, Pageable pageable){
        return messageRepo.findAllByChatId(chatId, pageable).map(MessageDTO::from);
    }
    public void saveC(Message message){
        messageRepo.save(message);
    }

}
