package emlakburada.controller;

import emlakburada.client.AdvertClient;
import emlakburada.dto.request.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<AdvertResponse>> getAllAdverts() {
        return advertClient.getAllAdverts();
    }

    @PostMapping
    public ResponseEntity<AdvertResponse> createAdvert(@RequestBody AdvertRequest advertRequest) {
        return advertClient.createAdvert(advertRequest);
    }

    @PutMapping
    public ResponseEntity<AdvertResponse> updateAdvert(@RequestBody AdvertRequest advertRequest) {
        return advertClient.updateAdvert(advertRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdvertResponse> deleteAdvert(@PathVariable Integer id) {
        return advertClient.deleteAdvert(id);
    }
}