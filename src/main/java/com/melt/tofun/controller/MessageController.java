package com.melt.tofun.controller;

import com.melt.tofun.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class MessageController {

    public List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{ put("id", "1"); put("text", "first message"); }});
        add(new HashMap<String, String>() {{ put("id", "2"); put("text", "second message"); }});
        add(new HashMap<String, String>() {{ put("id", "3"); put("text", "third message"); }});
    }};

    private int count = 4;

    @GetMapping("message")
    public List<Map<String, String>> list() {
        return messages;
    }

    @GetMapping("message/{id}")
    public Map<String, String> getMessageById(@PathVariable("id") String id) {
        return getMessage(id);
    }

    @PostMapping("message")
    public Map<String, String> create(@RequestBody Map<String, String> message) {
        message.put("id", String.valueOf(count++));

        messages.add(message);

        return message;
    }

    @PutMapping("message/{id}")
    public Map<String, String> update(@PathVariable("id") String id, @RequestBody Map<String, String> message) {
        Map<String, String> messageFromDb = getMessage(id);

        messageFromDb.putAll(message);
        messageFromDb.put("id", id);

        return messageFromDb;
    }

    @DeleteMapping("message/{id}")
    public void delete(@PathVariable("id") String id) {
        Map<String, String> message = getMessage(id);

        messages.remove(message);
    }

    private Map<String, String> getMessage(String id) {
        return messages.stream()
                .filter(messages -> messages.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
