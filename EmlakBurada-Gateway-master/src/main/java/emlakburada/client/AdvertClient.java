package emlakburada.client;

import emlakburada.dto.request.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "feign-client-advert", url = "http://localhost:8081")
public interface AdvertClient {

    @RequestMapping(value = "/adverts", method = RequestMethod.GET)
    ResponseEntity<List<AdvertResponse>> getAllAdverts();

    @RequestMapping(value = "/adverts", method = RequestMethod.POST)
    ResponseEntity<AdvertResponse> createAdvert(@RequestBody AdvertRequest advertRequest);

    @RequestMapping(value = "/adverts", method = RequestMethod.PUT)
    ResponseEntity<AdvertResponse> updateAdvert(@RequestBody AdvertRequest advertRequest);

    @RequestMapping(value = "/adverts/{id}", method = RequestMethod.DELETE)
    ResponseEntity<AdvertResponse> deleteAdvert(@PathVariable Integer id);
}