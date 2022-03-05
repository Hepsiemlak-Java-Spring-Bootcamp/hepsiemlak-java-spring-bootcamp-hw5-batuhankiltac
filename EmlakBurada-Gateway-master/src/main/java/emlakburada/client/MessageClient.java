package emlakburada.client;

import emlakburada.dto.request.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "feign-client-message", url = "http://localhost:8081/messages")
public interface MessageClient {

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    ResponseEntity<List<MessageResponse>> getAllMessages();

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    ResponseEntity<MessageResponse> createMessage(@RequestBody MessageRequest messageRequest);

    @RequestMapping(value = "/messages", method = RequestMethod.PUT)
    ResponseEntity<MessageResponse> updateMessage(@RequestBody MessageRequest messageRequest);

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.DELETE)
    ResponseEntity<MessageResponse> deleteMessage(@PathVariable Integer id);
}