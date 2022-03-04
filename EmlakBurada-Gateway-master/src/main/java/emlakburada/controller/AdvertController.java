package emlakburada.controller;

import emlakburada.client.AdvertClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adverts")
public class AdvertController {
    private final AdvertClient advertClient;

    @Autowired
    public AdvertController(AdvertClient advertClient) {
        this.advertClient = advertClient;
    }

    @GetMapping
    public List<Object> getAllAdverts() {
        return advertClient.getAllAdverts();
    }

    @PostMapping
    public Object createAdvert(@RequestBody Object object) {
        return advertClient.createAdvert(object);
    }

    @PutMapping
    public Object updateAdvert(@RequestBody Object object) {
        return advertClient.updateAdvert(object);
    }

    @DeleteMapping("/{id}")
    public Object deleteAdvert(@PathVariable Integer id) {
        return advertClient.deleteAdvert(id);
    }
}