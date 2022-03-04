package emlakburada.controller;

import emlakburada.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserClient userClient;

    @Autowired
    public UserController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping
    public List<Object> getAllUsers() {
        return userClient.getAllUsers();
    }

    @PostMapping
    public Object createUser(@RequestBody Object object) {
        return userClient.createUser(object);
    }

    @PutMapping
    public Object updateUser(@RequestBody Object object) {
        return userClient.updateUser(object);
    }

    @DeleteMapping("/{id}")
    public Object deleteUser(@PathVariable Integer id) {
        return userClient.deleteUser(id);
    }
}