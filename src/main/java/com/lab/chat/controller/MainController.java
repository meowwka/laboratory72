package com.lab.chat.controller;

import com.lab.chat.model.Chat;
import com.lab.chat.model.Message;
import com.lab.chat.service.ChatService;
import com.lab.chat.service.MessageService;
import com.lab.chat.service.PropertiesService;
import com.lab.chat.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MainController {
    private static <T> void constructPageable(Page<T> list, int pageSize, Model model, String uri, String themes) {
        if (list.hasNext()) {
            model.addAttribute("nextPageLink", constructPageUri(uri, list.nextPageable().getPageNumber(), list.nextPageable().getPageSize()));
        }
        if (list.hasPrevious()) {
            model.addAttribute("prevPageLink", constructPageUri(uri, list.previousPageable().getPageNumber(), list.previousPageable().getPageSize()));
        }
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        model.addAttribute(themes, list.getContent());
        model.addAttribute("defaultPageSize", pageSize);
    }
    private final ChatService chatService;
    private final PropertiesService propertiesService;
    private final UserService userService;
    private final MessageService messageService;


    private static String constructPageUri(String uri, int page, int size) {
        return String.format("%s?page=%s&size=%s", uri, page, size);
    }

    @GetMapping("/")
    public String getIndex(HttpServletRequest uriBuilder, Model model, Pageable pageable, Principal principal){
        var themes =chatService.getAll(pageable);
        var uri =uriBuilder.getRequestURI();
        constructPageable(themes, propertiesService.getDefaultPageSize(), model, uri, "chats");


        if(uriBuilder.getUserPrincipal() != null) {
            var user = userService.getByName(uriBuilder.getUserPrincipal().getName());
            model.addAttribute("user", user);
        }
        return "index";
    }
    @GetMapping("/chat/{chat_id}")
    public String themePage(@PathVariable("chat_id") Integer chat_id, Model model, Pageable pageable,
                            HttpServletRequest uriBuilder){
        model.addAttribute("chat", chatService.getThemeById(chat_id));
        var messages = messageService.getMessages(chat_id, pageable);
        var uri = uriBuilder.getRequestURI();
        constructPageable(messages, propertiesService.getDefaultPageSize(), model, uri, "mess");
        if(uriBuilder.getUserPrincipal() != null) {
            var user = userService.getByName(uriBuilder.getUserPrincipal().getName());
            model.addAttribute("user", user);
        }         return "chat";
    }
    @PostMapping("/add")
    public String addComment(@RequestParam("chat_id") Integer chatId, @RequestParam("text") String text){
        Message message = new Message();
        message.setText(text);
        message.setChat(chatService.findThemeById(chatId));
        messageService.saveC(message);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String themes(HttpServletRequest uriBuilder, Model model){
        if(uriBuilder.getUserPrincipal() != null) {
            var user = userService.getByName(uriBuilder.getUserPrincipal().getName());
            model.addAttribute("user", user);
        }

        return "create";
    }
    @PostMapping("/create")
    public String postMapping( @RequestParam String name
    ){

        Chat chat = new Chat();
        chat.setName(name);
        chatService.saveThemes(chat);

        return "redirect:/";

    }

}
