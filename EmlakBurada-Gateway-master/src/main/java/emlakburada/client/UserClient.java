package emlakburada.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "feign-client-user", url = "http://localhost:8081/users")
public interface UserClient {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<Object> getAllUsers();

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    Object createUser(@RequestBody Object object);

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    Object updateUser(@RequestBody Object object);

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    Object deleteUser(@PathVariable Integer id);
}