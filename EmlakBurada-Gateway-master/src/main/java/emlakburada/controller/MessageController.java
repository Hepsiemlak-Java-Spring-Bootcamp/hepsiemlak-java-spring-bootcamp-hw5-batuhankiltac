package emlakburada.controller;

import emlakburada.client.MessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {
    private final MessageClient messageClient;

    @Autowired
    public MessageController(MessageClient messageClient) {
        this.messageClient = messageClient;
    }

    @GetMapping
    public List<Object> getAllMessages() {
        return messageClient.getAllMessages();
    }

    @PostMapping
    public Object createMessage(@RequestBody Object object) {
        return messageClient.createMessage(object);
    }

    @PutMapping
    public Object updateMessage(@RequestBody Object object) {
        return messageClient.updateMessage(object);
    }

    @DeleteMapping("/{id}")
    public Object deleteMessage(@PathVariable Integer id) {
        return messageClient.deleteMessage(id);
    }
}