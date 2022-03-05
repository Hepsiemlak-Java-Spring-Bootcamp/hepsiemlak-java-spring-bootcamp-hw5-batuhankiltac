package emlakburada.controller;

import emlakburada.client.MessageClient;
import emlakburada.dto.request.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MessageResponse>> getAllMessages() {
        return messageClient.getAllMessages();
    }

    @PostMapping
    public ResponseEntity<MessageResponse> createMessage(@RequestBody MessageRequest messageRequest) {
        return messageClient.createMessage(messageRequest);
    }

    @PutMapping
    public ResponseEntity<MessageResponse> updateMessage(@RequestBody MessageRequest messageRequest) {
        return messageClient.updateMessage(messageRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteMessage(@PathVariable Integer id) {
        return messageClient.deleteMessage(id);
    }
}