package emlakburada.controller;

import emlakburada.client.BannerClient;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Object> getAllBanners() {
        return bannerClient.getAllBanners();
    }

    @PostMapping
    public Object createBanner(@RequestBody Object object) {
        return bannerClient.createBanner(object);
    }

    @PutMapping
    public Object updateBanner(@RequestBody Object object) {
        return bannerClient.updateBanner(object);
    }

    @DeleteMapping("/{id}")
    public Object deleteBanner(@PathVariable Integer id) {
        return bannerClient.deleteBanner(id);
    }
}