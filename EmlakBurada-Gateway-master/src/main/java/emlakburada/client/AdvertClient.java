package emlakburada.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "feign-client-advert", url = "http://localhost:8081/adverts")
public interface AdvertClient {

    @RequestMapping(value = "/adverts", method = RequestMethod.GET)
    List<Object> getAllAdverts();

    @RequestMapping(value = "/adverts", method = RequestMethod.POST)
    Object createAdvert(@RequestBody Object object);

    @RequestMapping(value = "/adverts", method = RequestMethod.PUT)
    Object updateAdvert(@RequestBody Object object);

    @RequestMapping(value = "/adverts/{id}", method = RequestMethod.DELETE)
    Object deleteAdvert(@PathVariable Integer id);
}