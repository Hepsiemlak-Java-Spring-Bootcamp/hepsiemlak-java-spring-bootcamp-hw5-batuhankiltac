package emlakburada.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "feign-client-message", url = "http://localhost:8081/messages")
public interface MessageClient {

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    List<Object> getAllMessages();

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    Object createMessage(@RequestBody Object object);

    @RequestMapping(value = "/messages", method = RequestMethod.PUT)
    Object updateMessage(@RequestBody Object object);

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.DELETE)
    Object deleteMessage(@PathVariable Integer id);
}