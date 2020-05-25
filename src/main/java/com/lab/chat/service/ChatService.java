package com.lab.chat.service;

import com.lab.chat.dto.ChatDTO;
import com.lab.chat.dto.MessageDTO;
import com.lab.chat.model.Chat;
import com.lab.chat.repo.ChatRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChatService {
    private final ChatRepo chatRepo;
    public Page<ChatDTO> getAll(Pageable pageable) {
        return chatRepo.findAll(pageable).map(ChatDTO::from);
    }
    public ChatDTO getThemeById(Integer themeId){
        return ChatDTO.from(chatRepo.findById(themeId).get());
    }

    public Chat findThemeById(Integer themeId){
        return chatRepo.findById(themeId).get();
    }

    public void saveThemes(Chat chat){
        chatRepo.save(chat);

    }
}
