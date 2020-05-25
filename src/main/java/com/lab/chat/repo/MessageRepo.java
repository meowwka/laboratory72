package com.lab.chat.repo;

import com.lab.chat.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Integer> {
    Page<Message> findAllByChatId(Integer chatId, Pageable pageable);

}
