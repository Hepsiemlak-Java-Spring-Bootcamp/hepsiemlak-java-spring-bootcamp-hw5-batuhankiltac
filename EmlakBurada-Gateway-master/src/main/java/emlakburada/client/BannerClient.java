package emlakburada.client;

import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "feign-client-banner", url = "http://localhost:8082/banners")
public interface BannerClient {

    @RequestMapping(value = "/banners", method = RequestMethod.GET)
    ResponseEntity<List<BannerResponse>> getAllBanners();

    @RequestMapping(value = "/banners", method = RequestMethod.POST)
    ResponseEntity<BannerResponse> createBanner(@RequestBody BannerRequest bannerRequest);

    @RequestMapping(value = "/banners", method = RequestMethod.PUT)
    ResponseEntity<BannerResponse> updateBanner(@RequestBody BannerRequest bannerRequest);

    @RequestMapping(value = "/banners/{id}", method = RequestMethod.DELETE)
    ResponseEntity<BannerResponse> deleteBanner(@PathVariable Integer id);
}