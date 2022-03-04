package emlakburada.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "feign-client-banner", url = "http://localhost:8082/banners")
public interface BannerClient {

    @RequestMapping(value = "/banners", method = RequestMethod.GET)
    List<Object> getAllBanners();

    @RequestMapping(value = "/banners", method = RequestMethod.POST)
    Object createBanner(@RequestBody Object object);

    @RequestMapping(value = "/banners", method = RequestMethod.PUT)
    Object updateBanner(@RequestBody Object object);

    @RequestMapping(value = "/banners/{id}", method = RequestMethod.DELETE)
    Object deleteBanner(@PathVariable Integer id);
}