package emlakburada.controller;

import emlakburada.client.BannerClient;
import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/banners")
public class BannerController {
    private final BannerClient bannerClient;

    @Autowired
    public BannerController(BannerClient bannerClient) {
        this.bannerClient = bannerClient;
    }

    @GetMapping
    public ResponseEntity<List<BannerResponse>> getAllBanners() {
        return bannerClient.getAllBanners();
    }

    @PostMapping
    public ResponseEntity<BannerResponse> createBanner(@RequestBody BannerRequest bannerRequest) {
        return bannerClient.createBanner(bannerRequest);
    }

    @PutMapping
    public ResponseEntity<BannerResponse> updateBanner(@RequestBody BannerRequest bannerRequest) {
        return bannerClient.updateBanner(bannerRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BannerResponse> deleteBanner(@PathVariable Integer id) {
        return bannerClient.deleteBanner(id);
    }
}