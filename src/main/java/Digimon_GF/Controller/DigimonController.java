package Digimon_GF.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/digimon")
public class DigimonController {

    private final String BASE_URL = "https://digimon-api.vercel.app/api/digimon";
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public String getAllDigimon() {
        return sendGetRequest(BASE_URL);
    }

    @GetMapping("/name/{name}")
    public String getDigimonByName(@PathVariable String name) {
        return sendGetRequest(BASE_URL + "/name/" + name);
    }

    @GetMapping("/level/{level}")
    public String getDigimonByLevel(@PathVariable String level) {
        return sendGetRequest(BASE_URL + "/level/" + level);
    }

    private String sendGetRequest(String url) {
        return restTemplate.getForObject(url, String.class);
    }
}
