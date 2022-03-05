package emlakburada.client;

import emlakburada.dto.request.UserRequest;
import emlakburada.dto.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "feign-client-user", url = "http://localhost:8081/users")
public interface UserClient {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ResponseEntity<List<UserResponse>> getAllUsers();

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest);

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest);

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    ResponseEntity<UserResponse> deleteUser(@PathVariable Integer id);
}